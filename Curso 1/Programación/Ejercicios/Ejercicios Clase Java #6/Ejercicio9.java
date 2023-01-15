/* 
 * Este programa lee un entero de la entrada estándar de datos
 * y dibuja un triángulo con el cateto opuesto a la hipotenusa de la lingitud 
 * del valor introducido. El valor indica el número de caracteres a mostrar
 * 
 * @author Hugo
 * @version 1.0
 * @date 13 de enero de 2023
 * 
 * 
 */
import java.util.Scanner;

public class Ejercicio9 {
    private static final Scanner lector = new Scanner(System.in);

    public static void main(String[] args) {
        int lado;

        System.out.print("Introduce un entero: ");
        lado = lector.nextInt();

        System.out.println("Triángulo original:");
        imprimirTriangulo(lado);

        System.out.println("\nTriángulo invertido:");
        imprimirTrianguloInvertido(lado);

        lector.close();
    }

    /*
     * Imprime un triángulo rectángulo con el cateto opuesto a la hipotenusa
     * a la derecha de la pantalla.
     * 
     * @param n longitud del cateto
     * @return void
     * @author Hugo
     */
    public static void imprimirTriangulo(int n) {
        for (int i = n - 1; i >= 0; --i) {
            // bucle exterior controla el número de filas

            for (int j = n - i; j > 0; --j)
                // controla el número de caracteres por fila
                System.out.print("*");
            
            System.out.println();
        }
    }

    /*
     * Imprime un triángulo rectángulo con el cateto opuesto a la hipotenusa
     * a la izquierda de la pantalla.
     * 
     * @param n longitud del cateto
     * @return void
     * @author Hugo
     */
    public static void imprimirTrianguloInvertido(int n) {
        for (int i = n - 1; i >= 0; --i) {
            for (int k = 0; k < i; ++k)
                System.out.print(" ");

            for (int j = n - i; j > 0; --j)
                System.out.print("*");

            System.out.println();
        }
    }
}
