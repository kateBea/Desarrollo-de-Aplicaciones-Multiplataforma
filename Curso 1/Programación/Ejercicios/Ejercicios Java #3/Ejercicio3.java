import java.io.*;

public class Ejercicio3 {
    public static void main(String[] args) throws IOException {
        InputStreamReader inputStream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStream);
        float num1;
        float num2;

        System.out.print("Introduza el primer número: ");
        num1 = Float.parseFloat(reader.readLine());
        System.out.print("Introduza el segundo número: ");
        num2 = Float.parseFloat(reader.readLine());

        if (num1 == num2)
            System.out.println("Son iguales");
        else
            System.out.println("El mayor es: " + mayor(num1, num2));
    }

    public static float mayor(float num1, float num2) {
        return num1 < num2 ? num2 : num1;
    }
}