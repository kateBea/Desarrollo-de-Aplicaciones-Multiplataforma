package parking;

import java.time.LocalDateTime;

/**
 * <h2>Representa un Vehículo</h2>
 * 
 * Vehículo es una clase abstracta que modela un objeto vehículo que puede ser
 * de tipo automóvil y camiones. Los vehículos pueden formar parte de un 
 * aparcamiento a por un coste determinado dependiente del parking. Para cada
 * vehículo se puede saber el importe de aparcamiento através del método 
 * <b>consultarImporte()</b> el cuál implementan las clases derivadas.
 * 
 * @author Hugo Pelayo 
 * @version 1.0
 */

public abstract class Vehiculo {
    // Matrícula del vehículo
    String m_Matrícula;
    // Fecha de entrada (fecha y hora)
    LocalDateTime m_FechaEntrada;
    // indica si tiene abono (true) o no (false)
    boolean m_TieneAbono;

    // descuento sobre importe de aparcamiento, 
    // si corresponde (40% menos sobre el importe final)
    protected static double ABONO_PARKING = 0.4;

    /**
     * Inicializa los datos de este vehículo con los que se
     * pasan como parámetro
     * 
     * @param matricula Matrícula que asigna a este vehículo
     * @param fechaEntrada Fecha de entrada que se asigna a este vehículo
     * @param tieneAbono Indica si corresponde o no abono a este vehículo
     */
    public Vehiculo(String matricula, LocalDateTime fechaEntrada, boolean tieneAbono) {
        m_Matrícula = matricula;
        m_FechaEntrada = fechaEntrada;
        m_TieneAbono = tieneAbono;
    }

    /**
     * Inicializa los datos de este vehículo con los que se
     * pasan como parámetro. La fecha y hora se obtienen del sistema
     * 
     * @param matricula Matrícula que asigna a este vehículo
     * @param tieneAbono Indica si corresponde o no abono a este vehículo
     */
    public Vehiculo(String matricula, boolean tieneAbono) {
        m_Matrícula = matricula;
        m_FechaEntrada = LocalDateTime.now();
        m_TieneAbono = tieneAbono;
    }

    /**
     * Devuelve el importe a pagar por el aparcamiento de este
     * vehículo. Lo implementan las clases derivadas
     * 
     * @return
     */
    abstract double calcularImporte();
    
}
