package coleccion_poo2.ejercicio1;

public class PruebaLocalidad {
    public static void main(String[] args) {
        Localidad loc1 = new Localidad("Torrejón", "Madrid", 23877, 144.5f, 123.6f, 1.44f);
        loc1.mostrar();

        System.out.println(loc1.getRentaPerCapita());
    }
}
