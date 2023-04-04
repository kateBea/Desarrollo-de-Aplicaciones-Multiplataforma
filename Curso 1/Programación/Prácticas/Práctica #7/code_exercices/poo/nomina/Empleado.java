package poo.nomina;

/**
 * Clase abstracta que define los aspectos generales de un Empleado.
 * Dado un empleado se puede definir y, posteriormente consultar, su nombre,
 * los apellidos, el dni, los días que tiene de antiguedad. También ofrece 
 * la posibilidad de modificar estos valores. 
 * @author Hugo Pelayo
 * @version 1.0
 */
public abstract class Empleado implements Cobro {
    private String m_Dni;
    private String m_Nombre;
    private String m_PrimerApellido;
    private String m_SegundoApellido;
    private int m_DiasAntiguedad;

    /**
     * 
     * @param dni
     * @param nombre
     * @param primerApellido
     * @param segundoApellido
     * @param diasAntiguedad
     */
    public Empleado(String dni, String nombre, String primerApellido, String segundoApellido, int diasAntiguedad) {
        m_Dni = dni != null ? dni : "Unknown";
        m_Nombre = nombre != null ? nombre : "Unknown";
        m_PrimerApellido = primerApellido != null ? primerApellido : "Unknown";
        m_SegundoApellido = segundoApellido != null ? segundoApellido : "Unknown";
        m_DiasAntiguedad = diasAntiguedad < 0 ? 0 : diasAntiguedad;
    }

    /**
     * 
     * @param other
     */
    public Empleado(Empleado other) {
        this(other.getDni(), other.getNombre(), other.getPrimerApellido(), other.getSegundoApellido(), other.getDiasAntiguedad());
    }

    /**
     * 
     * @return
     */
    public String getDni() {
        return m_Dni;
    }

    /**
     * 
     * @param dni
     */
    public void setDni(String dni) {
        if (dni != null)
            m_Dni = dni;
    }

    /**
     * 
     * @return
     */
    public String getNombre() {
        return m_Nombre;
    }
    
    /**
     * 
     * @param nombre
     */
    public void setNombre(String nombre) {
        if (nombre != null)
            m_Nombre = nombre;
    }

    /**
     * 
     * @return
     */
    public String getPrimerApellido() {
        return m_PrimerApellido;
    }

    /**
     * 
     * @param primerApellido
     */
    public void setPrimerApellido(String primerApellido) {
        if (primerApellido != null)
            m_PrimerApellido = primerApellido;
    }

    /**
     * 
     * @return
     */
    public String getSegundoApellido() {
        return m_SegundoApellido;
    }

    /**
     * 
     * @param segundoApellido
     */
    public void setSegundoApellido(String segundoApellido) {
        if (segundoApellido != null)
            m_SegundoApellido = segundoApellido;
    }

    /**
     * 
     * @return
     */
    public int getDiasAntiguedad() {
        return m_DiasAntiguedad;
    }

    /**
     * 
     * @param diasAntiguedad
     */
    public void setDiasAntiguedad(int diasAntiguedad) {
        if (diasAntiguedad >= 0)
            m_DiasAntiguedad = diasAntiguedad;
    }
}
