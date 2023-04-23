package poo;

public class Persona extends Animal {
    public Persona(String nombre) {
        super(nombre);
    }

    public void greet() {
        System.out.print("¡Hola!");
    }
}
