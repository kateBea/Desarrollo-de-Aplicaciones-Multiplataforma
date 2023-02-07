package parking;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * <h2>Representa un camión</h2>
 * 
 * Esta clase representa un camión. Describe un objeto derivado
 * de la clase camión e implementa el método <b>consultarImporte()</b>
 * a través del cual se puede consultar el importe a pagar por aparcamiento.
 * Se distinguen dos tipos de camión: <b>con 3 o menos ejes</b> y
 *  <b>con más de 3 ejes<b>.
 * 
 * @author Hugo Pelayo 
 * @version 1.0
 */

public final class Camion extends Vehiculo {
    /*
     * Describe el tipo de camión
     */
    public static enum CamionType {
        MENOS_EJES,
        MAS_EJES,
    }

    // Indica el tipo de camión
    private CamionType m_Tipo;

    /*
     * Retorna el tipo de camión en formato String
     */
    private static String getStringTipo(CamionType tipo) {
        return switch(tipo) {
            case MENOS_EJES -> "Con 3 o menos Ejes";
            case MAS_EJES -> "Más de 3 ejes";
        };
    }

    /*
     * Devuelve el correspondiente importe a cargar por el aparcamiento
     * dependiendo del tipo de camión. El resultado es un factor
     * en las unidades euros/minuto
     */
    private static double getFactor(CamionType tipo) {
        return switch(tipo) {
            case MENOS_EJES -> 4.5 / 60.0;
            case MAS_EJES -> 6.5 / 60.0;
        };
    }

    /**
     * Inicializa los datos de este camión con los que se
     * pasan como parámetro
     * 
     * @param matricula Matrícula que asigna a este camión
     * @param fechaEntrada Fecha de entrada que se asigna a este camión
     * @param tieneAbono Indica si corresponde o no abono a este camión
     * @param tipo Tipo de camión
     */
    public Camion(String matricula, LocalDateTime fechaEntrada, boolean tieneAbono, CamionType tipo) {
        super(matricula, fechaEntrada, tieneAbono);
        m_Tipo = tipo;
    }
    
    /**
     * Inicializa los datos de este camión con los que se
     * pasan como parámetro. La fecha y hora se obtienen del sistema
     * 
     * @param matricula Matrícula que asigna a este camión
     * @param tieneAbono Indica si corresponde o no abono a este camión
     * @param tipo Tipo de camión
     */
    public Camion(String matricula, boolean tieneAbono, CamionType tipo) {
        super(matricula, tieneAbono);
        m_Tipo = tipo;
    } 

    /**
     * Devuelve el tipo de este camión
     * 
     * @return tipo de este camión
     */
    public CamionType getTipo() {
        return m_Tipo;
    }

    /**
     * Cambio el tipo de este camión al que se pasa como parámetro
     * 
     * @param tipo Nuevo tipo de este camión
     */
    public void setTipo(CamionType tipo) {
        m_Tipo = tipo;
    }

    /**
     * Devuelve el importe a pagar por el aparcamiento de este
     * camión para el tiempo indicado en minutos. Si el valor es 
     * negativo o 0 esta función retorna -1
     * 
     * @return El importe por aparcamiento
     */
    @Override
    public double calcularImporte(int minutos) {
        double resultado = -1.0;
        
        if (!(minutos < 0.0))
            // también aplicamos descuento si corresponde
            resultado = minutos * getFactor(m_Tipo) *
                (correspondeAbono() ? ABONO_PARKING : 1.0);

        return resultado;
    }

    /**
     * Devuelve el importe a pagar por el aparcamiento de este
     * camión por la estancia. Si el parámetro es nulo 
     * o la fecha de salida es inválida esta función retorna -1. Si la
     * referencia es nula se toma la fecha y hora locales del sistema
     * 
     * @return El importe por aparcamiento
     */
    @Override
    public double calcularImporte(LocalDateTime fechaSalida) {
        if (fechaSalida == null)
            fechaSalida = LocalDateTime.now();

        double resultado = -1.0;
        int minutos = 0;

        // minutos no negativos y nos aseguramos que la fecha de salida es posterior a la de entrada
        if (!(minutos < 0.0) && this.getFechaEntrada().isBefore(fechaSalida)) {
            // calcular minutos transcurrido entra llegada y salida
            minutos = (int)getFechaEntrada().until(fechaSalida, ChronoUnit.MINUTES);

            // también aplicamos descuento si corresponde
            resultado = minutos * getFactor(m_Tipo) *
                (correspondeAbono() ? ABONO_PARKING : 1.0);

        }

        return resultado;
    }

    /**
     * Retorna un Strign formateado representando este camión
     * 
     * @return Un String representando este camión
     */
    @Override
    public String toString() {
        return String.format("Tipo de camión: %s\n" +
                            "%s\n",
        getStringTipo(m_Tipo), super.toString());
    }
}
