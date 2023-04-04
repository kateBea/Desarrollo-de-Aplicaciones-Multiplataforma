package poo.nomina;

import java.util.Random;

/**
 * Representa un Empleado de tipo Directivo
 * @author Hugo Pelayo
 * @version 1.0
 */
public class Directivo extends Empleado {
    // se usa para determinar el cumplimiento
    // de los objetivos de cada directivo con una probabilidad de 50 %
    /*
     * Generador de números aleatorios que sirve
     * para determinar el cumplimiento  de los objetivos 
     * de cada directivo con una probabilidad de 50 %
     */
    private static final Random rand = new Random();

    // buleano que indica si este Directivo ha cumplido con sus objetivos
    private boolean m_CumplimientoObjetivos;

    /**
     * Inicializa este Directivo con los datos que se pasan como parámetros
     * @param dni DNI de este Directivo
     * @param nombre Nombre de este Directivo
     * @param primerApellido Primer apellido de este Directivo
     * @param segundoApellido Segundo apellido de este Directivo
     * @param diasAntiguedad Dias de antiguedad de este Directivo
     */
    public Directivo(String dni, String nombre, String primerApellido, String segundoApellido, int diasAntiguedad) {
        super(dni, nombre, primerApellido, segundoApellido, diasAntiguedad);

        m_CumplimientoObjetivos = rand.nextInt(2) == 0 ? false : true;
    }

    /**
     * Inicializa este Directivo como copia de
     * del que se pasa por parámetro
     * @param other Directivo del cual este es copia
     */
    public Directivo(Directivo other) {
        this(other.getDni(), other.getNombre(), other.getPrimerApellido(), other.getSegundoApellido(), other.getDiasAntiguedad());
    }
    
    public double sueldo() {
        return SUELDO_DIRECTIVO;
    }

    public double indemnizacion() {
        double resultado;

        double salarioDiario = (TOTAL_MESES_ANIO * sueldo()) / TOTAL_DIAS_ANIO;
        double antiguedadEnAnios = this.getDiasAntiguedad() / (double)TOTAL_DIAS_ANIO;

        resultado = DIAS_POR_ANIO_TRABAJADO * antiguedadEnAnios * salarioDiario;

        return resultado;
    }

    /**
     * Retorna cierto si este directivo cumple con sus objetivos,
     * falso en caso cotrario
     * @return si este Directivo cumple sus objetivos o no
     */
    public boolean cumpleObjetivos() {
        return m_CumplimientoObjetivos;
    }

    /**
     * Retorna la cantidad a percibir por  cumplimiento de objetivos
     * @return Cuantía de plus por cumplimiento de objetivos
     */
    public double plusCumplimiento() {
        return (PLUS_POR_CUMPLIMIENTO / 100) * SUELDO_DIRECTIVO; 
    }
}
