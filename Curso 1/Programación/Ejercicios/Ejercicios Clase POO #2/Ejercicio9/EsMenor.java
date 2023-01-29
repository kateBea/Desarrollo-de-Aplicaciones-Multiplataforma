package Ejercicio9;

import Ejercicio4.Persona;

public class EsMenor {
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

        System.out.println("********** Prueba esMenor **********");
        System.out.println((p1.getNombre() + " " + p1.getPrimerApellido()) + 
            (p1.esMenor() ? " es menor" : " es mayor") + " de edad.");

        System.out.println((p2.getNombre() + " " + p2.getPrimerApellido()) + 
        (p2.esMenor() ? " es menor" : " es mayor") + " de edad.");

        System.out.println((p4.getNombre() + " " + p4.getPrimerApellido()) + 
        (p4.esMenor() ? " es menor" : " es mayor") + " de edad.");
    }
}
