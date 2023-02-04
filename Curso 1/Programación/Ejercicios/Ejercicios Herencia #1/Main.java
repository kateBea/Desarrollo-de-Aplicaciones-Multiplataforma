import empleados.*;

public class Main {
    public static void main(String[] args) {
        Empresa empresa1 = new Empresa("M200059H", "Indra");
        
        Departamento departamento1 = new Departamento("45", "Madrid", "Informática", empresa1);
        Departamento departamento2 = new Departamento("66", "Barcelona", "Personal", empresa1);

        System.out.println(empresa1.toString());
        System.out.println(departamento1);
        System.out.println(departamento2);

        Persona p1 = new Persona("4765482904F", "Álvro Jiménez", "Casado", 35);
        Persona p2 = new Persona("582654827W", "Julia Pedro", "Soltera", 24);
        Persona p3 = new Persona("485627104I", "Laura Sánchez", "Soltero", 27);

        Empleado emp1 = new Empleado(p1, "Desarrollador", departamento1, 300000);
        Empleado emp2 = new Empleado(p2 , "Q&A", departamento1, 350000);
        Empleado emp3 = new Empleado(p3, "AAC", departamento2, 250000);

        System.out.println(emp1);
        System.out.println(emp2);
        System.out.println(emp3);

        departamento1.altaEmpleado(emp1);
        departamento1.altaEmpleado(emp2);
        departamento2.altaEmpleado(emp3);

        System.out.println(departamento1);
        System.out.println(departamento2);

        departamento1.altaEmpleado(emp1);

        System.out.println(departamento1);
        System.out.println(departamento2);
    }
}
