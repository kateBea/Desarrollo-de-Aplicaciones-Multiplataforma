package estructuras_control.de_salto;

public class SentenciaContinue {
    public static void main(String[] args) {
        int[] elementos = { 2, 4, 6, 1, 22, 34, 11, 9, 7, 15, 4 };

        for (int elemento : elementos) {
            // mostramos solo los elementos pares
            if (elemento % 2 != 0) {
                continue;
            }

            System.out.print(elemento + " ");
        }

        System.out.print('\n');
    }
}
