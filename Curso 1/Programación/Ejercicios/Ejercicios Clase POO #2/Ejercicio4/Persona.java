package Ejercicio4;

public class Persona {
    // representa una persona

    private String m_Nombre;
    private String m_Apellido1;
    private String m_Apellido2;
    private String m_Dni;
    private String m_Profesion;
    private int m_Edad;
    
    public Persona(String nombre, String ap1, String ap2, String dni, String prof, int edad) {
        m_Nombre = nombre;
        m_Apellido1 = ap1;
        m_Apellido2 = ap2;
        m_Dni = dni;
        m_Profesion = prof;
        m_Edad = edad;
    }

    /* GETTERS */
    public String getNombre() {
        return m_Nombre;
    }

    public String getPrimerApellido() {
        return m_Apellido1;
    }

    public String getSegundoApellido() {
        return m_Apellido2;
    }

    public String getDni() {
        return  m_Dni;
    }

    public String getProfesion() {
        return m_Profesion;
    }

    public int getEdad() {
        return m_Edad;
    }

    /* SETTERS */
    public void setNombre(String nombre) {
        m_Nombre = nombre;
    }

    public void setPrimerApellido(String apellido) {
        m_Apellido1 = apellido;    
    }

    public void setSegundoApellido(String apellido) {  
        m_Apellido2 = apellido;
    }

    public void setDni(String dni) {
        m_Dni = dni;
    }

    public void setProfesion(String profesion) {
        m_Profesion = profesion;
    }

    public void setEdad(int edad) {
        m_Edad = edad;
    }
}
