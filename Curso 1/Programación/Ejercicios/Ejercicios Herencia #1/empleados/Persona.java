package empleados;

public class Persona {
    private String m_Dni;
    private String m_Nombre;
    private String m_EstadoCivil;
    private int m_Edad;

    // para comprobar que los estados civiles son válidos
    private static String[] ESTADOS_CIVILES = { "Soltero", "Casado" };

    public Persona(String dni, String nombre, String estado, int edad) {

    }

    public Persona(Persona persona) {
        
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
        return "";
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

    @Override
    public String toString() {
        return String.format("DNI: %s\n" +
                            "Edad: %d\n" +
                            "Estado civil: %s\n" +
                            "Nombre: %s\n" +
                            "---------------------------\n",
        m_Dni, m_Edad, m_EstadoCivil, m_Nombre);
    }
}
