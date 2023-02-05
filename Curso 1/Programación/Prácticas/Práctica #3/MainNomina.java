import empleados.*;
import nominas.*;
import java.util.ArrayList;

public class MainNomina {
    public static void main(String[] args) {
        ArrayList<Empresa> empresas;
        ArrayList<Persona> personas;
        ArrayList<Empleado> empleados;
        ArrayList<Departamento> departamentos;

        // inicializamos la lista de empresas
        empresas = getEmpresas();
        // inicializamos la lista de personas
        personas = getPersonas();
        // inicializamos la lista de empleados con la lista de personas que tenemos
        empleados = getEmpleados(personas);
        // incializamos la lista de departamentos
        departamentos = getDepartamentos(empleados, empresas);
    }

    public static ArrayList<Empresa> getEmpresas() {
        ArrayList<Empresa> resultado = new ArrayList<>();


        return resultado;
    }

    
    public static ArrayList<Persona> getPersonas() {
        ArrayList<Persona> resultado = new ArrayList<>();
        
        
        return resultado;
    }
    
    public static ArrayList<Empleado> getEmpleados(ArrayList<Persona> personas) {
        ArrayList<Empleado> resultado = new ArrayList<>();
        
        
        return resultado;
    }

    public static ArrayList<Departamento> getDepartamentos(ArrayList<Empleado> empleados, ArrayList<Empresa> empresas) {
        ArrayList<Departamento> resultado = new ArrayList<>();
    
    
        return resultado;
    }
}
