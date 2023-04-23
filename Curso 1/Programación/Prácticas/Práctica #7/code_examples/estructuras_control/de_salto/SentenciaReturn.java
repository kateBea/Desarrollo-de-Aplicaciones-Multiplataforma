package estructuras_control.de_salto;

/**
 * Este ejemplo muestra un uso básico la sentencia return
 * @author Hugo Pelayo
 * @Fecha 23 de abril de 2023
 * */
public class SentenciaReturn {
    public static void main(String[] args) {
        int[] elementos = { 2, 4, 6, 1, 22, 34, 11, 9, 7, 15, 4 };

        for (int elemento : elementos) {
            // mostramos solo los elementos pares
            if (!esPar(elemento)) {
                continue;
            }

            System.out.print(elemento + " ");
        }

        System.out.print('\n');
    }

    public static boolean esPar(int numero) {
        if (numero % 2 == 0)
            return true;
        else
            return false;
    }
}
