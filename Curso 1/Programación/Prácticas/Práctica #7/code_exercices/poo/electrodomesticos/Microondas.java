package poo.electrodomesticos;

/**
 * Representa un Microondas
 * @author Hugo Pelayo
 * @version 1.0
 */
public class Microondas extends Producto {
    // Potencia en vatios (W) de este Microondas
    private double m_Potencia;

    /**
     * Inicializa esta Microondas a partir de los datos que
     * se pasan como paramétro, si las referencias son nulas se asume
     * que sus valores son desconocidos para este Microondas.
     * Si la potencia es negativa esta se inicializa a 0
     * @param fabricante Fabricante para este Microondas
     * @param serie Número de serie para este Microondas
     * @param precio Precio para este Microondas
     * @param potencia Capacidad en litros para este Microondas
     */
    public Microondas(String fabricante, String serie, double precio, double potencia) {
        super(fabricante, serie, precio);
        m_Potencia = potencia < 0.0 ? 0.0 : potencia;
    } 

    /**
     * Retorna la potencia de este Microondas
     * @return potencia en vatios
     */
    public double getPotencia() {
        return m_Potencia;
    }

    /**
     * Cambia la potencia de este Microondas por la que se pasa 
     * como parámetro, si el valor es negativo esta función no 
     * tiene efectos
     * @param potencia Nueva potencia para este Microondas
     */
    public void setPotencia(double potencia) {
        if (!(potencia < 0.0))
            m_Potencia = potencia;
        else
            System.out.println("Error valor negativo de potencia en setPotencia()...");
    }
}
