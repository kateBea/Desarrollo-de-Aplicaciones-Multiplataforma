package string_arrays.string1;

/*
 * Título: Ejercicio 4
 * Algoritmo: Cuenta atras
 * Fecha: 16.11.2022
 * Autor: Hugo Pelayo
 */

public class Ejercicio9 {
    public static void main(String[] args) throws InterruptedException {
        String str15 = "Comenzamos la cuenta atrás";
        String str5 = "Llegando al final";
        String str0 = "!Listo¡";
        final long intervaloEspera = 1000; // tiempo en milisegundos

        for (int i = 15; i >= 0; --i) {
            switch(i) {
                case 15:
                    System.out.println(str15);
                    Thread.sleep(intervaloEspera);
                    break;
                case 5:
                    System.out.println(str5);
                    Thread.sleep(intervaloEspera);
                    break;
                case 0:
                    System.out.println(str0);
                    break;
                default:
                    System.out.println(i + " segundos restantes...");
                    Thread.sleep(intervaloEspera);
                    break;
            }
        }
    }
}
