package estructuras_control.ejerciciosUT3_2;

/**
 * Este programa muestra los números pares entre el 1 y el 20
 * 
 * Creado por Hugo Pelayo
 * 25 de marzo de 2023
 */
public class Ejercicio2 {
    public static void main(String[] args) {
        for (int i = 1; i <= 20; ++i)
            if (esPar(i))
                System.out.println(i);
    }

    /*
     * Indica si un número es par, en cuyo caso retorna cierto, 
     * o no, en cuyo caso retorna falso
     */
    public static boolean esPar(int num) {
        return num % 2 == 0;
    }
}