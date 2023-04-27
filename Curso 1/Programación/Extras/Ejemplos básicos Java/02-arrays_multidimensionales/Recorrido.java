
/* Para recorrer una matriz necesitaremos dos bucles anidados
 * Uno para recorrer cada fila y otro para las columnas de cada fila
 * En este ejemplo se mostrará con for y for-each
 * Suponemos que tenemos las notas de 3 asignaturas para 5 alumnos
 * Las asignaturas serán las filas
 * Las notas de alumnos serán las columnas
 */
import java.io.*;

public class Recorrido {
    public static void main(String[] argumentos) throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        float[][] notas = new float[3][5];

        // Recorremos con dos bucles for la matriz para leer datos
        for (int fila = 0; fila < notas.length; fila++) { // recorre las filas
            // para cada fila recorremos las cols con otro bucle
            for (int col = 0; col < notas[fila].length; col++) {
                System.out.println("Para la asignatura " + (fila + 1) + " escribe la nota " + (col + 1));
                notas[fila][col] = Float.parseFloat(lector.readLine());

            }

        }

        // Recorremos con dos for-each para mostrar (para probar otra forma)
        for (float[] asignatura : notas) // recorre primera dimensión
            for (float puntuacion : asignatura) // recorre la segunda dimensión
                System.out.println("La nota de la asignatura es " + puntuacion);

    }
}
