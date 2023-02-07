package parking;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * <h2>Representa un Automóvil</h2>
 * 
 * Esta clase representa un Automóvil. Describe un objeto derivado
 * de la clase automóvil e implementa el método <b>consultarImporte()</b>
 * a través del cual se puede consultar el importe a pagar por aparcamiento.
 * Se distinguen tres tipos de automóvil: <b>Turismo</b>, <b>Todoterreno</b> y <b>Furgoneta</b>.
 * 
 * @author Hugo Pelayo 
 * @version 1.0
 */

public final class Automovil extends Vehiculo {
    /*
     * Describe el tipo de Automóvil
     */
    public static enum AutomovilType {
        TURISMO,
        TODOTERRENO,
        FURGONETA,
    }

    // Indica el tipo de automóvil
    private AutomovilType m_Tipo;

    /*
     * Retorna el tipo de automóvil en formato String
     */
    private static String getStringTipo(AutomovilType tipo) {
        String result;

        switch(tipo) {
            case TURISMO: result = "Turismo"; break;
            case TODOTERRENO: result = "Todoterreno"; break;
            default: result =  "Todoterreno"; break;
        }

        return result;
    }

    /*
     * Devuelve el correspondiente importe a cargar por el aparcamiento
     * dependiendo del tipo de automóvil. El resultado es un factor
     * en las unidades euros/minuto
     */
    private static double getFactor(AutomovilType tipo) {
        double result;
        switch(tipo) {
            case TURISMO: result =  1.5 / 60.0; break;
            case TODOTERRENO: result = 2.5 / 60.0; break;
            default: result =  3.5 / 60.0; break;
        }

        return result;
    }

    /**
     * Inicializa los datos de este Automóvil con los que se
     * pasan como parámetro
     * 
     * @param matricula Matrícula que asigna a este automóvil
     * @param fechaEntrada Fecha de entrada que se asigna a este automóvil
     * @param tieneAbono Indica si corresponde o no abono a este automóvil
     * @param tipo Tipo de automóvil
     */
    public Automovil(String matricula, LocalDateTime fechaEntrada, boolean tieneAbono, AutomovilType tipo) {
        super(matricula, fechaEntrada, tieneAbono);
        m_Tipo = tipo;
    }
    
    /**
     * Inicializa los datos de este Automóvil con los que se
     * pasan como parámetro. La fecha y hora se obtienen del sistema
     * 
     * @param matricula Matrícula que asigna a este automóvil
     * @param tieneAbono Indica si corresponde o no abono a este automóvil
     * @param tipo Tipo de automóvil
     */
    public Automovil(String matricula, boolean tieneAbono, AutomovilType tipo) {
        super(matricula, tieneAbono);
        m_Tipo = tipo;
    } 

    /**
     * Devuelve el tipo de este automóvil
     * 
     * @return tipo de este automóvil
     */
    public AutomovilType getTipo() {
        return m_Tipo;
    }

    /**
     * Cambio el tipo de este automóvil al que se pasa como parámetro
     * 
     * @param tipo Nuevo tipo de este automóvil
     */
    public void setTipo(AutomovilType tipo) {
        m_Tipo = tipo;
    }

    /**
     * Devuelve el importe a pagar por el aparcamiento de este
     * automóvil para el tiempo indicado en minutos. Si el valor es negativo 
     * o 0 esta función retorna -1
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
     * automóvil por la estancia. Si el parámetro es nulo 
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
     * Retorna un Strign formateado representando este automóvil
     * 
     * @return Un String representando este automóvil
     */
    @Override
    public String toString() {
        return String.format("Tipo de automóvil: %s\n" +
                            "%s\n",
        getStringTipo(m_Tipo), super.toString());
    }
}
