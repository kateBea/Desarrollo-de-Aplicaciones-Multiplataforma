package poo.nomina;

public interface Cobro {
    // Sueldo correspondiente a cada tipo de empleado
    final double SUELDO_MOZO_ALMACEN = 1200.0;
    final double SUELDO_JEFE_SECCION = 1700.0;
    final double SUELDO_JEFE_PLANTA = 1800.0;
    final double SUELDO_PERSONAL_ADMINISTRACION = 1600.0;
    final double SUELDO_DIRECTIVO = 2800.0;

    // Retención en tanto por cién sobre el salario bruto
    final double RETENCION_MOZO_ALMACEN = 15.0;
    final double RETENCION_JEFE_SECCION = 17.0;
    final double RETENCION_JEFE_PLANTA = 19.0;
    final double RETENCION_PERSONAL_ADMINISTRACION = 13.0;
    final double RETENCION_DIRECTIVO = 23.0;

    // Incremento de sueldo anual en tanto por cién
    final double AUMENTO_MOZO_ALMACEN = 5.0;
    final double AUMENTO_JEFE_SECCION = 7.0;
    final double AUMENTO_JEFE_PLANTA = 9.0;
    final double AUMENTO_PERSONAL_ADMINISTRACION = 6.0;
    final double AUMENTO_DIRECTIVO = 10.0;

    // Comisión sobre ventas realizadas (en tanto por cién)
    final double COMISION_JEFE_SECCION = 12.0;
    final double COMISION_JEFE_PLANTA = 6.0;

    // plus de cumplimiento de objetivos para directivos
    final double PLUS_POR_CUMPLIMIENTO = 35.0;

    // dias de indemnización por año trabajado
    // factor necesario para calcular la indemnnización
    final int DIAS_POR_ANIO_TRABAJADO = 20;

    final int TOTAL_MESES_ANIO = 12;
    final int TOTAL_DIAS_ANIO = 365;

    double sueldo();
    double indemnizacion();
}
