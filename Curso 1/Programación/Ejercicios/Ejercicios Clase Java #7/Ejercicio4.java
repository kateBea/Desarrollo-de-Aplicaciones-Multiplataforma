import java.io.*;

public class Ejercicio4 {
    public static void main(String[] args) throws IOException {
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;

        num1 = leerNumero();
        num2 = leerNumero();
        num3 = leerNumero();

        if (num1 == num2 && num2 == num3)
            System.out.println("Los tres son iguales son iguales.");
        else 
            System.out.println("El mayor es: " + mayor(num1, num2, num3));
    }
    
    public static int leerNumero() throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader lector = new BufferedReader(input);

        System.out.print("Introcue un número: ");
        return Integer.parseInt(lector.readLine());
    }

    public static Integer mayor(int a, int b, int c) {
        return (a < b) ? (b < c ? c : b) : (a < c ? c : a);
    }
}