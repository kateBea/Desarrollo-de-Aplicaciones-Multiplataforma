package poo.electrodomesticos;

/**
 * Representa un Televisor
 * @author Hugo Pelayo
 * @version 1.0
 */
public class Televisor extends Producto {
    // Tamaño en pulgadas de este Televisor
    private float m_Pulgadas;

    /**
     * Inicializa esta Televisor a partir de los datos que
     * se pasan como paramétro, si las referencias son nulas se asume
     * que sus valores son desconocidos para este Televisor.
     * Si el valor de pulgadas es negativo, estas se inicializa a 0
     * @param fabricante Fabricante para este Televisor
     * @param serie Número de serie para este Televisor
     * @param precio Precio para este Televisor
     * @param pulgadas Valor de pulgadas para este Televisor
     */
    public Televisor(String fabricante, String serie, double precio, float pulgadas) {
        super(fabricante, serie, precio);
        m_Pulgadas = pulgadas < 0.0f ? 0.0f : pulgadas;
    } 

    /**
     * Retorna el número de pulgadas de este Televisor
     * @return Tamaño en pulgadas
     */
    public float getPulgadas() {
        return m_Pulgadas;
    }

    /**
     * Cambia las pulgadas de este Televisor por las que se pasan 
     * como parámetro, si el valor es negativo esta función no 
     * tiene efectos
     * @param potencia Nuevo valor de pulgadas para este Televisor
     */
    public void setPulgadas(float pulgadas) {
        if (!(pulgadas < 0.0))
            m_Pulgadas = pulgadas;
        else
            System.out.println("Error valor negativo de pulgadas en setPulgadas()...");
    }
    
}
