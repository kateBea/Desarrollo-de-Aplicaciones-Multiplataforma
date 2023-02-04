package nominas;
public final class EmpleadoHora extends Empleado {
    //atributos
    private double salario; // salario por hora
    private double horas; // num horas trabajadas por semana

    /**
     * Método constructor que crea objetos tipo Empleado por Hora
     * con valores para todos sus atributos
     * @param nombre
     * @param apellido
     * @param identificador
     * @param sexo
     * @param tfno
     * @param email
     * @param salario
     * @param horas
     */
    public EmpleadoHora(String nombre, String apellido, String identificador, Character sexo, String tfno, String email,
            double salario, double horas) {
        super(nombre, apellido, identificador, sexo, tfno, email);
        this.salario = salario;
        this.horas = horas;
    }

    /**
     * Método constructor que crea objetos Empleado por Hora
     * con los valores nombre, apellidos, identificador, salario y horas
     * @param nombre
     * @param apellidos
     * @param identificador
     * @param salario
     * @param horas
     */
    public EmpleadoHora(String nombre, String apellidos, String identificador, double salario, double horas) {
        super(nombre, apellidos, identificador);
        this.salario = salario;
        this.horas = horas;
    }

    public double getSalario() {
        return salario;
    }

    public double getHoras() {
        return horas;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setHoras(double horas) {
        this.horas = horas;
    }

    @Override
    public String toString() {
        return "EmpleadoHora [salario=" + salario + ", horas=" + horas + "]";
    }

    @Override
    double sueldo() {
        // TODO Auto-generated method stub
        return salario*horas;
    }




    
}
