package proveedor;

/**
 * <p>Representa un producto</p>
 *
 * @author Hugo Pelayo
 * @version 1.0
 * */
public class Producto {
    private String m_Nombre;
    private double m_Precio;
    private int m_Stock;

    public Producto(Producto other) {
        this(other.m_Nombre, other.m_Precio, other.m_Stock);
    }

    public Producto(String nombre, double precio, int cantidad) {
        m_Nombre = nombre;
        m_Precio = precio;
        m_Stock = cantidad;
    }

    public String getNombre() {
        return m_Nombre;
    }

    public int getCantidad() {
        return m_Stock;
    }

    public void setCantidad(int cantidad) {
        m_Stock = cantidad;
    }
}
