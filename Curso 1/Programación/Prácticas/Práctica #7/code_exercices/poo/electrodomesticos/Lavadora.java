package poo.electrodomesticos;

/**
 * Representa una Lavadora
 * @author Hugo Pelayo
 * @version 1.0
 */
public class Lavadora extends Producto {
    // Capacidad en kilogramos de esta Lavadora
    private double m_Capacidad;
    
    /**
     * Inicializa esta Lavadora a partir de los datos que
     * se pasan como paramétro, si las referencias son nulas se asume
     * que sus valores son desconocidos para esta Lavadora.
     * Si la capacidad es negativa esta se inicializa a 0
     * @param fabricante Fabricante para esta Lavadora
     * @param serie Número de serie para esta Lavadora
     * @param precio Precio para esta Lavadora
     * @param capacidad Capacidad en litros para esta Lavadora
     */
    public Lavadora(String fabricante, String serie, double precio, double capacidad) {
        super(fabricante, serie, precio);
        m_Capacidad = capacidad < 0.0 ? 0.0 : capacidad;
    } 

    /**
     * Retorna la capacidad en litros de esta Lavadora
     * @return Capacidad en litros
     */
    public double getCapacidad() {
        return m_Capacidad;
    }

    /**
     * Cambia la capacidad en litros por la que se pasa 
     * como parámetro, si el valor es negativo esta función no 
     * tiene efectos
     * @param capacidad Nueva capacidad para esta Lavadora
     */
    public void setCapacidad(double capacidad) {
        if (!(capacidad < 0.0))
            m_Capacidad = capacidad;
        else
            System.out.println("Error valor negativo de capacidad en setCapacidad()...");
    }
}
