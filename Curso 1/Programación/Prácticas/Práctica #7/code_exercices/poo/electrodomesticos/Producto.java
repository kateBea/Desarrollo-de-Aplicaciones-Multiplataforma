package poo.electrodomesticos;

public abstract class Producto {
    private String m_Fabricante;
    private String m_NumeroSerie;
    private double m_Precio;

    public Producto(String fabricante, String serie, double precio) {
        m_Fabricante = fabricante;
        m_NumeroSerie = serie;
        m_Precio = precio < 0.0 ? 0.0 : precio;
    }

    public String getFabricante() {
        return m_Fabricante;
    }

    public void setFabricante(String nombre) {
        if (nombre != null)
            m_Fabricante = nombre;
    }

    public String getNumeroSerie() {
        return m_NumeroSerie;
    }

    public void setNumeroSerie(String serie) {
        if (serie != null)
            m_NumeroSerie = serie;
    }

    public double getPrecio() {
        return m_Precio;
    }

    public void setPrecio(double precio) {
        if (!(precio < 0.0))
            m_Precio = precio;
    }

    public boolean equals(Producto other) {
        return m_Fabricante.equalsIgnoreCase(other.getFabricante()) &&
                m_NumeroSerie.equalsIgnoreCase(other.getNumeroSerie());
    }
}
