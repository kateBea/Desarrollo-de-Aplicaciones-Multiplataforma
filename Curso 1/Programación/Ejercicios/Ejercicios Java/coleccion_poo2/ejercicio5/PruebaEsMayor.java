package coleccion_poo2.ejercicio5;

import coleccion_poo2.ejercicio4.Persona;

public class PruebaEsMayor {
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
        p1.mostrar();

        p5.setEdad(19);
        p5.mostrar();

        System.out.println("********** Prueba esMayorQue **********");
        if (p1.esMayorQue(p2)) 
            System.out.println(p1.getNombre() + " es mayor que " + p2.getNombre());
        else 
            System.out.println(p2.getNombre() + " es mayor que " + p1.getNombre());

        if (p3.esMayorQue(p4)) 
            System.out.println(p3.getNombre() + " es mayor que " + p4.getNombre());
        else 
            System.out.println(p4.getNombre() + " es mayor que " + p3.getNombre());

        if (p5.esMayorQue(p2)) 
            System.out.println(p5.getNombre() + " es mayor que " + p2.getNombre());
        else 
            System.out.println(p2.getNombre() + " es mayor que " + p5.getNombre());
    }
}
