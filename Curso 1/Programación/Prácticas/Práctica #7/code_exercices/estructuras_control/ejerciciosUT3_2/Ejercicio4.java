package estructuras_control.ejerciciosUT3_2;

/**
 * Este programa muestra muestra la suma de todos los números 
 * enteros del 0 a 200, a excepción de aquellos que acaben en 0
 * 
 * Creado por Hugo Pelayo
 * 25 de marzo de 2023
 */
public class Ejercicio4 {
    public static void main(String[] args) {
        int suma = 0; 
        for (int i = 1; i < 200; ++i) {
            if (esPar(i) && !acabadoEnCero(i)) {
                System.out.println(i);
                suma += i;
            }
        }
        
        System.out.println("Suma total: " + suma);
    }

    /*
     * Indica si un número es par, en cuyo caso retorna cierto, 
     * o no, en cuyo caso retorna falso
     */
    public static boolean esPar(int num) {
        return num % 2 == 0;
    }

    /*
     * Retorna cierto si un número acaba en 0,
     * falso en caso contrario
     */
    public static boolean acabadoEnCero(int num) {
        return num % 10 == 0;
    }
}