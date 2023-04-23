package arrays;

public class ArrayDeclaracion {
    public static void main(String[] args) {
        int indice;
        String[] palabra = { "Agitar", "Comer", "Romper", "Destruir" };

        indice = 0; // empezamos a recorrer desde la posición inicial
        while (indice < palabra.length) {
            System.out.printf("Palabra en la posición %d: %s\n", indice + 1, palabra[indice]);
            ++indice; // avanzamos a la siguiente posición
        }

        for (indice = 0; indice < palabra.length; ++indice)
            System.out.printf("Palabra en la posición %d: %s\n", indice + 1, palabra[indice]);

        indice = 0; // inicializamos para mostrar la posición
        for (String item : palabra)
            System.out.printf("Palabra en la posición %d: %s\n", ++indice, item);
    }
}
