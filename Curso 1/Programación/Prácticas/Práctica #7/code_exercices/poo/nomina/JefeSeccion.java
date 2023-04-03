package poo.nomina;

import java.util.Random;

public class JefeSeccion extends Empleado{
    private static final Random rand = new Random();

    private int m_Ventas;

    public JefeSeccion(String dni, String nombre, String primerApellido, String segundoApellido, int diasAntiguedad) {
        super(dni, nombre, primerApellido, segundoApellido, diasAntiguedad);
        m_Ventas = rand.nextInt(15, 44);
    }
    
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

    public int getVentas() {
        return m_Ventas;
    }

    public double plusComision() {
        return (COMISION_JEFE_SECCION / 100) * getVentas();
    }
}
