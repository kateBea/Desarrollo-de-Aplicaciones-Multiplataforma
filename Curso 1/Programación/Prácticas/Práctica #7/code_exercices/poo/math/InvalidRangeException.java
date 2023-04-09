package poo.math;

/**
 * Excepción que indica que un intervalo es inválido
 * @author Hugo Pelayo
 * @version 1.0
 */
public class InvalidRangeException extends RuntimeException {
    /**
     * Contruye una nueva excepción con el mensaje que se pasa como
     * parámetro como causa de excepción
     * @param msg Causa de excepción
     */
    public InvalidRangeException(String msg) {
        super(msg);
    }
}
