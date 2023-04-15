import java.io.Serializable;

public class Empleado implements Serializable{ //los objetos se podrán convertir a bytes
    private String nombre;
    private String puesto;
    private double sueldo;

    public Empleado (String nombre, String puesto, double sueldo){
        this.nombre=nombre;
        this.puesto=puesto;
        this.sueldo=sueldo;
    }
  

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

   

    public String getNombre() {
        return nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public double getSueldo() {
        return sueldo;
    }
    
    @Override
    public String toString() {
        return "Empleado [nombre=" + nombre + ", puesto=" + puesto + ", sueldo=" + sueldo + "]";
    }
    
}