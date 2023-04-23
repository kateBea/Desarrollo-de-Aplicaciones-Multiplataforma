package otras_clases;

import java.util.StringTokenizer;


/**
 * Este ejemplo muestra un uso básico de la clase
 * StringTokenizer para separar un String en varios
 * @author Hugo Pelayo
 * @Fecha 23 de abril de 2023
 * */
public class EjemploStringStokenizer {
    public static void main(String[] args) {
        String frase = "Esto es una prueba";
        // separar frase en substrings teniendo en cuenta un espacio como delimitador
        StringTokenizer tokenizer = new StringTokenizer(frase, " ");

        while (tokenizer.hasMoreTokens()) {
            System.out.println(tokenizer.nextToken());
        }

    }
}
