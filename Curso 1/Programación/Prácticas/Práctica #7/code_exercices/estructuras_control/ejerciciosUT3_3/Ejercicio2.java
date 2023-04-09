package estructuras_control.ejerciciosUT3_3;

/**
 * Este programa muestra la suma de todos los números enteros 
 * entre 1 y 40, ambos inclusos, excepto los que acaban en 5
 * 
 * Creado por Hugo Pelayo
 * 25 de marzo de 2023
 */
public class Ejercicio2 {
    public static void main(String[] args) {
        int suma = 0;

        for (int i = 1; i <= 40; ++i)
            suma += !endsWith(i, 5) ? i : 0;

        System.out.println("Total: " + suma);
    }

    /*
     * Retorna cierto si el dígito de menor peso de "num"
     * es "lastDigit", falso en caso contrario
     */
    public static boolean endsWith(int num, int lastdigit) {
        return num % 10 == lastdigit;
    }
}