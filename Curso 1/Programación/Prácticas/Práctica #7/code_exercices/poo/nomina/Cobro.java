package poo.nomina;

/**
 * Esta interfaz describe aspectos generales sobre objetos especializados 
 * de la clas Empleado.  Define constantes y declara métodos.
 * @author Hugo Pelayo
 * @version 1.0
 */
public interface Cobro {
    // Sueldos correspondientes a cada tipo de empleado

    /**
     * Sueldo correspondiente a un Mozo de almacén
     */
    final double SUELDO_MOZO_ALMACEN = 1200.0;
    /**
     * Sueldo correspondiente a un Jefe de sección
     */
    final double SUELDO_JEFE_SECCION = 1700.0;
    /**
     * Sueldo correspondiente a un Jefe de Planta
     */
    final double SUELDO_JEFE_PLANTA = 1800.0;
    /**
     * Sueldo correspondiente a un Personal de administración
     */
    final double SUELDO_PERSONAL_ADMINISTRACION = 1600.0;
    /**
     * Sueldo correspondiente a un Directivo
     */
    final double SUELDO_DIRECTIVO = 2800.0;

    // Retención en tanto por cién sobre el salario bruto

    /**
     * Retención sobre salario de Mozo de almacén
     */
    final double RETENCION_MOZO_ALMACEN = 15.0;
    /**
     * Retención sobre salario de Jefe de sección
     */
    final double RETENCION_JEFE_SECCION = 17.0;
    /**
     * Retención sobre salario de Jefe de planta
     */
    final double RETENCION_JEFE_PLANTA = 19.0;
    /**
     * Retención sobre salario de Personal de administración
     */
    final double RETENCION_PERSONAL_ADMINISTRACION = 13.0;
    /**
     * Retención sobre salario de Directivo
     */
    final double RETENCION_DIRECTIVO = 23.0;

    // Incremento de sueldo anual en tanto por cién

    /**
     * Aumento de salario anual para Mozo de almacén
     */
    final double AUMENTO_MOZO_ALMACEN = 5.0;
    /**
     * Aumento de salario anual para Jefe de sección
     */
    final double AUMENTO_JEFE_SECCION = 7.0;
    /**
     * Aumento de salario anual para Jefe de planta
     */
    final double AUMENTO_JEFE_PLANTA = 9.0;
    /**
     * Aumento de salario anual para Personal de administración
     */
    final double AUMENTO_PERSONAL_ADMINISTRACION = 6.0;
    /**
     * Aumento de salario anual para Directivo
     */
    final double AUMENTO_DIRECTIVO = 10.0;

    /**
     * Comisión sobre ventas realizadas para Jefes de sección (en tanto por cién)
     * */
    final double COMISION_JEFE_SECCION = 12.0;
    /**
     * Comisión sobre ventas realizadas para Jefes de planta (en tanto por cién)
     * */
    final double COMISION_JEFE_PLANTA = 6.0;

    /**
     * plus de cumplimiento de objetivos para directivos
     * */
    final double PLUS_POR_CUMPLIMIENTO = 35.0;

    /**
     * Dias de indemnización por año trabajado 
     * factor necesario para calcular la indemnnización
     * */
    final int DIAS_POR_ANIO_TRABAJADO = 20;

    /**
     * Meses del año
     */
    final int TOTAL_MESES_ANIO = 12;
    /**
     * Total de dias del año
     */
    final int TOTAL_DIAS_ANIO = 365;

    /**
     * Retorna el sueldo que le corresponde a un tipo Empleado
     * @return el sueldo
     */
    double sueldo();

    /**
     * Retorna la indemnización que le corresponde a un tipo Empleado
     * @return la indemnización
     */
    double indemnizacion();
}
