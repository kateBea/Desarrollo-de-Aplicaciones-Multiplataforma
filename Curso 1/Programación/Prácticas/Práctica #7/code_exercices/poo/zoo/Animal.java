package poo.zoo;

public abstract class Animal {
    private String m_Nombre;

    // edad en años
    private int m_Edad;

    public Animal(String nombre, int edad) {
        m_Nombre = nombre == null ? "Unknown" : nombre;
        m_Edad = edad < 0 ? 0 : edad;
    }

    public Animal(String nombre) {
        m_Nombre = nombre == null ? "Unknown" : nombre;
        m_Edad = 0;
    }

    public Animal(Animal other) {
        this(other.getNombre(), other.getEdad());
    }

    public Animal() {
        m_Nombre = "Unknown";
        m_Edad = 0;
    }

    public String getNombre() {
        return m_Nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null)
            m_Nombre = nombre;
    }

    public int getEdad() {
        return m_Edad;
    }

    public void setEdad(int edad) {
        if (edad >= 0) 
            m_Edad = edad;
    }

    public boolean equals(Animal other) {
        return m_Nombre.equalsIgnoreCase(other.getNombre()) && m_Edad == other.getEdad();
    }
}
