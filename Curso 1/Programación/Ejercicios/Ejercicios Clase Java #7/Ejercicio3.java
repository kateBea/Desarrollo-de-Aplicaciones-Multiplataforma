import java.io.*;

public class Ejercicio3 {
    public static void main(String[] args) throws IOException {
        int num1 = 0;
        int num2 = 0;

        num1 = leerNumero();
        num2 = leerNumero();

        if (num1 == num2)
            System.out.println("Ambos son iguales.");
        else 
            System.out.println("El mayor es: " + mayor(num1, num2));
    }
    
    public static int leerNumero() throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader lector = new BufferedReader(input);

        System.out.print("Introcue un número: ");
        return Integer.parseInt(lector.readLine());
    }

    public static Integer mayor(int a, int b) {
        return a < b ? b : a; 
    }
}