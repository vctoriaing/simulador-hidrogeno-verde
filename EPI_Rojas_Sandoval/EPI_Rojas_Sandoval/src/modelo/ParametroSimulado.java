
package modelo;


public class ParametroSimulado {
    private static final double EFICIENCIA_DEFAULT = 0.90;    // 90%
    private static final double TEMPERATURA_DEFAULT = 298.15; // 25°C en Kelvin
    private static final double FACTOR_CO2_DEFAULT = 0.85;
    
    private double corriente, tiempo, voltaje, eficiencia, temperatura, factorCO2; 

    public ParametroSimulado() {
        this.eficiencia = EFICIENCIA_DEFAULT;
        this.temperatura = TEMPERATURA_DEFAULT;
        this.factorCO2 = FACTOR_CO2_DEFAULT;
    }
       

    public ParametroSimulado(double corriente, double tiempo, double voltaje, double eficiencia, double temperatura, double factorCO2) {
        this.corriente = corriente;
        this.tiempo = tiempo;
        this.voltaje = voltaje;
        this.eficiencia = eficiencia;
        this.temperatura = temperatura;
        this.factorCO2 = factorCO2;

    }

    public double getCorriente() {
        return corriente;
    }

    public void setCorriente(double corriente) {
        this.corriente = corriente;
    }

    public double getTiempo() {
        return tiempo;
    }

    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }

    public double getVoltaje() {
        return voltaje;
    }

    public void setVoltaje(double voltaje) {
        this.voltaje = voltaje;
    }

    public double getEficiencia() {
        return eficiencia;
    }

    public void setEficiencia(double eficiencia) {
        this.eficiencia = eficiencia;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public double getFactorCO2() {
        return factorCO2;
    }

    public void setFactorCO2(double factorCO2) {
        this.factorCO2 = factorCO2;
    }

    public String mostrar_datosCadena() {
        String s="";
        s = s + "DATOS" +"\n"; 
        s = s + "Corriente: " + this.corriente + "A\n";
        s = s + "Tiempo: " + this.tiempo + "s\n";
        s = s + "Voltaje: " + this.voltaje + "V\n";
        s = s + "Eficiencia: " + (this.eficiencia* 100) + "%\n";
        s = s + "Temperatura: " + this.temperatura + "K\n";     
        s = s + "FactorCO2: " + this.factorCO2 + "\n";                
        return s;
    }
    public void mostrar_datos() {
        System.out.println( mostrar_datosCadena());
    }
}
