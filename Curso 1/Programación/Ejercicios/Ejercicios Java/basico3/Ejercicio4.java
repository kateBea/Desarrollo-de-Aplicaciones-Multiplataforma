package basico3;

import java.io.*;

public class Ejercicio4 {
    public static void main(String[] args) throws IOException {
        InputStreamReader inputStream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStream);
        float num1;
        float num2;
        float num3;

        System.out.print("Introduza el primer número: ");
        num1 = Float.parseFloat(reader.readLine());
        System.out.print("Introduza el segundo número: ");
        num2 = Float.parseFloat(reader.readLine());
        System.out.print("Introduza el tercer número: ");
        num3 = Float.parseFloat(reader.readLine());

        if (num1 == num2 && num2 == num3)
            System.out.println("Son iguales");
        else
            System.out.println("El mayor es: " + mayor(num1, num2, num3));
    }

    public static float mayor(float num1, float num2, float num3) {
        if (num1 > num2)
            return (num1 < num3) ? num3 : num1;
        else
            return (num2 < num3) ? num3 : num2;
    }
}