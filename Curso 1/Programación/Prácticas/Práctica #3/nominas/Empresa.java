package nominas;

/**
 * <h2>Representa una empresa</h2>
 * 
 * Esta clase representa una empresa
 * 
 * @author Hugo Pelayo
 * @version 1.0
 */

public class Empresa {
    // Valor CIF de esta empresa
    private String m_Cif;
    // Nombre de esta empresa
    private String m_Nombre;

    /**
     * Inicializa los datos de esta empresa con los que se pasan 
     * parámetro
     * 
     * @param cif Valor CIF que se asigna a esta empresa
     * @param nombre Nombre que se asigna a esta empresa
     */
    public Empresa(String cif, String nombre) {
        m_Cif = cif;
        m_Nombre = nombre;
    }

    /**
     * Devuelve el valor CIF de esta empresa
     * 
     * @return CIF de esta empresa
     */
    public String getCif() {
        return m_Cif;
    }

    /**
     * Devuelve el nombre de esta empresa
     * 
     * @return Nombre de esta empresa
     */
    public String getNombre() {
        return m_Nombre;
    }

    /**
     * Cambia el CIF de esta empresa. Si el parámetro es nulo
     * esta función no tiene efecto
     * 
     * @param cif Nuevo CIF de esta empresa
     */
    public void setCif(String cif) {
        if (cif != null)
            m_Cif = cif;
    }

    /**
     * Cambia el nombre de esta empresa. Si el parámetro
     * es nulo esta función no tiene efecto
     * 
     * @param nombre Nuevo nombre de esta empresa
     */
    public void setNombre(String nombre) {
        if (nombre != null) 
            m_Nombre = nombre;
    }

    /**
     * Retorna una cadena de caracteres formateada describiendo
     * esta empresa
     * 
     * @return Un String formateado representando esta empresa
     */
    @Override
    public String toString() {
        return String.format("-- Datos Empresa ----\n" +
                            "Número CIF: %s\n" +
                            "Nombre empresa: %s\n" +
                            "----------------------",
                            m_Cif, m_Nombre);
    }
}