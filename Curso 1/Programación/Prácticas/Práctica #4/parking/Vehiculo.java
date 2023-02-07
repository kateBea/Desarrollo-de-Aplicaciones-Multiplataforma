package parking;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    String m_Matricula;
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
        m_Matricula = matricula;
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
        m_Matricula = matricula;
        m_FechaEntrada = LocalDateTime.now();
        m_TieneAbono = tieneAbono;
    }

    /**
     * Devuelve el importe a pagar por el aparcamiento de este
     * vehículo para el tiempo indicado en minutos. Lo implementan las clases derivadas
     * Si el valor es negativo o 0 esta función retorna -1
     * 
     * @return El importe por aparcamiento
     */
    abstract double calcularImporte(int minutos);

    /**
     * Devuelve el importe a pagar por el aparcamiento de este
     * vehículo por la estancia. Si el parámetro es nulo 
     * o la fecha de salida es inválida esta función retorna -1. Si la
     * referencia es nula se toma la fecha y hora locales del sistema
     * 
     * @return El importe por aparcamiento
     */
    abstract double calcularImporte(LocalDateTime fechaSalida);

    /**
     * Devuelve la matrícula de este vehículo
     * 
     * @return Matrícula de este vehículo
     */
    public String getMatricula() {
        return m_Matricula;
    }

    /**
     * Cambia la mtrícula de este vehículo a la que se pasa como parámetro
     * No tiene efecto si la referencia es nula
     * 
     * @param matricula Nueva matrícula de este vehículo
    */
    public void setMatricula(String matricula) {
        if (matricula  != null)
            m_Matricula = matricula;
    }

    public LocalDateTime getFechaEntrada() {
        return m_FechaEntrada;
    }

    /**
     * Cambia la fecha de entrada de este vehículo a la que se pasa
     * como parámetro. Si la referencia es nula se toma la fecha del sistema
     * 
     * @param fechaEntrada Nueva fecha de entrada de este vehículo
     */
    public void setFechaEntrada(LocalDateTime fechaEntrada) {
        m_FechaEntrada = fechaEntrada == null ? LocalDateTime.now() : fechaEntrada;
    }

    /**
     * Devuelve cierto si a este vehículo le corresponde abono
     * de descuento por aparcamiento, devuelve falso en caso contrario
     * 
     * @return Correspondencia abono
     */
    public boolean correspondeAbono() {
        return m_TieneAbono;
    }

    /**
     * Si el parámetro es cierto a este vehículo pasa a corresponderle 
     * un abono de descuento por aparcamiento, en caso contrario no lo
     * corresponde el abono
     * 
     * @param abono Indicará si a este vehículo le corresponde abono o no
     */
    public void setCorrespondeAbono(boolean abono) {
        m_TieneAbono = abono;
    }

    /**
     * Devuelve cierto si este vehículo es el mismo que el que se pasa
     * como parámetro, falso en caso contrario
     * 
     * @param otro El otro vehículo con el cual se compara este
     * @return Cierto si son el mismo, falso en caso contrario
     */
    public boolean equals(Vehiculo otro) {
        return getMatricula().equalsIgnoreCase(otro.getMatricula());
    }

     /**
     * Devuelve cierto si este vehículo tiene la mtrícula que se pasa como parámetro
     * 
     * @param matricula El otro vehículo con el cual se compara este
     * @return Cierto si las matrículas son iguales
     */
    public boolean equals(String matricula) {
        return getMatricula().equalsIgnoreCase(matricula);
    }

    /**
     * Retorna un Strign formateado representando este vehículo
     * 
     * @return Un String representando este vehículo
     */
    @Override
    public String toString() {
        return String.format("Matrícula: %s\n" +
                            "Fecha entrada: %s\n" +
                            "Corresponde abono: %s\n" +
                            "--------------------------------------------",
        m_Matricula, m_FechaEntrada.format(DateTimeFormatter.ofPattern("dd MMMM yyyy kk:mm:ss")), m_TieneAbono ? "Sí" : "No");
    }
    
}
