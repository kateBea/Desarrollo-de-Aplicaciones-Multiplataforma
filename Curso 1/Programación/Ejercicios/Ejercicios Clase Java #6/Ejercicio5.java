import java.io.*;

public class Ejercicio5 {
    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader lector = new BufferedReader(input);
        int numero1;
        
        System.out.print("Introduce un número entero: ");
        numero1 = Integer.parseInt(lector.readLine());

        System.out.println("El entero[ " + numero1 + " ] es " + (esPar(numero1) ? "par." : "impar."));

    }

    public static boolean esPar(int numero) {
        return numero % 2 == 0;
    }
}
