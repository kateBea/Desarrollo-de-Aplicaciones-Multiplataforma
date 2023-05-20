package ejer1;

import java.time.LocalDate;
import java.util.ArrayList;

public class Employee {
    private String dni;
    private String nombre;
    private String apellidos;
    private ArrayList<String> emails;
    private String telefono;
    private LocalDate fechaContratacion;
    private double salario;
    private Job trabajo;
    private Department departamento;

    @Override
    public String toString() {
        return String.format("dni = '%s' nombre = '%s' apellidos = '%s' telefono = '%s' salario = '%f'", 
            getDni(), getNombre(), getApellidos(), getTelefono(), getSalario());
    }

    
    public Employee(String dni, String nombre, String apellidos, LocalDate fechaContratacion, double sueldo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaContratacion = fechaContratacion;
        this.salario = sueldo;

        this.telefono = null;
        this.trabajo = null;
        this.departamento = null;
        emails = new ArrayList<>();
    }

    public Employee(String dni, String nombre, String apellidos, LocalDate fechaContratacion, double sueldo, Job job, Department dpt) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaContratacion = fechaContratacion;
        this.salario = sueldo;
        
        this.telefono = null;
        this.trabajo = job;
        this.departamento = dpt;
        emails = new ArrayList<>();
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public ArrayList<String> getEmails() {
        return emails;
    }

    public void setEmails(ArrayList<String> emails) {
        this.emails = emails;
    }

    public void addEmail(String email) {
        this.emails.add(email);
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(LocalDate fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public double getSalario() {
        return salario;
    }

    public Job getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(Job trabajo) {
        this.trabajo = trabajo;
    }

    public Department getDepartamento() {
        return this.departamento;
    }

    public void setDeparatamento(Department dept) {
        this.departamento = dept;
    }
    
}
