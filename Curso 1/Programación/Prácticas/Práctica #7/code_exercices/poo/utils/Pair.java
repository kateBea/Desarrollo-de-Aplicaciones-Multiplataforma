package poo.utils;

/**
 * Utilidad que contiene dos elementos
 * @author Hugo Pelayo
 * @version 1.0
 */
public class Pair<FirstType, SecondType> {
    private FirstType m_First;
    private SecondType m_Second;

    public Pair() {
        m_First = null;
        m_Second = null;
    }

    public Pair(FirstType first, SecondType second) {
        m_First = first;
        m_Second = second;
    }

    public FirstType getFirst() {
        return m_First;
    }

    public SecondType getSecond() {
        return m_Second;
    }

    public void setFirst(FirstType value) {
        m_First = value;
    }

    public void setSecond(SecondType value) {
        m_Second = value;
    }
}
