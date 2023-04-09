package poo.zoo;

/**
 * Representa un Animal
 * @author Hugo Pelayo
 * @version 1.0
 */
public abstract class Animal {
    // Contiene el nombre de este Animal
    private String m_Nombre;

    // Contiene los años de este Animal
    private int m_Edad;

    /**
     * Inicializa este Animal a partir de los datos que se
     * pasan como parámetros, si la refencia es nula se asume el nombre
     * es desconocido y si la edad es negativa, esta se inicializa a 0
     * @param nombre Nombre para este Animal
     * @param edad Edad para este Animal
     */
    public Animal(String nombre, int edad) {
        m_Nombre = nombre == null ? "Unknown" : nombre;
        m_Edad = edad < 0 ? 0 : edad;
    }

    /**
     * Inicializa este Animal a partir de los datos que se
     * pasan como parámetros, si la refencia es nula se asume el nombre
     * es desconocido
     * @param nombre Nombre para este Animal
     */
    public Animal(String nombre) {
        m_Nombre = nombre == null ? "Unknown" : nombre;
        m_Edad = 0;
    }

    /**
     * Inicializa este animal como copia del que se pasa
     * como parámetro
     * @param other
     */
    public Animal(Animal other) {
        this(other.getNombre(), other.getEdad());
    }

    /**
     * Inicializa este Animal con nombre desconocido
     * y la edad a 0
     */
    public Animal() {
        m_Nombre = "Unknown";
        m_Edad = 0;
    }

    /**
     * Retorna el nombre de este Animal
     * @return Nombre de este Animal
     */
    public String getNombre() {
        return m_Nombre;
    }

    /**
     * Cambia el nombre de este Animal por el que
     * se pasa como parámetro. Si la referencia es nula,
     * esta función no tiene efecto
     * @param nombre Nuevo nombre para este Animal
     */
    public void setNombre(String nombre) {
        if (nombre != null)
            m_Nombre = nombre;
        else    
            System.out.println("Error: referencia nula setNombre()...");
    }

    /**
     * Retorna la edad en años de este Animal
     * @return Edad de este Animal
     */
    public int getEdad() {
        return m_Edad;
    }

    /**
     * Cambia la edad de este Animal por la que
     * se pasa como parámetro, si la edad es negativa
     * esta función no tiene efecto
     * @param edad
     */
    public void setEdad(int edad) {
        if (edad >= 0) 
            m_Edad = edad;
        else
            System.out.println("Error: edad negativa setEdad()...");
    }

    /**
     * Retorna cierto si este Animal y el que se pasa por parámetro son el mismo.
     * Se consideran dos animales iguales si tienen el mismo
     * nombre y la misma edad
     * @param other Animal con que se compara este
     * @return Cierto si son el mismo, falso en caso contrario
     */
    public boolean equals(Animal other) {
        return m_Nombre.equalsIgnoreCase(other.getNombre()) && m_Edad == other.getEdad();
    }
}
