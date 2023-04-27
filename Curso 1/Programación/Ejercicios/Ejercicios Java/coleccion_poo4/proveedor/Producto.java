package  coleccion_poo4.proveedor;

/**
 * <p>Representa un producto</p>
 *
 * @author Hugo Pelayo
 * @version 1.0
 * */
public class Producto {
    // Representa el nombre de este producto
    private String m_Nombre;
    // Representa el precio de este producto
    private double m_Precio;
    // Representa la cantidad de este producto
    private int m_Stock;

    /**
     * Inicializa el parámetro implícito a partir del producto
     * que se pasa como parámetro
     * @param other producto del que se hace copia
     * */
    public Producto(Producto other) {
        this(other.m_Nombre, other.m_Precio, other.m_Stock);
    }

    /**
     * Inicializa este producto a partir de los datos que se
     * pasa como parámetros
     * @param nombre nombre de este producto
     * @param precio precio de este producto
     * @param cantidad cantidad de este producto
     * */
    public Producto(String nombre, double precio, int cantidad) {
        m_Nombre = nombre;
        m_Precio = Math.max(precio, 0.0); // Probar si el parámetro es negativo
        m_Stock = Math.max(cantidad, 0); // Probar si el parámetro es negativo
    }

    /**
     * Devuelve el nombre de este producto
     * @return nombre de este producto
     * */
    public String getNombre() {
        return m_Nombre;
    }

    /**
     * Reemplaza el nombre de este producto por el que se pasa como parámetro
     * @param nombre nuevo nombre de este producto
     * */
    public void setNombre(String nombre) {
        if (nombre == null) {
            System.out.println("Referencia de nombre nula...");
            return;
        }

        m_Nombre = nombre;
    }

    /**
     * Devuelve la cantidad de este producto
     * @return cantidad de este producto
     * */
    public int getCantidad() {
        return m_Stock;
    }

    /**
     * Reemplaza la cantidad de este producto por la que se pasa como parámetro
     * @param cantidad nueva cantidad de este producto
     * */
    public void setCantidad(int cantidad) {
        m_Stock = cantidad;
    }

    /**
     * Devuelve el precio de este producto
     * @return precio de este producto
     * */
    public double getPrecio() { return m_Precio; }

    /**
     * Reemplaza el precio de este producto por el que se pasa como parámetro
     * @param precio nuevo precio de este producto
     * */
    public void setPrecio(double precio) {
        if (precio < 0.0) {
            System.out.println("Valor de precio inválido...");
            return;
        }

        m_Precio = precio;
    }
}
