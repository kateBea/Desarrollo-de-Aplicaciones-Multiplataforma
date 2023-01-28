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
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Ejercicio5 {
    // espacios insertados para formatear la salida de datos
    private static final String[] diasSemana = { "Lunes    ", "Martes   ", "Miércoles", "Jueves   ", "Viernes  ", "Sábado   ", "Domingo  " };  
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader lector = new BufferedReader(input);
    public static void main(String[] args) throws IOException {
        ArrayList<String> datos;
        ArrayList<Vector<Float>> ciclistas;

        datos = leerDatos();
        
        // si los datos introducidos para todos los ciclistas
        // son válidos, entonces podemos proceder a formatearlos
        if (validarDatos(datos)) {
            System.out.println("**************** Se han validado los datos ****************");
            ciclistas = formatearDatos(datos);
            imprimirRecorridoCiclistas(ciclistas);
        }
        else {
            System.out.println("**************** No se han validado los datos ****************");
        }

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
    public static ArrayList<Vector<Float>> formatearDatos(ArrayList<String> datos) {
        int indiceFila = 0;
        ArrayList<Vector<Float>> resultado = new ArrayList<Vector<Float>>(datos.size());

        for (String datoPorCiclista : datos) {
            resultado.add(indiceFila, new Vector<>());
            for (String valor : datoPorCiclista.split(" ")) {
                resultado.get(indiceFila).add(Float.parseFloat(valor));
            }

            indiceFila++;
        }

        return resultado;
    }

    /*
    * Este método imprime la información de todos los ciclistas
    * 
    * @param ciclistas El ArrayList conteniendo los datos de los ciclistas
    * @return void
    * @author Hugo
    */
    public static void imprimirRecorridoCiclistas(ArrayList<Vector<Float>> ciclistas) {
        for (Vector<Float> datosCiclista : ciclistas) {
            // itera sobre los días de la
            // semana del vector de diasSemana
            // ver cabecera para más información
            int indice = 0;
            for (Float dato : datosCiclista) {
                System.out.println(diasSemana[indice++] + ": " + dato + " kM (s) recorridos");
            }

            System.out.println();
        }
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
            
            // obtenemos los datos por línea
            String[] datosCiclista = datos.get(indexLinea).split(" ");
            
            // tratamos los datos de cada ciclista
            int indexDato = 0;
            while (indexDato < datos.size() && validos) {
                // probar si se puede parsear a número decimal
                // y que no sea negativo
                // TODO: falta la primera parte
                if ((Float.parseFloat(datosCiclista[indexDato]) < 0)) {
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