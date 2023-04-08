package poo.utils;

/**
 * Representa un tipo Integer cuyo valor puede ser cambiado
 * @author Hugo Pelayo
 * @version 1.0
 */
public class MutableInteger {
    // Valor de este MutableInteger
    private int m_Value;

    /**
     * Inicializa este MutableInteger a 0
     */
    public MutableInteger() {
        m_Value = 0;
    }

    /**
     * Inicializa este MutableInteger con el valor
     * que se pasa como parámetro
     * @param value Valor entero para este MutableInteger
     */
    public MutableInteger(int value) {
        m_Value = value;
    }

    /**
     * Inicializa este MutableInteger con el valor
     * que se pasa como parámetro
     * @param value Valor entero para este MutableInteger
     */
    public MutableInteger(Integer value) {
        m_Value = value;
    }

    /**
     * Inicializa este MutableInteger como copia del que
     * se pasa como parámetro
     * @param other MutableInteger del cual este es copia
     */
    public MutableInteger(MutableInteger other) {
        this(other.getValue());
    }

    /**
     * Retorna el valor contenido en este MutableInteger
     * @return Valor contenido en este MutableInteger
     */
    public int getValue() {
        return m_Value;
    }

    /**
     * Cambia el valor contenido por este MutableInteger
     * por el que se pasa como parámetro
     * @param value Nuevo valor para este MutableInteger
     */
    public void setValue(int value) {
        m_Value = value;
    }

}
