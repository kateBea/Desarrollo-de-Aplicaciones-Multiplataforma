package poo.zoo;

/**
 * Representa un Pájaro
 * @author Hugo Pelayo
 * @version 1.0
 */
public class Pajaro extends Animal {
    // Color de este Pájaro
    private String m_Color;

    /**
     * Inicializa este Pájaro a partir de los datos que se
     * pasan como parámetro
     * @param nombre Nombre para este Pájaro
     * @param color Color para este Pájaro
     * @param edad Edad para este Pájaro
     */
    public Pajaro(String nombre, String color, int edad) {
        super(nombre, edad);
        m_Color = color;
    }

    /**
     * Inicializa este Pájaro a partir de los datos que se
     * pasan como parámetro
     * @param nombre Nombre para este Pájaro
     * @param color Color para este Pájaro
     */
    public Pajaro(String nombre, String color) {
        super(nombre);
        m_Color = color;
    }

    /**
     * Inicializa este Pájaro como copia del
     * que se pasa como parámetro
     * @param other Pájaro del cual este es copia
     */
    public Pajaro(Pajaro other) {
        super(other);
        m_Color = other.getColor();
    }

    /**
     * Inicializa este Pájaro por defecto con un color desconocido
     */
    public Pajaro() {
        super();
        m_Color = "Unknown";
    }

    /**
     * Retorna el color de este Pájaro
     * @return Color de este Pájaro
     */
    public String getColor() {
        return m_Color;
    }

    /**
     * Cambia el color de este pájaro por el que se pasa
     * como parámetro, si la referencia es nula se marca
     * el color como desconocido
     * @param color Nuevo color para este Pájaro
     */
    public void setColor(String color) {
        if (color != null)
            m_Color = color;
        else 
            m_Color = "Unknown";
    }
}
