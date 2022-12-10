import java.util.Random;

public class Ejercicio1 {
    private static final Random rand = new Random();
    public static void main(String[] args) {
        final int LIMITE_NUMEROS = 100;
        final int COTA_INFERIOR = 0;
        final int COTA_SUPERIOR = 100;
        final char PAR = 'p';
        final char IMPAR = 'I';

        int[] numeros = new int[LIMITE_NUMEROS];
        char[] paridad = new char[LIMITE_NUMEROS];

        for (int index = 0; index < LIMITE_NUMEROS; ++index)
            numeros[index] = rand.nextInt(COTA_INFERIOR, COTA_SUPERIOR + 1);

        ordenar(numeros);

        for (int index = 0; index < LIMITE_NUMEROS; ++index) {
            if (numeros[index] % 2 == 0) 
                paridad[index] = PAR;
            else
                paridad[index] = IMPAR;
        }

        for (int index = 1; index <= LIMITE_NUMEROS; ++index) {
            System.out.print(numeros[index - 1] + paridad[index - 1] + "- ");

            if (index % 10 == 0)
                System.out.println();
        }

    }

    public static void ordenar(int[] numeros) {
        int temporal;

        for (int i = 0; i < numeros.length - 1; i++) {
            for (int j = i + 1; j < numeros.length; j++) {
                if (numeros[i] > numeros[j]) {
                    temporal = numeros[i];
                    numeros[i] = numeros[j];
                    numeros[j] = temporal;
                }
            }
        }
    }
}