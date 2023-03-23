package estructuras_control.ejerciciosUT3_3;

import java.util.Random;

public class Ejercicio6 {
    public static void main(String[] args) {
        Random rd = new Random();

        // numero aleatorio en el rango [20, 140)
        int numero = rd.nextInt(20, 140);
        System.out.printf("[ %d ] es divisor de [ %d ]\n", numero, numero);
        for (int valor = numero / 2; valor > 0; --valor)
            if (esDivisible(numero, valor))
                System.out.printf("[ %d ] es divisor de [ %d ]\n", valor, numero);
        
    }

    public static boolean esDivisible(int dividendo, int divisor) {
        return dividendo % divisor == 0;
    }
}