package estructuras_control.ejerciciosUT3_3;

/**
 * Este programa muestra todos los divisores de 120
 * 
 * Creado por Hugo Pelayo
 * 25 de marzo de 2023
 */
public class Ejercicio3 {
    public static void main(String[] args) {

        for (int valor = 1; valor <= 120 / 2; ++valor)
            if (esDivisible(120, valor))
                System.out.printf("120 es divisible por [ %d ]\n", valor);
        
    }

    /*
     * Retorna cierto si a es divisible por b (b es divisor de a entonces)
     */
    public static boolean esDivisible(int a, int b) {
        return a % b == 0;
    }
}