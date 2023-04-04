package poo.utils;

/**
 * Utilidad que almacena dos objetos de tipos 
 * que pueden ser diferentes o iguales
 * @author Hugo Pelayo
 * @version 1.0
 */
public class Pair<T, U> {
    /*
     * Referencia a objeto de tipo T
     */
    private T m_First;
    /*
     * Referencia a objeto de tipo U
     */
    private U m_Second;

    /**
     * Construye un objeto de tipo Pair
     * con referencias nulas a los dos tipos de objetos que contiene
     */
    public Pair() {
        m_First = null;
        m_Second = null;
    }

    /**
     * Construye un objeto de tipo Pair
     * con referencias a los objetos que se pasa
     * como parámetros
     * @param first Referencia para primer elemento
     * @param second Referencia para seundo elemento
     */
    public Pair(T first, U second) {
        m_First = first;
        m_Second = second;
    }

    /**
     * Retorna la referencia al primer elemento de este Pair,
     * el usuario debe asegurarse de no referenciar el sobjeto si es nulo
     * @return referencia al primer elemento
     */
    public T getFirst() {
        return m_First;
    }

    /**
     * Cambia la referencia del primer elemento a la
     * que se pasa como parámetro
     * @param value nueva refrencia del primer elemento
     */
    public void setFirst(T value) {
        m_First = value;
    }

    /**
     * Retorna la referencia al segundo elemento de este Pair,
     * el usuario debe asegurarse de no referenciar el sobjeto si es nulo
     * @return referencia al segundo elemento
     */
    public U getSecond() {
        return m_Second;
    }

    /**
     * Cambia la referencia del segundo elemento a la
     * que se pasa como parámetro
     * @param value nueva refrencia del segundo elemento
     */
    public void setSecond(U value) {
        m_Second = value;
    }
}
