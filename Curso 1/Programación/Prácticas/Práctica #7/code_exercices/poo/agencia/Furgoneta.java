package poo.agencia;

public class Furgoneta extends Vehiculo {
    // capacidad interior en litros
    private double m_Capacidad;
    
    public Furgoneta(String matricula, String marca, String modelo, double potencia, double capacidad) {
        super(matricula, marca, modelo, potencia);
        m_Capacidad = capacidad;
    }
    public double getCapacidad() {
        return m_Capacidad;
    }

    public void setCapacidad(double capacidad) {
        if (!(capacidad < .0))
            m_Capacidad = capacidad;
        else 
            System.out.println("Valor de capacidad negativo");
    }


    
}
