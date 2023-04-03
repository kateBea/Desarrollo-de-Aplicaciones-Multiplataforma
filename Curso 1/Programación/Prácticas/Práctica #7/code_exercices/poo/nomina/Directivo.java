package poo.nomina;

import java.util.Random;

public class Directivo extends Empleado {
    // se usa para determinar el cumplimiento
    // de los objetivos de cada directivo con una probabilidad de 50 %
    private static final Random rand = new Random();

    private boolean m_CumplimientoObjetivos;

    public Directivo(String dni, String nombre, String primerApellido, String segundoApellido, int diasAntiguedad) {
        super(dni, nombre, primerApellido, segundoApellido, diasAntiguedad);

        m_CumplimientoObjetivos = rand.nextInt(2) == 0 ? false : true;
    }

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

    public boolean cumpleObjetivos() {
        return m_CumplimientoObjetivos;
    }

    public double plusCumplimiento() {
        return (PLUS_POR_CUMPLIMIENTO / 100) * SUELDO_DIRECTIVO; 
    }
}
