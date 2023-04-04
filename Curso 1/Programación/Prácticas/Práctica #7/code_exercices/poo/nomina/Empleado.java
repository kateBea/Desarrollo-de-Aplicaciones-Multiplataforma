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
    // DNI de este Empleado
    private String m_Dni;
    // Nombre de este Empleado
    private String m_Nombre;
    // Primer apellido de este Empleado
    private String m_PrimerApellido;
    // Segundo apellido de este Empleado
    private String m_SegundoApellido;
    // Diás de antiguedad de este Empleado
    private int m_DiasAntiguedad;

    /**
     * Inicializa este empleado con los datos
     * que se pasa como parámetro. Si las referencias son
     * nulas se marcan los respectivos atributos como desconocidos
     * @param dni Dni para este Empleado
     * @param nombre Nombre para este Empleado
     * @param primerApellido Primer apellido para este Empleado
     * @param segundoApellido Segundo apellido para este Empleado
     * @param diasAntiguedad Días de antiguedad de este Empleado
     */
    public Empleado(String dni, String nombre, String primerApellido, String segundoApellido, int diasAntiguedad) {
        m_Dni = dni != null ? dni : "Unknown";
        m_Nombre = nombre != null ? nombre : "Unknown";
        m_PrimerApellido = primerApellido != null ? primerApellido : "Unknown";
        m_SegundoApellido = segundoApellido != null ? segundoApellido : "Unknown";
        m_DiasAntiguedad = diasAntiguedad < 0 ? 0 : diasAntiguedad;
    }

    /**
     * Inicializa este empleado como copia del Empleado
     * que se pasa por parámetro
     * @param other Empleado a partir del cual se inicializa el parámetro implícito
     */
    public Empleado(Empleado other) {
        this(other.getDni(), other.getNombre(), other.getPrimerApellido(), other.getSegundoApellido(), other.getDiasAntiguedad());
    }

    /**
     * Retorna el DNI de este Empleado
     * @return DNI de este Empleado
     */
    public String getDni() {
        return m_Dni;
    }

    /**
     * Cambia el DNI de este Empleado. Si el parámetro es
     * nulo, esta función no tiene efectos
     * @param dni nuevo DNI de este Empleado
     */
    public void setDni(String dni) {
        if (dni != null)
            m_Dni = dni;
    }

    /**
     * Retorna el nombre de este Empleado
     * @return nombre de este empleado
     */
    public String getNombre() {
        return m_Nombre;
    }
    
    /**
     * Cambia el nombre de este Empleado. Si el parámetro es
     * nulo, esta función no tiene efectos
     * @param nombre Nuevo nombre de este Empleado
     */
    public void setNombre(String nombre) {
        if (nombre != null)
            m_Nombre = nombre;
    }

    /**
     * Retorna el primer apellido de este Empleado
     * @return Primer apellido de este Empleado
     */
    public String getPrimerApellido() {
        return m_PrimerApellido;
    }

    /**
     * Cambia el primer apellido de este Empleado. Si el parámetro es
     * nulo, esta función no tiene efectos
     * @param primerApellido Nuevo primer apellido de este empleado
     */
    public void setPrimerApellido(String primerApellido) {
        if (primerApellido != null)
            m_PrimerApellido = primerApellido;
    }

    /**
     * Retorna el segundo apellido de este Empleado
     * @return Segundo apellido de este Empleado
     */
    public String getSegundoApellido() {
        return m_SegundoApellido;
    }

    /**
     * Cambia el segundo apellido de este Empleado. Si el parámetro es
     * nulo, esta función no tiene efectos
     * @param segundoApellido Nuevo segundo apellido de este Empleado
     */
    public void setSegundoApellido(String segundoApellido) {
        if (segundoApellido != null)
            m_SegundoApellido = segundoApellido;
    }

    /**
     * Retorna los días de antiguedad de este Empleado
     * @return días de antiguedad de este Empleado
     */
    public int getDiasAntiguedad() {
        return m_DiasAntiguedad;
    }

    /**
     * Cambia los días de antiguedad de este Empleado. Si el valor
     * es negativo, esta función no tiene efectos
     * @param diasAntiguedad Nueva antiguedad de este Empleado
     */
    public void setDiasAntiguedad(int diasAntiguedad) {
        if (diasAntiguedad >= 0)
            m_DiasAntiguedad = diasAntiguedad;
    }
}
