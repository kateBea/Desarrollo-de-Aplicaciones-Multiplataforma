package taller;

import java.util.Comparator;

/**
 * <h2>Representa una pieza</h2>
 * 
 * Para más clases:
 * <a href="https://github.com/kateBea/Desarollo-de-Aplicaciones-Multiplataforma">GitHub ref</a>
 * 
 * Esta clase representa una pieza. Se trata de un componente que puede formar
 * parte de un objeto como es el vehículo. Y se caracteriza por tener un nombre
 * y precio. Dentro de un Taller el precio de una pieza hace referencia al <b>coste
 * de reparación por hora</b>. Los atributos se pueden modificar una vez inicializado
 * el objeto y se pueden proveer en el momento de la construcción con los métodos adecuados.
 * 
 * @author Hugo Pelayo
 * @version 1.0
 */


public class Pieza {
    // nombre de la pieza
    private String m_Nombre;
    // precio de reparación
    private double m_Precio;
    
    /**
     * Implementa la comparación entre dos objetos de tipo Pieza.
     * Se puede utilizar a para instanciar colecciones
     * de Piezas donde se requiere de un comparador
     */
    public static class ComparadorPiezas implements Comparator<Pieza> {
        public int compare(Pieza rhs, Pieza lhs) {
            return rhs.getNombre().compareTo(lhs.getNombre());
        }
    }

    /**
     * Realiza una ocstrucción por copia, es decir, inicializa esta 
     * los atributos de esta Pieza como copias de los atributos de la Pieza que
     * se pasa como parámetro
     * 
     * @param otra pieza de la cual se crea una copia
     */
    public Pieza(Pieza otra) {
        m_Nombre = otra.getNombre();
        m_Precio = otra.getPrecio();
    }

    /**
     * Construye un objeto copia por defecto con un nombre vacio (no nulo)
     * y un precio 0
     */
    public Pieza() {
        m_Nombre = "";
        m_Precio = 0.0;
    }

    /**
     * Construye esta copia a partir de los atributos que so 
     * pasan por parámetro. Si el precio es negativo, éste se
     * inicializa a cero
     * 
     * @param nombre nombre de la pieza
     * @param precio  precio de la pieza
     */
    public Pieza(String nombre, double precio) {
        m_Nombre = nombre;
        m_Precio = precio < 0.0 ? 0.0 : precio;
    }

    /**
     * Cambia el nombre de esta pieza al nombre que se pasa por parámetro,
     * si el parámetro es nulo, no se realiza ningún cambio
     * 
     * @param nombre nombre a ser cambiado
     */
    public void setNombre(String nombre) {
        if (nombre != null)
            m_Nombre = nombre;
    }

    /**
     * Devuelve el nombre de esta pieza
     * 
     * @return el nombre de est pieza
     */
    public String getNombre() {
        return m_Nombre;
    }

    /**
     * Cambia el precio de esta pieza al precio que se pasa por parámetro.
     * Si el precio que se pasa por parámetro es negativo, no se realiza ningún cambio.
     * 
     * @param precio
     */
    public void setPrecio(double precio) {
        if (precio < 0.0) {
            System.out.println("Precio no válido.");
            return;
        }

        m_Precio = precio;
    }

    /**
     * Devuelve el precio de esta pieza
     * 
     * @return el precio de esta pieza
     */
    public double getPrecio() {
        return m_Precio;
    }

    /**
     * Devuelve una cadena formateada que representa en una línea el nombre de esta pieza
     * y en otra línea el precio. En otra línea añade una tira de guines como separadores
     * 
     * @return el String formateado
     */
    @Override
    public String toString() {
        return String.format("Nombre de pieza: %s\n" +
                            "Precio de reparación: %s\n" +
                            "------------------------------", m_Nombre, m_Precio);
    }

    /**
     * Devuelve una cadena de caracteres formateada representando el nombre y precio
     * de esta pieza en una misma línea
     * 
     * @return el String formateado
     */
    public String toStringOnLine() {
        return String.format("Nombre: [ %s ], Precio: [ %.3f ]", m_Nombre, m_Precio);
    }
}
