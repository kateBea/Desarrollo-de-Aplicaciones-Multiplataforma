/********************
 * Ejemplo 01: pedir datos de distinto tipo por pantalla
 * Fecha: Noviembre 22
 * Autor: RLR
 * ***************/
//importo los paquetes necesarios
import java.io.*; //* el asterisco importa todas las clases del paquete java.io */


class PedirDato{
    public static void main (String [] argumentos) throws IOException{
        //enla función main se captura la excepción IOException que lanzará lector.readLine()

        //nos declaramos un objeto lector para leer datos
        BufferedReader lector  = new BufferedReader (new InputStreamReader (System.in));
        
        
        int dato; 
        float datoReal;
        String datoCadena;

        //Pedimos al usuario un nº entero
        System.out.print("Introduce nº, pf: ");
        dato = Integer.parseInt(lector.readLine());


        //Pedimos el nº real
        System.out.print ("Escribe un número decimal, pf: ");
        datoReal = Float.parseFloat(lector.readLine());

        //Pedimos una cadena
        System.out.print("Escribe una cadena, pf: ");
        datoCadena = lector.readLine();

        //Mostramos los datos
        System.out.println("El dato es: " + dato);
        System.out.println("El nº real es: " + datoReal);
        System.out.println ("La cadena es: " + datoCadena);
    } //fin main

}//fin programa
