package poo.nomina;


/**
 * Representa un Empleado de tipo Mozo de almacén
 * @author Hugo Pelayo
 * @version 1.0
 */
public class MozoAlmacen extends Empleado {
    /**
     * Inicializa este Mozo de almacén con los datos que se pasan como parámetros
     * @param dni DNI de este Mozo de almacén
     * @param nombre Nombre de este Mozo de almacén
     * @param primerApellido Primer apellido de este Mozo de almacén
     * @param segundoApellido Segundo apellido de este Mozo de almacén
     * @param diasAntiguedad Dias de antiguedad de este Mozo de almacén
     */
    public MozoAlmacen(String dni, String nombre, String primerApellido, String segundoApellido, int diasAntiguedad) {
        super(dni, nombre, primerApellido, segundoApellido, diasAntiguedad);
    }
    
    /**
     * Inicializa este Mozo de almacén como copia de
     * del que se pasa por parámetro
     * @param other Mozo de almacén del cual este es copia
     */
    public MozoAlmacen(MozoAlmacen other) {
        this(other.getDni(), other.getNombre(), other.getPrimerApellido(), other.getSegundoApellido(), other.getDiasAntiguedad());
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
