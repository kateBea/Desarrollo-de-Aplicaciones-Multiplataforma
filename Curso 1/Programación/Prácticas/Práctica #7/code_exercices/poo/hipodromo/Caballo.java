package poo.hipodromo;

/**
 * Representa un caballo
 * @author Hugo Pelayo
 * @version 1.0
 */
public class Caballo {
    // Nombre de este Caballo
    private String m_Nombre;
    // Recorrido en metros de este Caballo
    private int m_Recorrido;
    // Dorsal de este Caballo
    private int m_Dorsal;

    /**
     * Inicializa este Caballo a partir de los datos
     * que se pasan como parámetro, si la refrencia es nula se
     * consideran su valor desconocida
     * @param nombre Nombre para este Caballo
     * @param dorsal Dorsal para este Caballo
     */
    public Caballo(String nombre, int dorsal) {
        m_Nombre = nombre == null ? "Unknown" : nombre;
        m_Dorsal = dorsal;
        m_Recorrido = 0;
    }

    /**
     * Retorna el nombre de este Caballo
     * @return Nombre de este Caballo
     */
    public String getNombre() {
        return m_Nombre;
    }

    /**
     * Cambia el nombre de este Caballo, si la referencia es nula
     * se cambia el nombre a ser desconocido
     * @param nombre Nuevo nombre para este Caballo
     */
    public void setNombre(String nombre) {
        if (nombre != null)
            m_Nombre = nombre;
        else
            System.out.println("Valor de referencia nulo setNombre()...");
    }

    /**
     * Retorna el dorsal de este Caballo
     * @return Dorsal de este Caballo
     */
    public int getDorsal() {
        return m_Dorsal;
    }

    /**
     * Cambia el dorsal de este Caballo, si el valor es negativo
     * esta función no tiene efectos
     * @param dorsal Nuevo dorsal para este Caballo
     */
    public void setDorsal(int dorsal) {
        if (!(dorsal < 0))
            m_Dorsal = dorsal;
        else
            System.out.println("Valor de dorsal negativo setDorsal()...");
    }

    /**
     * Retorna el recorrido en metros de este Caballo
     * @return Recorrido de este Caballo
     */
    public int getRecorrido() {
        return m_Recorrido;
    }

    /**
     * Cambia el recorrido de este Caballo, si el valor
     * es negativo esta función no tiene efectos
     * @param recorrido Nuevo recorrido para este Caballo
     */
    public void setRecorrido(int recorrido) {
        if (!(recorrido < 0))
            m_Recorrido = recorrido;
        else
            System.out.println("Valor de recorrido negativo setRecorrido()...");
    }
}
