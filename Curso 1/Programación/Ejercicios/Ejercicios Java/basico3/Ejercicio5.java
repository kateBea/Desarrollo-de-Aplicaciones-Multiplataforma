package basico3;

import java.io.*;

public class Ejercicio5 {
    public static void main(String... args) throws IOException{
        InputStreamReader inputStream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStream);

        double operando1;
        double operando2;
        char operacion;

        System.out.print("Entra el valor del operando uno: ");
        operando1 = Float.parseFloat(reader.readLine());
        System.out.print("Entra el valor del operando dos: ");
        operando2 = Float.parseFloat(reader.readLine());
        System.out.print("Entra el valor del operando uno: ");
        operacion = reader.readLine().charAt(0);

        operacion(operando1, operando2, operacion);
    }

    public static void operacion(double op1, double op2, char op) {
        switch (op) {
            case '+' -> System.out.printf("%.3f + %.3f = %.3f\n", op1, op2, op1 + op2);
            case '-' -> System.out.printf("%.3f - %.3f = %.3f\n", op1, op2, op1 - op2);
            case '*' -> System.out.printf("%.3f * %.3f = %.3f\n", op1, op2, op1 * op2);
            case '/' -> {
                if (op2 == 0)
                    System.out.printf("Excepción división por 0...\n");
                else
                    System.out.printf("%.3f / %.3f = %.3f", op1, op2, op1 / op2);
            }
        }
    }
}
