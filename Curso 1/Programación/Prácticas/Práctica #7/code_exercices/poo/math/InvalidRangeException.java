package poo.math;

/**
 * Excepción que indica que un intervalo es inválido
 * @author Hugo Pelayo
 * @version 1.0
 */
public class InvalidRangeException extends RuntimeException {
    public InvalidRangeException(String msg) {
        super(msg);
    }
}
