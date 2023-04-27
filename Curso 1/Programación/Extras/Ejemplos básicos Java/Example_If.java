/* Sintaxis bloque if versión simple
         *  if (expresion_booleano){
         *       // acciones si la condición es True
         *  }
         * 
*/

import java.io.*;
public class Example_If {
    public static void main (String [] argumentos) throws IOException{

        //declaro objeto lector
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        int edad;

        System.out.println ("Escribe tu edad para ver si puedes entrar");
        edad = Integer.parseInt(lector.readLine());
        

        if (edad >= 18){ // si la condición se cumple entra
            System.out.println ("Bienvenido eres mayor de edad");
        }   
        
        System.out.println ("Fin del programa");

    }
 
}
