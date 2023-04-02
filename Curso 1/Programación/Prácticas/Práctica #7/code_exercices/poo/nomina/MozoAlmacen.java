package poo.nomina;

public class MozoAlmacen extends Empleado implements Cobro {

    public MozoAlmacen(String dni, String nombre, String primerApellido, String segundoApellido, int diasAntiguedad) {
        super(dni, nombre, primerApellido, segundoApellido, diasAntiguedad);
    }
    
    public double sueldo() {
        return SUELDO_MOZO_ALMACEN;
    }

    public double indemnizacion() {
        double resultado;

        double salarioDiario = (TOTAL_MESES_ANIO * sueldo()) / TOTAL_DIAS_ANIO;
        double antiguedadEnAnios = this.getDiasAntiguedad() / (double)TOTAL_DIAS_ANIO;

        resultado = DIAS_POR_ANIO_TRABAJADO * antiguedadEnAnios * salarioDiario;

        return resultado;
    }
}
