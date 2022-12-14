import java.io.*;
import java.lang.Math;

public class Ejercicio2 {
    public static void main(String[] args) throws IOException{
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader lector = new BufferedReader(input);
        float radio;

        System.out.print("Introduce el valor del radio de la circunferencia en metros: ");
        radio = Float.parseFloat(lector.readLine());
        
        System.out.printf("La longitud de la circunferencia es: %.3f m2\n", (2 * Math.PI * radio));
        System.out.printf("El área de la circunferencia es: %.3f m2\n", (Math.PI * Math.pow(radio, 2)));
    }
}
