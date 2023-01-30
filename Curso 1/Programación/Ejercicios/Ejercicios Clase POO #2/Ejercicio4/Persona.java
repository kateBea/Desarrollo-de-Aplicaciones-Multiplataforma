package Ejercicio4;

import java.io.*;

public class Persona {
    // representa una persona

    private static final int EDAD_JUBILACION = 67; 
    private static final int MAYORIA_DE_EDAD = 18;

    private String m_Nombre;
    private String m_Apellido1;
    // m_Apellido2 es opcional
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

    public void mostrar() {
        System.out.println("Nombre: " + m_Nombre);
        System.out.println("Primer Apellido: " + m_Apellido1);
        System.out.println("Segundo Apellido: " + (m_Apellido2 == null ? "NULL" : m_Apellido2));
        System.out.println("DNI: " + m_Dni);
        System.out.println("Profesión: " + m_Profesion);
        System.out.println("Edad: " + m_Edad);
        System.out.println("----------------------------------");
    }

    public boolean esMayorQue(Persona other) {
        return getEdad() > other.getEdad();
    }

    public boolean esFamiliarDe(Persona other) {
        return (getPrimerApellido().equalsIgnoreCase(other.getPrimerApellido()))
            || (getSegundoApellido().equalsIgnoreCase(other.getSegundoApellido()));
    }

    public boolean esTocayoDe(Persona other) {
        return getNombre().equalsIgnoreCase(other.getNombre());
    }

    public boolean esMenor() {
        return getEdad() < MAYORIA_DE_EDAD;
    }

    public boolean trabajaEnSector(String... profesiones) {
        // TODO: ... enunciado no se aclara ...
        return true;
    }

    public boolean tieneApellidoCompuesto() {
        return (getPrimerApellido().split("-").length == 2)
            || (getSegundoApellido().split("-").length == 2);
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

    public void esJubilado() {
        if (getEdad() >= EDAD_JUBILACION)
            setProfesion("Jubilado");
        else 
            System.out.println((m_Nombre + " " + m_Apellido1) + " con " + m_Edad + " años no está en edad de jubilación");
    }
}
