import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Persona implements Serializable {

    private String dni;
    private String nombre;
    private LocalDate fechaNac;
    private String direccion;
    private int edad;

    //constructores
    public Persona(String p_dni, String p_nombre, LocalDate p_fecnac, String p_direccion) {
        dni = p_dni;
        nombre = p_nombre;
        fechaNac = p_fecnac;
        direccion = p_direccion;
        edad = calculaEdad(fechaNac);
    }

    public Persona() {
    }

    //métodos
    public final int calculaEdad(LocalDate f) {
        LocalDate hoy = LocalDate.now();
        Period p = Period.between(f, hoy);
        long annos = ChronoUnit.YEARS.between(f, hoy);
        return (int) annos;
    }

    public String getDni() {
        return this.dni;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return dni + " - " + nombre + " - " + edad;
    }
}
