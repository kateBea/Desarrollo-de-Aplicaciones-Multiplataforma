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

    public static void imprimirTriangulo(int n) {
        for (int i = n - 1; i >= 0; --i) {
            for (int j = n - i; j > 0; --j)
                System.out.print("*");
            
            System.out.println();
        }
    }

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
