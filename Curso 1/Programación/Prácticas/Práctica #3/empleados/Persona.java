package empleados;

/**
 * <h2></h2>
 * 
 * @author Hugo Pelayo
 * @version 1.0
 */

public class Persona {
    private String m_Dni;
    private String m_Nombre;
    private String m_EstadoCivil;
    private int m_Edad;

    // para comprobar que los estados civiles son válidos
    private static String[] ESTADOS_CIVILES = { "Soltero", "Casado" };

    public Persona(String dni, String nombre, String estado, int edad) {
        m_Dni = dni;
        m_Nombre = nombre;
        setEstado(estado);
        setEdad(edad);
    }

    public boolean equals(Persona other) {
        return m_Dni.equalsIgnoreCase(other.m_Dni) &&
            m_Nombre.equalsIgnoreCase(other.m_Nombre) &&
            m_EstadoCivil.equalsIgnoreCase(other.m_EstadoCivil) &&
            m_Edad == other.m_Edad;
    }

    public Persona(Persona persona) {
        m_Dni = persona.m_Dni;
        m_Nombre = persona.m_Nombre;
        m_EstadoCivil = persona.m_EstadoCivil;
        m_Edad = persona.m_Edad;
    }

    public void cumpleanios() {
        System.out.println(m_Nombre + " tiene " + m_Edad + " años.");
    }

    public String getDni() {
        return m_Dni;
    }

    public String getNombre() {
        return m_Nombre;
    }

    public String getEstado() {
        return m_EstadoCivil;
    }

    public String getNif() {
        return m_Dni;
    }

    public int getEdad() {
        return m_Edad;
    }

    public void setEdad(int edad) {
        if (edad < 0) {
            System.out.println("Valor de edad no válido");
            return;
        }

        m_Edad = edad;
    }

    public void setEstado(String estado) {
        if (!estado.equalsIgnoreCase(ESTADOS_CIVILES[0]) && 
        !estado.equalsIgnoreCase(ESTADOS_CIVILES[1])) {
            System.out.println("Estado no válido");
            return;
        }

        m_EstadoCivil = estado;
    }

    /**
     * Retorna una cadena de caracteres formateada describiendo
     * esta persona
     * 
     * @return Un String formateado representando esta persona
     */
    @Override
    public String toString() {
        return String.format("-- Datos Persona ---------\n" +
                            "DNI: %s\n" +
                            "Edad: %d\n" +
                            "Estado civil: %s\n" +
                            "Nombre: %s\n" +
                            "---------------------------",
        m_Dni, m_Edad, m_EstadoCivil, m_Nombre);
    }
}
