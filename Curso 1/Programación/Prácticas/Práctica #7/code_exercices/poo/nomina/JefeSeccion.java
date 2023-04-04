package poo.nomina;

import java.util.Random;


/**
 * Representa un Empleado de tipo Jefe de sección
 * @author Hugo Pelayo
 * @version 1.0
 */
public class JefeSeccion extends Empleado{
    /*
     * Generador de números aleatorios que se sirve
     * para determinar el número de ventas de este Jefe de sección
     */
    private static final Random rand = new Random();

    // mínimo de ventas por Jefe de sección
    private static final int MINIMO_VENTAS = 15;
    // máximo de ventas de Jefe de sección
    private static final int MAXIMO_VENTAS = 67;

    // total de ventas de este Jefe de sección
    private int m_Ventas;


    /**
     * Inicializa este Jefe de sección con los datos que se pasan como parámetros
     * @param dni DNI de este Jefe de sección
     * @param nombre Nombre de este Jefe de sección
     * @param primerApellido Primer apellido de este Jefe de sección
     * @param segundoApellido Segundo apellido de este Jefe de sección
     * @param diasAntiguedad Dias de antiguedad de este Jefe de sección
     */
    public JefeSeccion(String dni, String nombre, String primerApellido, String segundoApellido, int diasAntiguedad) {
        super(dni, nombre, primerApellido, segundoApellido, diasAntiguedad);
        m_Ventas = rand.nextInt(MINIMO_VENTAS, MAXIMO_VENTAS);
    }
    
    /**
     * Inicializa este Jefe de sección como copia de
     * del que se pasa por parámetro
     * @param other Jefe de sección del cual este es copia
     */
    public JefeSeccion(JefeSeccion other) {
        this(other.getDni(), other.getNombre(), other.getPrimerApellido(), other.getSegundoApellido(), other.getDiasAntiguedad());
    }

    public double sueldo() {
        return SUELDO_JEFE_SECCION;
    }

    public double indemnizacion() {
        double resultado;

        double salarioDiario = (TOTAL_MESES_ANIO * sueldo()) / TOTAL_DIAS_ANIO;
        double antiguedadEnAnios = this.getDiasAntiguedad() / (double)TOTAL_DIAS_ANIO;

        resultado = DIAS_POR_ANIO_TRABAJADO * antiguedadEnAnios * salarioDiario;

        return resultado;
    }

    /**
     * Retorna el número de ventas realizado por este Jefe de sección
     * @return Número de ventas de este Jefe de sección
     */
    public int getVentas() {
        return m_Ventas;
    }

    /**
     * Retorna la cantidad a percibir por el plus de comisión
     * @return Cuntía de plus por comisión
     */
    public double plusComision() {
        return (COMISION_JEFE_SECCION / 100) * getVentas();
    }
}
