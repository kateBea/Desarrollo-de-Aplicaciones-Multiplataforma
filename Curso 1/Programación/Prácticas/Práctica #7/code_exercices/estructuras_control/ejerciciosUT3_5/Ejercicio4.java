package estructuras_control.ejerciciosUT3_5;

import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce número: ");
        int userInput = sc.nextInt();
        

        if (multiploDe(userInput, 2 * 3 * 5))
            System.out.println("El número es múltiplo de 2, 3 y 5");
        else {
            if (multiploDe(userInput, 2))
                System.out.println("El número es múltiplo de 2");
            if (multiploDe(userInput, 3))
                System.out.println("El número es múltiplo de 3");
            if (multiploDe(userInput, 5))
                System.out.println("El número es múltiplo de 5");
        }
        
    }

    /***
     * Retorna cierto se dividendo es múltiplo de divisor, es decir,
     * existe un entero tal que multiplicado por divisor nos da dividendo.
     * Retorna falso en caso contrario
     */
    public static boolean multiploDe(int dividendo, int divisor) {
        
        return dividendo % divisor == 0;
    }
}