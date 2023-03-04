package proveedor;

import java.util.ArrayList;

/**
 * <p>Representa una Tienda</p>
 *
 * @author Hugo Pelayo
 * @version 1.0
 * */
public class Tienda {
    // Representa el nombre de la tienda
    private String m_Nombre;
    // Representa la lista de productos de la tienda
    private ArrayList<Producto> m_Productos;

    /**
     * Constructora parametrizada. Inicializa los datos de esta tienda
     * a partir de los que se pasan como parámetro
     * @param nombre Nombre de esta tienda
     * @param productos Lista de productos de esta tienda
     * */
    public Tienda(String nombre, ArrayList<Producto> productos) {
        m_Nombre = nombre;
        m_Productos = productos;
    }

    /**
     * Constructora parametrizada. Inicializa los datos de esta tienda
     * a partir de los que se pasan como parámetro. La lista de productos está vacía
     * @param nombre Nombre de esta tienda
     * */
    public Tienda(String nombre) {
        m_Nombre = nombre;
        m_Productos =  new ArrayList<>();
    }

    /**
     * Constructora parametrizada. Inicializa los datos de esta tienda
     * a partir de la tienda que se pasa por parámetro
     * @param other Tienda a partir de la cual se inicializa el parámetro implícito
     * */
    public Tienda(Tienda other) {
        this(other.m_Nombre, other.m_Productos);
    }

    /**
     * Devuelve el nombre de esta tienda
     * @return Nombre del parámetro implícito
     * */
    public String getNombre() {
        return m_Nombre;
    }

    /**
     * Reemplaza el nombre del parámetro implícito por el que se pasa
     * parámetro. Si la referencia es nula esta función no tiene efectos y
     * se muestra por pantalla un mensaje apropiado
     * @param nombre Nuevo nombre de esta tienda
     * */
    public void setNombre(String nombre) {
        if (nombre != null)
            m_Nombre = nombre;
        else
            System.out.println("El nombre de referencia no puede ser nulo.");
    }

    public ArrayList<Producto> getProductos() {
        return m_Productos;
    }

    /**
     * Reemplaza la lista de productos del parámetro implícito por la que se pasa
     * parámetro. Si la referencia es nula esta función no tiene efectos y
     * se muestra por pantalla un mensaje apropiado
     * @param productos Nuevo nombre de esta tienda
     * */
    public void setProductos(ArrayList<Producto> productos) {
        if (productos != null)
            m_Productos = productos;
        else
            System.out.println("La lista de productos de referencia no puede ser nula.");
    }

    /**
     * Reemplaza la lista de productos del parámetro implícito por la que se pasa
     * parámetro. Si la referencia es nula esta función no tiene efectos y
     * se muestra por pantalla un mensaje apropiado
     * @param productos Nuevo nombre de esta tienda
     * */
    public void setProductos(Producto[] productos) {
        if (productos != null) {
            for (Producto p : productos)
                m_Productos.add(new Producto(p));
        }
        else
            System.out.println("La lista de productos de referencia no puede ser nula.");
    }

    public Producto getProducto(String nombre) {
        int indice = 0;
        // Inicializa a falso porque se va a buscar
        boolean encontrado = false;

        while (indice < m_Productos.size() && !encontrado)
            encontrado = m_Productos.get(indice++).getNombre().equalsIgnoreCase(nombre);

        return encontrado ? m_Productos.get(indice) : null;
    }

    public void addProducto(Producto p) {
        int indice = 0;
        // Inicializa a falso porque se va a buscar
        boolean encontrado = false;

        while (indice < m_Productos.size() && !encontrado)
            encontrado = m_Productos.get(indice++).getNombre().equalsIgnoreCase(p.getNombre());

        if (encontrado) {
            m_Productos.get(indice - 1).setCantidad(m_Productos.get(indice - 1).getCantidad() + p.getCantidad());
        }
        else {
            m_Productos.add(new Producto(p));
        }
    }

}
