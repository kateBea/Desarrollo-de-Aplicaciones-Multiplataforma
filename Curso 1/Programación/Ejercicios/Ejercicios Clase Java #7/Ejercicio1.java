/* 
 * Este programa lee dos enteros de la entrada de datos y muestra por pantalla
 * todos los números enteros comprendidos en dicho intervalo.
 * 
 * @author Hugo
 * @version 1.0
 * @date 14 de enero de 2023
 */

import java.util.Scanner;

public class Ejercicio1 {
    private static final Scanner lector = new Scanner(System.in);
    public static void main(String[] args) {
        int limiteInferior;
        int limiteSuperior;

        
        do {
            System.out.print("Introduce la cota inferior de la secuencia: ");
            limiteInferior = lector.nextInt();
            System.out.print("Introduce la cota superior de la secuencia: ");
            limiteSuperior = lector.nextInt();

            if (limiteSuperior < limiteInferior)
                System.out.println("La cota superior debe ser más pequeña o igual a la superior...");
            
        }
        while (limiteInferior > limiteSuperior);

        imprimirSecuencia(limiteInferior, limiteSuperior);

        lector.close();
    }

    /*
     * Función que imprime todos los números enteros comprendidos en
     * el intervalo [limiteInferior, limiteSuperior], es decir, ambos inclusos.
     * 
     * @param limiteInferior cota inferior de la secuencia
     * @param limiteSuperior cota superior de la secuencia
     * @return void
     * @author Hugo
     */
    public static void imprimirSecuencia(int limiteInferior, int limiteSuperior) {
        for (int indice = limiteInferior; indice <= limiteSuperior; ++indice) {
            System.out.print(indice + " ");
        }

        System.out.print("\n");
    }
}