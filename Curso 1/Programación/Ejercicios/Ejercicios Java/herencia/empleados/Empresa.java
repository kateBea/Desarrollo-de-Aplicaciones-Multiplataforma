package herencia.empleados;

public class Empresa {
    private String m_Cif;
    private String m_Nombre;

    public Empresa(String cif, String nombre) {
        m_Cif = cif;
        m_Nombre = nombre;
    }

    public String getCif() {
        return m_Cif;
    }

    public String getNombre() {
        return m_Nombre;
    }

    public void setCif(String cif) {
        if (cif != null)
            m_Cif = cif;
    }

    public void setNombre(String nombre) {
        if (nombre != null) 
            m_Nombre = nombre;
    }

    @Override
    public String toString() {
        return String.format("Número CIF: %s\n" +
                            "Nombre: %s\n" +
                            "----------------------",
                            m_Cif, m_Nombre);
    }
}