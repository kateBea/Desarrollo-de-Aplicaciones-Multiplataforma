package parking;

import java.time.LocalDateTime;

/**
 * <h2>Representa un Automóvil</h2>
 * 
 * Esta clase representa un Automóvil. Describe un objeto derivado
 * de la clase Vehículo y e implementa el método <b>consultarImporte()</b>
 * a través del cual se puede consultar el importe a pagar por aparcamiento.
 * Se distinguen tres tipos de automóvil: <b>Turismo</b>, <b>Todoterreno<b> y <b>Furgoneta</b>.
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
        return switch(tipo) {
            case TURISMO -> "Turismo";
            case TODOTERRENO -> "Todoterreno";
            case FURGONETA -> "Furgoneta";
        };
    }

    /*
     * Devuelve el correspondiente importe a cargar por el aparcamiento
     * dependiendo del tipo de automóvil. El resultado es un factor
     * en las unidades euros/minuto
     */
    private static double getFactor(AutomovilType tipo) {
        return switch(tipo) {
            case TURISMO -> 1.5 / 60.0;
            case TODOTERRENO -> 2.5 / 60.0;
            case FURGONETA -> 3.5 / 60.0;
        };
    }

    /**
     * Inicializa los datos de este Automóvil con los que se
     * pasan como parámetro
     * 
     * @param matricula Matrícula que asigna a este vehículo
     * @param fechaEntrada Fecha de entrada que se asigna a este vehículo
     * @param tieneAbono Indica si corresponde o no abono a este vehículo
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
     * @param matricula Matrícula que asigna a este vehículo
     * @param tieneAbono Indica si corresponde o no abono a este vehículo
     * @param tipo Tipo de automóvil
     */
    public Automovil(String matricula, boolean tieneAbono, AutomovilType tipo) {
        super(matricula, tieneAbono);
        m_Tipo = tipo;
    } 

    /**
     * Devuelve el importe a pagar por el aparcamiento de este
     * vehículo para el tiempo indicado en minutos. Lo implementan las clases derivadas
     * Si el valor es negativo o 0 esta función retorna -1
     * 
     * @return El importe por aparcamiento
     */
    @Override
    public double calcularImporte(int minutos) {
        double resultado = -1.0;
        
        if (!(minutos < 0.0))
            resultado = minutos * getFactor(m_Tipo);

        return resultado;
    }

    /**
     * Devuelve el importe a pagar por el aparcamiento de este
     * vehículo para el tiempo indicado en minutos. Lo implementan las clases derivadas
     * Si el parámetro es nulo o la fecha de salida es inválida esta función retorna -1
     * 
     * @return El importe por aparcamiento
     */
    @Override
    public double calcularImporte(LocalDateTime fechaSalida) {
        double resultado = -1.0;
        int minutos = 0;

        if (!(minutos < 0.0)) {
            // calcular minutos transcurrido entra llegada y salida


            resultado = minutos * getFactor(m_Tipo);

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
        return String.format("Tipo de automóvil: %s" +
                            "%s",
        getStringTipo(m_Tipo), super.toString());
    }
}
