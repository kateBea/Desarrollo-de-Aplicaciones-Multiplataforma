package excepciones2.parking;

/**
 * Error en tiempo de ejeución al sacar un vehículo
 * o introducir uno al Aparcamiento
 * @author Hugo Pelayo
 * @version 1.0
 * 
 */
public class AparcamientoException extends Exception {
    public AparcamientoException(String msg) {
        super(msg);
    }
}
