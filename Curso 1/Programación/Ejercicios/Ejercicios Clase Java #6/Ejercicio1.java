import java.lang.Math;
import java.util.Scanner;

public class Ejercicio1 {
    private static final Scanner lector = new Scanner(System.in);

    public static void main(String[] args) {
        int numero;
        System.out.print("Introduce un número: ");
        numero = Math.round(lector.nextFloat());
        System.out.println("Valor redondeado es: " + numero);
        
        lector.close();
    }
}
