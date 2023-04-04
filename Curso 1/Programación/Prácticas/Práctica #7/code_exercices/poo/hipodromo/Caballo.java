package poo.hipodromo;

public class Caballo {
    private String m_Nombre;
    private int m_Recorrido;
    private int m_Dorsal;

    public Caballo(String nombre, int dorsal) {
        m_Nombre = nombre;
        m_Dorsal = dorsal;
    }

    public String getNombre() {
        return m_Nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null)
            m_Nombre = nombre;
    }

    public int getDorsal() {
        return m_Dorsal;
    }

    public void setDorsal(int dorsal) {
        if (!(dorsal < 0))
            m_Dorsal = dorsal;
    }

    public int getRecorrido() {
        return m_Recorrido;
    }

    public void setRecorrido(int recorrido) {
        if (!(recorrido < 0))
            m_Recorrido = recorrido;
    }
}
