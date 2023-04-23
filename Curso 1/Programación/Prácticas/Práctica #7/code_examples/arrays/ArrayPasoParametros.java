package arrays;

/**
 * Este ejemplo muestra las diferentes formas
 * de pasar un array como parámetro a una función
 * @author Hugo Pelayo
 * @Fecha 23 de abril de 2023
 * */
public class ArrayPasoParametros {
    public static void main(String[] args) {
        String[] palabras = { "Agitar", "Comer", "Romper", "Destruir" };
        mostrarArrayStrV1(palabras);
        mostrarArrayStrV2(palabras);
    }

    public static void mostrarArrayStrV1(String... lista) {
        int indice = 0; // inicializamos para mostrar la posición
        for (String item : lista)
            System.out.printf("Palabra en la posición %d: %s\n", ++indice, item);
    }

    public static void mostrarArrayStrV2(String[] lista) {
        int indice = 0; // inicializamos para mostrar la posición
        for (String item : lista)
            System.out.printf("Palabra en la posición %d: %s\n", ++indice, item);
    }
}