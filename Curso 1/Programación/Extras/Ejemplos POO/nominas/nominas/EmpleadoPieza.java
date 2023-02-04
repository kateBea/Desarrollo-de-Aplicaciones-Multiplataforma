package nominas;
public final class EmpleadoPieza extends Empleado{
    //atributos
    private double salarioPorPieza; //salario por pieza producida
    private int cantidad; //nº piezas producidas
   
       //métodos
   
    public EmpleadoPieza(String nombre, String apellido, String identificador, Character sexo, String tfno,
            String email, double salarioPorPieza, int cantidad) {
        super(nombre, apellido, identificador, sexo, tfno, email);
        this.salarioPorPieza = salarioPorPieza;
        this.cantidad = cantidad;
    }

    public EmpleadoPieza(String nombre, String apellidos, String identificador, double salarioPorPieza, int cantidad) {
        super(nombre, apellidos, identificador);
        this.salarioPorPieza = salarioPorPieza;
        this.cantidad = cantidad;
    }

    public double getSalarioPorPieza() {
        return salarioPorPieza;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setSalarioPorPieza(double salarioPorPieza) {
        this.salarioPorPieza = salarioPorPieza;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "EmpleadoPieza [salarioPorPieza=" + salarioPorPieza + ", cantidad=" + cantidad + "]";
    }

    @Override
    double sueldo() {
        // TODO Auto-generated method stub
        return salarioPorPieza*cantidad;
    }



    
}
