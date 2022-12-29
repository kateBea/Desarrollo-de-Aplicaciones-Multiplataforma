import java.io.*;

public class Ejercicio11 {
    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader lector = new BufferedReader(input);
        String[] cadena;

        System.out.print("Introduce cadena: ");
        cadena = lector.readLine().trim().split(" ");

        for (int indice = 0; indice < cadena.length; ++indice) {
            System.out.print(cadena[cadena.length - 1 - indice] + " ");
        }
    }
}