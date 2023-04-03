package poo.nomina;

public class PersonalAdministracion extends Empleado {

    public PersonalAdministracion(String dni, String nombre, String primerApellido, String segundoApellido,
            int diasAntiguedad) {
        super(dni, nombre, primerApellido, segundoApellido, diasAntiguedad);
    }
    
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
