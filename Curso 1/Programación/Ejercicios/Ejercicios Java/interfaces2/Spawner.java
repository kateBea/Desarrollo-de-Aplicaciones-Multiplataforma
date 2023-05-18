package interfaces2;

import interfaces2.clases.Ej1;
import interfaces2.clases.Ej2;

public class Spawner {
    public static void main(String[] args) {
        Ej1 ventana1 = new Ej1("BotonesTexto", 640, 170);
        ventana1.render();

        Ej2 ventana2 = new Ej2("Texto", 640, 130);
        ventana2.render();
    }
}