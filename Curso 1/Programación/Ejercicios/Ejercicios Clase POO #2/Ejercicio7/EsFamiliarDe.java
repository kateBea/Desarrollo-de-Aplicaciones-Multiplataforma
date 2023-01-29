package Ejercicio7;

import Ejercicio4.Persona;

public class EsFamiliarDe {
    public static void main(String[] args) {
        Persona p1 = new Persona("Roberto", "Carlos", "Rodríguez", "123456789F", "Estudiante", 21);
        Persona p2 = new Persona("Marta", "Bastos", null, "276491742K", "Electricista", 25);
        Persona p3 = new Persona("Carlos", "Torres", "Pelayo", "472540185L", "Ingeniero", 27);
        Persona p4 = new Persona("Rubén", "Santos", "Gisbert", "274562913G", "Estudiante", 17);
        Persona p5 = new Persona("Silvia", "Giménez", "Da Silva", "397640123M", "Hacker", 22);
        Persona p6 = new Persona("Cintia", "Giménez", "Da Silva", "375692745U", "Bióloga", 21);

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

        System.out.println("********** Prueba esFamiliarDe **********");

        if (p1.esFamiliarDe(p2)) 
            System.out.println(p1.getNombre() + " " + p1.getSegundoApellido() + " es familiar de " + p2.getNombre() + " " + p2.getSegundoApellido());
        else 
            System.out.println(p2.getNombre() + " " + p2.getSegundoApellido() + " no es familiar de " + p1.getNombre() + " " + p1.getSegundoApellido());

        if (p3.esFamiliarDe(p4)) 
            System.out.println(p3.getNombre() + " " + p3.getSegundoApellido() + " es familiar de " + p4.getNombre() + " " + p4.getSegundoApellido());
        else 
            System.out.println(p4.getNombre() + " " + p4.getSegundoApellido() + " no es familiar de " + p3.getNombre() + " " + p3.getSegundoApellido());

        if (p5.esFamiliarDe(p2)) 
            System.out.println(p5.getNombre() + " " + p5.getSegundoApellido() + " es familiar de " + p2.getNombre() + " " + p2.getSegundoApellido());
        else 
            System.out.println(p2.getNombre() + " " + p2.getSegundoApellido() + " no es familiar de " + p5.getNombre() + " " + p5.getSegundoApellido());
            
        if (p5.esFamiliarDe(p6)) 
            System.out.println(p5.getNombre() + " " + p5.getSegundoApellido() + " es familiar de " + p6.getNombre() + " " + p6.getSegundoApellido());
        else 
            System.out.println(p6.getNombre() + " " + p6.getSegundoApellido() + " no es familiar de " + p5.getNombre() + " " + p5.getSegundoApellido());
    }
}
