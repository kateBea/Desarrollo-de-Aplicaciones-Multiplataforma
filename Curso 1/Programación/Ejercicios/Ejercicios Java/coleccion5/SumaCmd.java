package coleccion5;

/*
 * Título: Suma números
 * Algoritmo: Suma una serie de números pasados por la línea de comandos
 * Autor: Hugo Pelayo
 * Fecha: 22.11.2022
 */

public class SumaCmd {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("La lista de argumentos esta vacía.");
            System.out.println("Uso: java SumCmd.java [n1 n2 n3 ... nN]");
        }
        else {
            System.out.println("El resultado es: " + suma(args));
        }
    }

    public static int suma(String[] numeros) {
        int suma = 0;
        for (String numero : numeros) {
            suma = suma + Integer.parseInt(numero);
        }

        return suma;
    }
}