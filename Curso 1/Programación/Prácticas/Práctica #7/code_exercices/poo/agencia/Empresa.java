package poo.agencia;

public class Empresa {
    private String m_Nombre;
    private String m_Cif;

    public Empresa(String cif, String nombre) {
        m_Cif = cif;
        m_Nombre = nombre;
    }

    public String getCif() {
        return m_Cif;
    }

    public void setCif(String cif) {
        if (cif != null)
            m_Cif = cif;
    }

    public String getNombre() {
        return m_Nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null)
            m_Nombre = nombre;
    }

    public boolean equals(Empresa other) {
        return getCif().equalsIgnoreCase(other.getCif()) &&
                getNombre().equalsIgnoreCase(other.getNombre());
    }
}
