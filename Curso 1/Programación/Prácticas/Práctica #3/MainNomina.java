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

        resultado.add(new Empresa("M4458000F", "Ades"));
        resultado.add(new Empresa("J4767662W", "Debra"));

        return resultado;
    }

    
    public static ArrayList<Persona> getPersonas() {
        ArrayList<Persona> resultado = new ArrayList<>();
        
        resultado.add(new Persona("275645213P", "Álvaro Jiménez", "Soltero", 23));
        resultado.add(new Persona("123456789R", "Laura Sánchez", "Casado", 36));
        resultado.add(new Persona("222333444T", "Roberto Torres", "Soltero", 21));
        resultado.add(new Persona("444777222Y", "Carlos Torres", "Soltero", 27));
        resultado.add(new Persona("111999333U", "Bruno Martínez", "Casado", 44));
        resultado.add(new Persona("999333777E", "Cintia Pelayo", "Soltero", 23));
        resultado.add(new Persona("999222888P", "Alberto Gisbert", "Casado", 32));
        resultado.add(new Persona("222111663L", "Luis Enrique", "Casado", 47));
        resultado.add(new Persona("337755528Q", "Gregorio Sánchez", "Soltero", 31));
        resultado.add(new Persona("188426645D", "Silvia Da Silva", "Casado", 40));
        resultado.add(new Persona("222577353K", "Juan Ismael", "Casado", 39));
        resultado.add(new Persona("338562864M", "Gustavo Isbert", "Soltero", 27));

        return resultado;
    }
    
    public static ArrayList<Empleado> getEmpleados(ArrayList<Persona> personas) {
        ArrayList<Empleado> resultado = new ArrayList<>();
        
        resultado.add(new Empleado(personas.get(0), "Informático", null, 390000));
        resultado.add(new Empleado(personas.get(1), "Gestor", null, 240000));
        resultado.add(new Empleado(personas.get(2), "Atención al cliente", null, 190000));
        resultado.add(new Empleado(personas.get(3), "Analista", null, 350000));
        resultado.add(new Empleado(personas.get(4), "Analista", null, 350000));
        resultado.add(new Empleado(personas.get(5), "Informático", null, 450000));
        resultado.add(new Empleado(personas.get(6), "Atención al cliente", null, 190000));
        resultado.add(new Empleado(personas.get(7), "Gestor", null, 300000));
        resultado.add(new Empleado(personas.get(8), "Director", null, 490000));
        resultado.add(new Empleado(personas.get(9), "Gerente", null, 270000));
        resultado.add(new Empleado(personas.get(10), "Supervisor", null, 265000));
        resultado.add(new Empleado(personas.get(11), "Gerente", null, 275000));
        
        return resultado;
    }

    public static ArrayList<Departamento> getDepartamentos(ArrayList<Empleado> empleados, ArrayList<Empresa> empresas) {
        ArrayList<Departamento> resultado = new ArrayList<>();
        
    
        return resultado;
    }
}
