package poo.electrodomesticos;

/**
 * Representa un Producto genérico
 * @author Hugo Pelayo
 * @version 1.0
 */
public abstract class Producto {
    private String m_Fabricante;
    private String m_NumeroSerie;
    private double m_Precio;

    /**
     * Inicializa esta Producto a partir de los datos que
     * se pasan como paramétro, si las referencias son nulas se asume
     * que sus valores son desconocidos para este Producto. Si el precio
     * es negativo, este se inicializa a 0
     * @param fabricante Fabricante para este Producto
     * @param serie Número de serie para este Producto
     * @param precio Precio para este Producto
     */
    public Producto(String fabricante, String serie, double precio) {
        m_Fabricante = fabricante == null ? "Unknown" : fabricante;
        m_NumeroSerie = serie == null ? "Unknown" : serie;
        m_Precio = precio < 0.0 ? 0.0 : precio;
    }

    /**
     * Retorna el nombre de fabricante de este Producto
     * @return Fabricante de este Producto
     */
    public String getFabricante() {
        return m_Fabricante;
    }

    /**
     * Establece el nombre del fabricante de este Producto,
     * si la referencia es nula, el fabricante se marca como desconocido
     * @param nombre Nuevo nombre de fabricante para este Producto
     */
    public void setFabricante(String nombre) {
        m_Fabricante = nombre == null ? "Unknown" : nombre;
    }

    /**
     * Retorna el número de serie de este Producto
     * @return Número de serie
     */
    public String getNumeroSerie() {
        return m_NumeroSerie;
    }

    /**
     * Establece el número de serie de este Producto,
     * si la referencia es nula, el número de serie se marca como desconocido
     * @param serie Nuevo número de serie para este Producto
     */
    public void setNumeroSerie(String serie) {
        m_NumeroSerie = serie == null ? "Unknown" : serie;
    }

    /**
     * Retorna el precio de este Producto
     * @return Precio de este Producto
     */
    public double getPrecio() {
        return m_Precio;
    }

    /**
     * Cambia el precio de este Producto. Si el parámetro
     * es nulo, esta función no tiene efectos
     * @param precio Nuevo precio para este Producto
     */
    public void setPrecio(double precio) {
        if (!(precio < 0.0))
            m_Precio = precio;
        else
            System.out.println("Error valor de precio negativo en setPotencia()...");
    }

    /**
     * Compara si este producto es igual a otro producto, 
     * en cuyo caso retorna cierto y falso en caso contrario
     * @param other Otro producto con el que se quiere comparar
     * @return verdadero si ambos productos tienen el mismo fabricante y número de serie, de lo contrario, falso
     */
    public boolean equals(Producto other) {
        return m_Fabricante.equalsIgnoreCase(other.getFabricante()) &&
                m_NumeroSerie.equalsIgnoreCase(other.getNumeroSerie());
    }
}
