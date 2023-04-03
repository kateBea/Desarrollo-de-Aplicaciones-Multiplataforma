package poo.nomina;

public abstract class Empleado implements Cobro {
    private String m_Dni;
    private String m_Nombre;
    private String m_PrimerApellido;
    private String m_SegundoApellido;
    private int m_DiasAntiguedad;

    
    public Empleado(String dni, String nombre, String primerApellido, String segundoApellido, int diasAntiguedad) {
        m_Dni = dni != null ? dni : "Unknown";
        m_Nombre = nombre != null ? nombre : "Unknown";
        m_PrimerApellido = primerApellido != null ? primerApellido : "Unknown";
        m_SegundoApellido = segundoApellido != null ? segundoApellido : "Unknown";
        m_DiasAntiguedad = diasAntiguedad < 0 ? 0 : diasAntiguedad;
    }

    public Empleado(Empleado other) {
        this(other.getDni(), other.getNombre(), other.getPrimerApellido(), other.getSegundoApellido(), other.getDiasAntiguedad());
    }
    
    public String getDni() {
        return m_Dni;
    }

    public void setDni(String dni) {
        if (dni != null)
            m_Dni = dni;
    }

    public String getNombre() {
        return m_Nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null)
            m_Nombre = nombre;
    }

    public String getPrimerApellido() {
        return m_PrimerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        if (primerApellido != null)
            m_PrimerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return m_SegundoApellido;
    }
    public void setSegundoApellido(String segundoApellido) {
        if (segundoApellido != null)
            m_SegundoApellido = segundoApellido;
    }

    public int getDiasAntiguedad() {
        return m_DiasAntiguedad;
    }

    public void setDiasAntiguedad(int diasAntiguedad) {
        if (diasAntiguedad >= 0)
            m_DiasAntiguedad = diasAntiguedad;
    }
    
    
}
