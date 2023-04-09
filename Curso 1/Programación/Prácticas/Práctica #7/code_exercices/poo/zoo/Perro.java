package poo.zoo;

/**
 * Representa un Perro
 * @author Hugo Pelayo
 * @version 1.0
 */
public class Perro extends Animal {
    // Raza de este Perro
    private String m_Raza;

    /**
     * Inicializa este Perro a partir de los datos que se pasan como parámetros
     * Si la referencia a la raza es nula se asume desconocida
     * @param nombre Nombre para este Perro
     * @param raza Raza para este Perro
     * @param edad Edad para este Perro
     */
    public Perro(String nombre, String raza, int edad) {
        super(nombre, edad);
        m_Raza = raza == null ? "Unknown" : raza;
    }

    /**
     * Inicializa este Perro a partir de los datos que se pasan como parámetros
     * Si la referencia a la raza es nula se asume desconocida
     * @param nombre Nombre para este Perro
     * @param raza Raza para este Perro
     */
    public Perro(String nombre, String raza) {
        super(nombre);
        m_Raza = raza == null ? "Unknown" : raza;
    }

    /**
     * Inicializa este Perro como copia del que
     * se pasa como parámetro
     * @param other Perro del cual este se copia
     */
    public Perro(Perro other) {
        super(other);
        m_Raza = other.getRaza();
    }
    
    /**
     * Inicializa este Perro por defecto con
     * raza desconocida
     */
    public Perro() {
        super();
        m_Raza = "Unknown";
    }

    /**
     * Retorna la raza de este Perro
     * @return Raza de este Perro
     */
    public String getRaza() {
        return m_Raza;
    }

    /**
     * Cambia la raza de este Perro por la que se pasa como
     * parámetro. Si alreferencia es nula se marca la raza
     * como desconocida
     * @param raza Nueva raza para este Perro
     */
    public void setRaza(String raza) {
        m_Raza = raza == null ? "Unknown" : raza;
    }
}
