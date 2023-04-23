package poo;

public class Perro extends Animal {
    public Perro(String nombre) {
        super(nombre);
    }

    public void greet() {
        System.out.print("¡Woof!");
    }
}
