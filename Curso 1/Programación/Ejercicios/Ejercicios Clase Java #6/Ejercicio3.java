/* 
 * Este programa calcula la longitud y el área de una circunferencia
 * dada la fórmula  2π * radio como definción de la longitud y π * radio * radio
 * como definición del area de la misma.
 * 
 * 
 * @author Hugo
 * @version 1.0
 * @date 13 de enero de 2013
 * 
 * 
 */

import java.io.*;

public class Ejercicio3 {
    public static void main(String[] args) throws IOException {
        float[] punto1;
        float[] punto2;

        punto1 = transformarCoordenadas(leerPunto());
        punto2 = transformarCoordenadas(leerPunto());

        System.out.println("La pendiente de la línea es: " + pendiente(punto1, punto2));
    }

    /*
     * Retorna un array de dos decimales donde la primera posición
     * representa la coordenada x de un punto y la segunda posicón
     * representa la coordenada y.
     * 
     * @param punto reprensenta el punto a ser transformado
     * @return float[2] array representando un punto en el espacio euclídeo
     * @author Hugo
     */
    public static float[] transformarCoordenadas(String punto) {
         // [0] -> coordenada x, [1] -> coordenada y
        float[] resultado = new float[2];
        resultado[0] = Float.parseFloat(punto.split(" ")[0]);
        resultado[1] = Float.parseFloat(punto.split(" ")[1]);

        return resultado;
    }

    /*
     * Lee de la entrada estándar un String que representa un punto
     * en el espacio plano.
     * 
     * @param None
     * @return String cadena representando un punto en el espacio euclídeo
     * @author Hugo
     */
    public static String leerPunto() throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader lector = new BufferedReader(input);
        String punto;

        System.out.print("Introduce coordenadas del punto. Ejemplo [3.1 4.2]: ");
        punto = lector.readLine();

        return punto;
    }

    /*
     * Dados dos puntos en el plano euclídeo, calcula la pendiente
     * del vector generado por ambos.
     * 
     * @param p1 punto en el espacio euclídeo
     * @param p2 punto en el espacio euclídeo
     * @return float valor de la pendiente
     * @author Hugo
     */
    public static float pendiente(float[] p1, float[] p2) {
        return (p2[1] - p1[1]) / (p2[0] - p1[0]); 
    }
}
