package introduccion;

import java.util.Arrays;

/**
 * Este ejemplo ilustra como se comportan las variables
 * de tipo objeto al ser pasadas como parámetros a funciones
 * @author Hugo Pelayo
 * @Fecha 23 de abril de 2023
 * */
public class Referencias {
    public static void main(String[] args) {
        int[] misNumeros = { 1, 2, 3, 4, 5 };
        System.out.println(Arrays.toString(misNumeros));

        dublicar(misNumeros);
        System.out.println(Arrays.toString(misNumeros));
    }

    public static void dublicar(int[] lista) {
        for (int indice = 0; indice < lista.length; ++indice)
            lista[indice] *= 2;
    }
}
