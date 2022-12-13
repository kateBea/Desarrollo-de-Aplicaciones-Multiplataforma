import java.util.Random;
import java.util.Arrays;

public class Ejercicio1 {
    private static final Random rand = new Random();
    private static final int LIMITE_NUMEROS = 100;
    private static final int COTA_INFERIOR = 0;
    private static final int COTA_SUPERIOR = 100;
    private static final char PAR = 'p';
    private static final char IMPAR = 'i';

    public static void main(String[] args) {
        char[] paridad = new char[LIMITE_NUMEROS];
        int[] numeros = new int[LIMITE_NUMEROS];

        generarAleatorios(numeros);
        Arrays.sort(numeros);
        obtenerParidad(numeros, paridad);
        imprimir(numeros, paridad);

    }

    public static void generarAleatorios(int[] numeros) {
        for (int index = 0; index < LIMITE_NUMEROS; ++index)
            numeros[index] = rand.nextInt(COTA_INFERIOR, COTA_SUPERIOR + 1);
    }

    public static void imprimir(int[] numeros, char[] paridad) {
        for (int index = 1; index <= LIMITE_NUMEROS; ++index) {
            System.out.printf("%d%c- ", numeros[index - 1], paridad[index - 1]);

            if (index % 10 == 0)
                System.out.println();
        }
    }

    public static boolean esPar(int numero) {
        return numero % 2 == 0;
    }

    public static void obtenerParidad(int[] numeros, char[] paridad) {
        for (int index = 0; index < LIMITE_NUMEROS; ++index)
            paridad[index] = (esPar(numeros[index]) ? PAR : IMPAR);
    }
}