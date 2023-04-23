package generics;

/**
 * Definición de una utilidad básica para
 * contener dos tipos de datos de tipos posiblemente diferentes
 * @author Hugo Pelayo
 * @Fecha 23 de abril de 2023
 * */
public class Pair<T, U> {
    T m_First;
    U m_Second;

    public Pair(T first, U second) {
        m_First = first;
        m_Second = second;
    }

    public T getFirst() { return m_First; }
    public U getSecond() { return m_Second; }

    public void setFirst(T first) { m_First = first; }
    public void setSecond(U second) { m_Second = second; }
}
