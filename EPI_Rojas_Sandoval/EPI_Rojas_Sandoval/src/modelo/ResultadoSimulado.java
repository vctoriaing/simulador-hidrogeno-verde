
package modelo;


public class ResultadoSimulado {
    private double molesH2, masaH2, volumenH2, energia_consumida, co2_evitado, eficiencia_energetica;

    public ResultadoSimulado() {
    }

    public ResultadoSimulado(double molesH2, double masaH2, double volumenH2, double energia_consumida, double co2_evitado,double eficiencia_energetica) {
        this.molesH2 = molesH2;
        this.masaH2 = masaH2;
        this.volumenH2 = volumenH2;
        this.energia_consumida = energia_consumida;
        this.co2_evitado = co2_evitado;
        this.eficiencia_energetica = eficiencia_energetica;
    }

    public double getMolesH2() {
        return molesH2;
    }

    public void setMolesH2(double molesH2) {
        this.molesH2 = molesH2;
    }

    public double getMasaH2() {
        return masaH2;
    }

    public void setMasaH2(double masaH2) {
        this.masaH2 = masaH2;
    }

    public double getVolumenH2() {
        return volumenH2;
    }

    public void setVolumenH2(double volumenH2) {
        this.volumenH2 = volumenH2;
    }

    public double getEnergia_consumida() {
        return energia_consumida;
    }

    public void setEnergia_consumida(double energia_consumida) {
        this.energia_consumida = energia_consumida;
    }

    public double getCo2_evitado() {
        return co2_evitado;
    }

    public void setCo2_evitado(double co2_evitado) {
        this.co2_evitado = co2_evitado;
    }
    public double getEficiencia_energetica() {
        return eficiencia_energetica;
    }

    public void setEficiencia_energetica(double eficiencia_energetica) {
        this.eficiencia_energetica = eficiencia_energetica;
    }
    
    
    public String mostrar_datosCadena() {
        String s="";
        s = s + "Moles H2: " + this.molesH2 +" moles"+ "\n";
        s = s + "Masa H2: " + this.masaH2 + " kg"+ "\n";
        s = s + "Volumen H2: " + this.volumenH2 + " L" + "\n";
        s = s + "Energia consumida: " + this.energia_consumida+ " kWh" + "\n";
        s = s + "Eficiencia Energética: " + this.eficiencia_energetica * 100 + " %\n";
        s = s + "CO2 evitado: " + this.co2_evitado + " kg"+ "\n";                      
        return s;
    }
    public void mostrar_datos() {
        System.out.println( mostrar_datosCadena());
    }
}
    

