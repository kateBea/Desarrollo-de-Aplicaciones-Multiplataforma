package Ejercicio6;

import Ejercicio4.Persona;

public class PruebaEsTocayo {
    public static void main(String[] args) {
        Persona p1 = new Persona("Roberto", "Carlos", "Rodríguez", "123456789F", "Estudiante", 21);
        Persona p2 = new Persona("Marta", "Bastos", null, "276491742K", "Electricista", 25);
        Persona p3 = new Persona("Carlos", "Torres", "Pelayo", "472540185L", "Ingeniero", 27);
        Persona p4 = new Persona("Rubén", "Santos", "Gisbert", "274562913G", "Estudiante", 17);
        Persona p5 = new Persona("Silvia", "Giménez", "Da Silva", "397640123M", "Hacker", 22);

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

        System.out.println("********** Prueba esTocayoDe **********");

        if (p1.esTocayoDe(p2)) 
            System.out.println(p1.getNombre() + " " + p1.getSegundoApellido() + " es tocayo de " + p2.getNombre() + " " + p2.getSegundoApellido());
        else 
            System.out.println(p2.getNombre() + " " + p2.getSegundoApellido() + " no es tocayo de " + p1.getNombre() + " " + p1.getSegundoApellido());

        if (p3.esTocayoDe(p4)) 
            System.out.println(p3.getNombre() + " " + p3.getSegundoApellido() + " es tocayo de " + p4.getNombre() + " " + p4.getSegundoApellido());
        else 
            System.out.println(p4.getNombre() + " " + p4.getSegundoApellido() + " no es tocayo de " + p3.getNombre() + " " + p3.getSegundoApellido());

        if (p5.esTocayoDe(p2)) 
            System.out.println(p5.getNombre() + " " + p5.getSegundoApellido() + " es tocayo de " + p2.getNombre() + " " + p2.getSegundoApellido());
        else 
            System.out.println(p2.getNombre() + " " + p2.getSegundoApellido() + " no es tocayo de " + p5.getNombre() + " " + p5.getSegundoApellido());
    }
}
