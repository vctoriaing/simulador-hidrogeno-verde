
package modelo;
public class ModeloElectrolisis {
    private static final double constanteFaraday = 96485.3;
    private static final double electronesH2 = 2.0;          
    private static final double masaMolarH2 = 2.016;         
    private static final double rGases = 0.0821;             
    private static final double joulesPerKwh = 3600000.0;    
    private static final double LHV_H2_KWH_KG = 33.3;        

    public ModeloElectrolisis() {
    }
    
    public ResultadoSimulado simular(ParametroSimulado parametros) {
        
        ResultadoSimulado resultados = new ResultadoSimulado();
        
        // 1. Cálculos Químicos (Producción de H2 - Ley de Faraday) 
        double cargaTotalC = parametros.getCorriente() * parametros.getTiempo();
        double molesH2 = (cargaTotalC / (constanteFaraday * electronesH2)) * parametros.getEficiencia();
        resultados.setMolesH2(molesH2);
        
        // Masa H2 (kg)
        double masaH2_kg = (molesH2 * masaMolarH2) / 1000.0;
        resultados.setMasaH2(masaH2_kg);
        
        // 2. Cálculos de Volumen (Gases Ideales) 
        double volumenH2L = (molesH2 * rGases * parametros.getTemperatura()) / 1.0; 
        resultados.setVolumenH2(volumenH2L);
        
        // 3. Cálculos Energéticos y Ambientales
        double energiaJ = parametros.getVoltaje() * parametros.getCorriente() * parametros.getTiempo();
        double energiaKwh = energiaJ / joulesPerKwh;
        resultados.setEnergia_consumida(energiaKwh);
        
        // A. Energía Útil/Química contenida en el H2 producido (kWh)
        double energiaUtilH2Kwh = masaH2_kg * LHV_H2_KWH_KG;
        
        // B. Eficiencia Energética Total
        double eficienciaEnergetica = 0.0;
        if (energiaKwh > 0) {
            eficienciaEnergetica = energiaUtilH2Kwh / energiaKwh;
        }
        resultados.setEficiencia_energetica(eficienciaEnergetica);
        
        // C. CO2 Evitado (Basado en la energía útil del H2)
        double co2EvitadoKg = energiaUtilH2Kwh * parametros.getFactorCO2();
        resultados.setCo2_evitado(co2EvitadoKg);
        
        return resultados;
    }
}