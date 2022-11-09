/* Fecha: 8/11/22
 * Autor: RLR
 * Descripción: programa solicita dos nums decimales y hace operaciones básicas
 *              de suma, resta, multiplicación y división
 */
import java.io.*;

public class Ej_operaciones {    
    public static void main (String [] args) throws IOException{
        //creamos objeto lector
        BufferedReader lector = new BufferedReader (new InputStreamReader(System.in));
        
        //declaración de variables
        float num1, num2, resultado;

        //Pedimos los números al usuario
        System.out.print("Escribe num1: ");
        num1 = Float.parseFloat(lector.readLine());

        System.out.print("Escribe num2: ");
        num2 = Float.parseFloat(lector.readLine());

        resultado = num1+num2;
        System.out.println ("La suma " + num1 + " + " + num2 + " = " + resultado);
            
        resultado = num1- num2;
        System.out.println ("La resta " + num1 + " - " + num2 + " = " + resultado);

        resultado = num1*num2;
        System.out.println ("La multiplicación " + num1 + " * " + num2 + " = " + resultado);

        //podría no haber declarado resultado y mostrar el valor como en la división
        System.out.println ("La división " + num1 + " / " + num2 + " = " + (num1/num2));
    }
}
