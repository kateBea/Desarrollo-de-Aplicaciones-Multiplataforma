/*
 Escribir un programa que pida una palabra y un entero n y vaya rotando el carácter inicial de la palabra,
 al final de la misma, tantas veces como indique n.

 Fecha: nov 22
 */
import java.io.*;
public class Rota {
    public static void main (String args[]) throws IOException{
        BufferedReader entrada = new BufferedReader(new InputStreamReader((System.in)));
        System.out.println ("Escriba una palabra: ");
        String palabra = entrada.readLine();
        System.out.println ("Teclee nº posiciones a rotar ");
        int veces = Integer.parseInt (entrada.readLine());
        System.out.println ( palabra + " rota " + veces + " --->" + rotar (palabra, veces));
    }
    public static String rotar (String s, int n){
        for (int i=0; i<n;i++){
            s = s.substring(1).concat(s.substring(0,1));
        }
        return s;
    }
}
