package nominas;
public final class EmpleadoComision extends Empleado{
    
    //atributos
    private double salario; //salario base por semana
    private double comision; // comisión por artículo vendido
    private int cantidad; // total artículos vendidos por semana

    /***
     * Método constructor que crea objetos tipo Empleados con Comisión
     * con valores para todos sus atributos
     * @param nombre nombre del empleado con comisión
     * @param apellido apellidos del empleado con comisión
     * @param identificador
     * @param sexo
     * @param tfno
     * @param email
     * @param salario
     * @param comision
     * @param cantidad
     */
    public EmpleadoComision (String nombre,
                            String apellido,
                            String identificador, 
                            Character sexo,
                            String tfno, 
                            String email,
                            double salario,
                            double comision,
                            int cantidad){

        super(nombre, apellido, identificador, sexo, tfno, email);
        this.salario=salario;
        this.comision=comision;
        this.cantidad=cantidad;                        


    }

    /**
     * Método que crea objetos tipo Empleado Comisión bla bla
     * @param nombre
     * @param apellidos
     * @param identificador
     * @param salario
     * @param comision
     * @param cantidad
     */
    public EmpleadoComision(String nombre, String apellidos, String identificador, double salario, double comision,
            int cantidad) {
        super(nombre, apellidos, identificador);
        this.salario = salario;
        this.comision = comision;
        this.cantidad = cantidad;
    }

    public double getSalario() {
        return salario;
    }

    public double getComision() {
        return comision;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "EmpleadoComision [salario=" + salario + ", comision=" + comision + ", cantidad=" + cantidad + "]";
    }

    @Override
    double sueldo() {
        // TODO Auto-generated method stub
        return salario+comision*cantidad;
    }

    
  
    

}
