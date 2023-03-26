package publicaciones;

/**
 * Indica que una fecha es inválida
 * 
 * @author Hugo Pelayo
 * @version 1.0
 */
public class FechaMal extends Exception{
    public FechaMal(String msg) {
        super(msg);
    }
}
