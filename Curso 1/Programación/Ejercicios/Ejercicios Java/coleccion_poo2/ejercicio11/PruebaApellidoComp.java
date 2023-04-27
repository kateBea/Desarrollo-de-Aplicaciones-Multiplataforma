package coleccion_poo2.ejercicio11;

import coleccion_poo2.ejercicio4.Persona;

public class PruebaApellidoComp {
    public static void main(String[] args) {
        Persona p1 = new Persona("Roberto", "Carlos", "Rodríguez", "123456789F", "Estudiante", 21);
        Persona p2 = new Persona("Marta", "Bastos", null, "276491742K", "Electricista", 25);
        Persona p3 = new Persona("Carlos", "Torres", "Pelayo", "472540185L", "Ingeniero", 27);
        Persona p4 = new Persona("Rubén", "Santos", "Gisbert", "274562913G", "Estudiante", 17);
        Persona p5 = new Persona("Silvia", "Giménez", "Da Silva", "397640123M", "Hacker", 22);
        Persona p6 = new Persona("Silvia", "Sánchez-Gil", "Da Silva", "58635926L", "Secretaria", 25);

        p1.mostrar();
        p2.mostrar();
        p3.mostrar();
        p4.mostrar();
        p5.mostrar();

        System.out.println("********** ALGUNAS MODIFICACIONES **********");
        p1.setDni("777222888Y");
        p3.setNombre("Rubén");
        p3.mostrar();
        p1.mostrar();

        p5.setEdad(19);
        p5.mostrar();

        System.out.println("********** Prueba tieneApellidoCompuesto **********");
        
        if (p1.tieneApellidoCompuesto())
            System.out.println(p1.getPrimerApellido() + " " + p1.getSegundoApellido() + " tiene apellido compuesto");
        else 
            System.out.println(p1.getPrimerApellido() + " " + p1.getSegundoApellido() + " no tiene apellido compuesto");

        if (p6.tieneApellidoCompuesto())
            System.out.println(p6.getPrimerApellido() + " " + p6.getSegundoApellido() + " tiene apellido compuesto");
        else 
            System.out.println(p6.getPrimerApellido() + " " + p6.getSegundoApellido() + " no tiene apellido compuesto");
    }
}
