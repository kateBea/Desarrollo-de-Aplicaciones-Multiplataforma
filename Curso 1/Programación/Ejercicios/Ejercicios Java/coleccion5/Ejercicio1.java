package coleccion5;

/*
 * Título: Ejercicio 1
 * Algoritmo: Escribir un programa que pida una palabra y un entero n y vaya rotando el carácter 
 * inicial de la palabra, al final de la misma, tantas veces como indique n.
 * (Por ejemplo, “monja”,3 debe devolver “jamon” y “monja”;5 “monja”).
 * Autor: Hugo Pelayo
 * Fecha: 22.11.2022
 */

public class Ejercicio1 {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Este programa espera dos argumentos.");
            System.out.println("Uso: java Ejercicio1.java [palabra] [numeroRotaciones] [direccion (L/R)]");
        }
        else {
            rotar(args[0], Integer.parseInt(args[1]), args[2].charAt(0));
        }
    }    

    public static void rotar(String cadena, int veces, char dirRotacion) {
        for (int i = 0; i < veces; ++i) {
            // bucle exterior controla cuántas veces tengo
            // que rotar los caracteres. 
            if (dirRotacion == 'L')
                cadena = rotaIzq(cadena);
            else 
                cadena = rotaDer(cadena);
        }

        System.out.println("Cadena rotada [" + veces + "] veces: " + cadena);
    }

    public static String rotaIzq(String str) {
        StringBuffer result = new StringBuffer(str);

        // Se guarda el último carácter porque se 
        // va a sobreescribir en el bucle
        char backUp = str.charAt(str.length() - 1);
        for (int i = 0; i < str.length() - 1; ++i) {
            result.setCharAt(i + 1, str.charAt(i));
        }
        
        result.setCharAt(0, backUp);
        return result.toString();
    }

    public static String rotaDer(String str) {
        StringBuffer result = new StringBuffer(str);

        // Se guarda el primer carácter porque se 
        // va a sobreescribir en el bucle
        char backUp = str.charAt(0);
        for (int i = result.length() - 1; i > 0; --i) {
            result.setCharAt(i - 1, str.charAt(i));
        }
        
        result.setCharAt(result.length() - 1, backUp);
        return result.toString();
    }
}