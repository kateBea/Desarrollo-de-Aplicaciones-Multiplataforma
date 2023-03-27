package poo.zoo;

public class Perro extends Animal {
    private String m_Raza;

    public Perro(String nombre, String raza, int edad) {
        super(nombre, edad);
        m_Raza = raza;
    }

    public Perro(String nombre, String raza) {
        super(nombre);
        m_Raza = raza;
    }

    public Perro(Perro other) {
        super(other);
        m_Raza = other.getRaza();
    }
    
    public Perro() {
        super();
        m_Raza = "Unknown";
    }

    public String getRaza() {
        return m_Raza;
    }

    public void setRaza(String raza) {
        if (raza != null)
            m_Raza = raza;
    }
}
