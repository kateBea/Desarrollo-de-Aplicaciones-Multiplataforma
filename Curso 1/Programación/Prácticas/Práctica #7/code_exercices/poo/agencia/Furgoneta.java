package poo.agencia;

/**
 * Representa una Furgoneta
 * @author Hugo Pelayo
 * @version 1.0
 */
public class Furgoneta extends Vehiculo {
    // Capacidad interior de esta Furgoneta en litros
    private double m_Capacidad;

    // Valor de capacidad mínima en litros de cualquier Furgoneta
    private static final double CAPACIDAD_MINIMA = 1029.0;
    
    /**
     * Inicializa este Furgoneta con los valores que se pasa 
     * como parámetros. Si las referencias son nulas, se consideran
     * desconocidos y, en caso de ser negativa la potencia, esta se inicializa a 0
     * @param matricula Matrícula para esta Furgoneta
     * @param marca Marca para esta Furgoneta
     * @param modelo Modelo para esta Furgoneta
     * @param potencia Caballos de potencia para esta Furgoneta
     * @param capacidad Capacidad en litros para esta Furgoneta
     */
    public Furgoneta(String matricula, String marca, String modelo, double potencia, double capacidad) {
        super(matricula, marca, modelo, potencia);
        m_Capacidad = capacidad < .0 ? CAPACIDAD_MINIMA : capacidad;
    }

    /**
     * Retorna la capacidad en litros de esta Furgoneta
     * @return Capacidad en litros de esta Furgoneta
     */
    public double getCapacidad() {
        return m_Capacidad;
    }

    /**
     * Cambia la capacidad de esta furgoneta por la que se pasa
     * como parámetro, si el valor es negativo, esta función no tiene 
     * efecto
     * @param capacidad Nueva capacidad en litros para esta Furgoneta
     */
    public void setCapacidad(double capacidad) {
        if (!(capacidad < .0))
            m_Capacidad = capacidad;
        else 
            System.out.println("Valor de capacidad negativo");
    }
}
