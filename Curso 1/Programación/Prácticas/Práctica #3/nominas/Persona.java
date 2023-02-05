package nominas;

/**
 * <h2>Representa una persona</h2>
 * 
 * Esta clase representa una persona recogiendo los datos más
 * básicos de una. Se pueden consultar y modificar a través de los
 * métodos proveídos
 * 
 * @author Hugo Pelayo
 * @version 1.0
 */

public class Persona {
    // DNI de esta persona
    private String m_Dni;
    // Nombre completo de esta persona
    private String m_Nombre;
    // Estado civil de esta persona
    private String m_EstadoCivil;
    // Edad de esta persona
    private int m_Edad;

    // para comprobar que los estados civiles son válidos
    private static String[] ESTADOS_CIVILES = { "Soltero", "Casado" };
    
    public boolean equals(Persona other) {
        return m_Dni.equalsIgnoreCase(other.m_Dni) &&
            m_Nombre.equalsIgnoreCase(other.m_Nombre) &&
            m_EstadoCivil.equalsIgnoreCase(other.m_EstadoCivil) &&
            m_Edad == other.m_Edad;
    }

    /**
     * Inicializa los datos de esta persona a partir de los
     * que se pasan como parámetros
     * 
     * @param dni DNI que se asigna a esta persona
     * @param nombre Nombre que se asigna a esta persona
     * @param estado Estado que se asigna a esta persona
     * @param edad Edad que se asigna a esta persona
     */
    public Persona(String dni, String nombre, String estado, int edad) {
        m_Dni = dni;
        m_Nombre = nombre;
        setEstado(estado);
        setEdad(edad);
    }

    /**
     * Inicializa esta persona como copia de la que
     * se pasa como parámetro
     * 
     * @param persona Persona de la que se copia
     */
    public Persona(Persona persona) {
        m_Dni = persona.m_Dni;
        m_Nombre = persona.m_Nombre;
        m_EstadoCivil = persona.m_EstadoCivil;
        m_Edad = persona.m_Edad;
    }

    /**
     * Cumpleaños de esta persona
     */
    public void cumpleanios() {
        System.out.println(m_Nombre + " tiene " + m_Edad + " años.");
    }

    /**
     * Devuelve el nombre de esta persona
     * 
     * @return Nombre de esta persona
     */
    public String getNombre() {
        return m_Nombre;
    }

    /**
     * Devuelve el estado de esta persona
     * 
     * @return Estado de esta persona
     */
    public String getEstado() {
        return m_EstadoCivil;
    }

    /**
     * Devuelve el NIF de esta persona
     * 
     * @return NIF de esta persona
     */
    public String getNif() {
        return m_Dni;
    }

    /**
     * Devuelve la edad de esta persona
     * 
     * @return Edad de esta personas
     */
    public int getEdad() {
        return m_Edad;
    }

    /**
     * Cambia la edad de esta persona a la que se pasa por parámetro.
     * Si la edad es negativa no se realizan cambios y se informa de ello
     * con un mensaje apropiado
     * 
     * @param edad Nueva edad de esta persona
     */
    public void setEdad(int edad) {
        if (edad < 0) {
            System.out.println("Valor de edad no válido");
            return;
        }

        m_Edad = edad;
    }

    /**
     * Cambia el estado civil de esta persona al que se pasa
     * como parámetro. El estado civil puede ser <b>"Soltero"</b>
     * o <b>Casado</b>. Si no es ninguno de esta valores, esta función
     * no tiene efecto
     * 
     * @param estado Nuevo estado civil de esta persona
     */
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
