package poo.nomina;

/**
 * Representa un Empleado de tipo Personal administrativo
 * @author Hugo Pelayo
 * @version 1.0
 */
public class PersonalAdministracion extends Empleado {

    /**
     * Inicializa este Personal de Administración con los datos
     * que se pasan como parámetros
     * @param dni DNI de este Personal administrativo
     * @param nombre Nombre de este Personal administrativo
     * @param primerApellido Primer apellido de este Personal administrativo
     * @param segundoApellido Segundo apellido de este Personal administrativo
     * @param diasAntiguedad Dias de antiguedad de este Personal administrativo
     */
    public PersonalAdministracion(String dni, String nombre, String primerApellido, String segundoApellido,
            int diasAntiguedad) {
        super(dni, nombre, primerApellido, segundoApellido, diasAntiguedad);
    }
    
    /**
     * Inicializa este Personal de administración como copia de
     * del que se pasa por parámetro
     * @param other Personal administrativo del cual este es copia
     */
    public PersonalAdministracion(PersonalAdministracion other) {
        this(other.getDni(), other.getNombre(), other.getPrimerApellido(), other.getSegundoApellido(), other.getDiasAntiguedad());
    }
    
    public double sueldo() {
        return SUELDO_PERSONAL_ADMINISTRACION;
    }

    public double indemnizacion() {
        double resultado;

        double salarioDiario = (TOTAL_MESES_ANIO * sueldo()) / TOTAL_DIAS_ANIO;
        double antiguedadEnAnios = this.getDiasAntiguedad() / (double)TOTAL_DIAS_ANIO;

        resultado = DIAS_POR_ANIO_TRABAJADO * antiguedadEnAnios * salarioDiario;

        return resultado;
    }
}
