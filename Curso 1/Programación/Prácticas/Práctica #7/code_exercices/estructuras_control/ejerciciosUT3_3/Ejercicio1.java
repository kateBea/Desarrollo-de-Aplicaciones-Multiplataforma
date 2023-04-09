package estructuras_control.ejerciciosUT3_3;

/**
 * Este programa muestra los la suma de todos los múltiplos de
 * 3 entre el 33 y el 36, ambos inclusos
 * 
 * Creado por Hugo Pelayo
 * 25 de marzo de 2023
 */
public class Ejercicio1 {
    public static void main(String[] args) {
        int suma = 0;

        for (int i = 33; i <= 66; ++i)
            suma += esMultiploDe(i, 3) ? i : 0;

        System.out.println("Total: " + suma);
    }

    /*
     * Retorna cierto si a es múltiplo de b, es decir, si existe un entero
     * que multiplicado por b nos resulta a
     */
    public static boolean esMultiploDe(int a, int b) {
        return a % b == 0;
    }
}