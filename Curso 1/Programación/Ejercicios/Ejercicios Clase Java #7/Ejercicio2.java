import java.util.Scanner;

public class Ejercicio2 {
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

    public static void imprimirSecuencia(int limiteInferior, int limiteSuperior) {
        for (int indice = limiteInferior; indice <= limiteSuperior; ++indice) {
            if (esPar(indice))
                System.out.print(indice + " ");
        }

        System.out.print("\n");
    }

    public static boolean esPar(int num) {
        return num % 2 == 0;
    }
}