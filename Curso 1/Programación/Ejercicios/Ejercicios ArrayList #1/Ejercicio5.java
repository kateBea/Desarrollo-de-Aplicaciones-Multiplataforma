/*
 * Este programa lee de la entrada de datos una secuencia de cadenas
 * conteniendo números que representan (línea a línea) los kilómetros
 * realizados por un ciclista a lo largo de una semana. Los datos
 * leídos de la entrada de datos se guardan en un ArrayList de String
 * y, por cada línea leída, se guardan en un Vector los datos formateados,
 * 7 valores que representan kilómetros recorridos.
 * 
 * 
 * @author Hugo
 * @version 1.0
 * @date 26 de enero de 2023
 */

import java.util.ArrayList;
import java.util.Vector;

import org.jcp.xml.dsig.internal.dom.Utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Ejercicio5 {
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader lector = new BufferedReader(input);
    public static void main(String[] args) throws IOException {
        ArrayList<String> datos;
        Vector<Float>[] ciclistas;

        // esta constante se inicializa en tiempo de ejecución
        // y representa el total de ciclistas
        final int TOTAL_CICLISTAS;


        datos = leerDatos();
        TOTAL_CICLISTAS = datos.size();
        
        // si los datos introducidos para todos los ciclistas
        // son válidos, entonces podemos proceder a formatearlos
        if (validarDatos(datos))
            ciclistas = formatearDatos(datos);

        imprimirRecorridoCiclistas(ciclistas);
    }

    /*
    * Lee de la entrada de datos una serie de cadenas 
    * hasta que se lee la cadena "Fin". Guarda las cadenas en un objeto String 
    * y estas en un objeto ArrayList. Retorna los datos leídos en forma
    * ArrayList<String> 
    *
    * @param None
    * @return ArrayList<String> el ArrayLists conteniendo las cadenas leídas
    * @author Hugo
    */
    public static ArrayList<String> leerDatos() throws IOException {
        ArrayList<String> resultado = new ArrayList<>();
        String linea;

        while (!(linea = lector.readLine()).equals("Fin"))
            resultado.add(linea.trim());

        return resultado;
    }

    /*
    * Recibe una lista de String y retorna una array de Vectores.
    * Cada Vector de longitud 7 representado valores que se corresponden
    * con los kilómtros recorridos por un ciclista a lo largo de una semana 
    *
    * @param datos la lista de cadenas
    * @return Vector<Float>[] matriz con los datos formateados
    * @author Hugo
    */
    public static Vector<Float>[] formatearDatos(ArrayList<String> datos) {
        Vector<Float>[] resultado = new Vector<Float>[];


        return resultado;
    }

    /*
    * 
    * 
    * @param
    * @return
    * @author Hugo
    */
    public static void imprimirRecorridoCiclistas(Vector<Float>[] ciclistas) {

    }

    /*
    * Recibe un ArrayList y determina si los datos de cada
    * línea son válidos, es decir, por cada línea solo tenemos números decimales 
    * y hay siete de ellos en total. Se comprueba también
    * que no sean valores negativos
    * 
    * @param datos el ArrayLists conteniendo las cadenas leídas
    * @return boolean cierto si todas las cadenas de datos 
    * son válidas, falso en caso contrario
    * @author Hugo
    */
    public static boolean validarDatos(ArrayList<String> datos) {
        boolean validos = true;
        int indexLinea = 0;
        while (indexLinea < datos.size() && validos) {
            
            // obtenemos los datos por líne (los de cada ciclista)
            String[] datosCiclista = datos.get(indexLinea).split(" ");
            
            // tratamos los datos de cada ciclista
            int indexDato = 0;
            while (indexDato < datos.size() && validos) {
                // probar si se puede parsear a número decimal
                // y no que no sea negativo
                if (!Utils.isParsable(datosCiclista[indexDato]) && 
                    !Float.parseFloat(datosCiclista[indexDato]) < 0) {
                        validos = false;
                }                
                else {
                    // si todo correcto, avanzamos al siguiente dato
                    ++indexDato;
                }
            }

            ++indexLinea;
        }

        return validos;
    }
}