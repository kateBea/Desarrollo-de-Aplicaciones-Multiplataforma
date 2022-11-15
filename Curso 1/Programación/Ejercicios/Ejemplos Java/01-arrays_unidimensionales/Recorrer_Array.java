import java.io.*;
public class Recorrer_Array {
    public static void main (String [] argumentos) throws IOException{

        //Declaración variables
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

        int[] numeros = new int [10]; //declara e inicializa vector
        System.out.println ("Longitud vector " + numeros.length);
        
        //leer del vector
        for (int posicion=0; posicion < numeros.length; posicion++){
            System.out.println ("Escribe num: ");
            numeros [posicion] = Integer.parseInt(lector.readLine());
        }

        //mostrar vector

        for (int posicion=0; posicion < numeros.length; posicion++){
            System.out.println (numeros[posicion]);            
        }






    }
}
