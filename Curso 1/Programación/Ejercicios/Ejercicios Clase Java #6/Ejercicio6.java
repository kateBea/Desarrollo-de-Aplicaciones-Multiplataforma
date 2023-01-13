/* 
 * Este programa lee de la entrada estándar un tiempo con el formato HH:MM:SS
 * ,es decir, horas, minutos y segundos respectivamente. Muestra por pantalla
 * el tiempo indicado un segundo más tarde.
 * 
 * @author Hugo
 * @version 1.0
 * @date 13 de enero de 2013
 * 
 * 
 */

import java.io.*;

public class Ejercicio6{
    // factor para conversión de horas a segundos
    private static final int HORAS_A_SEGUNDOS = 3600;

    // factor para conversión de minutos a segundos
    private static final int MINUTOS_A_SGUNDOS = 60;

    public static void main(String[] args) throws IOException{
        int tiempoTotalSegundos;
        tiempoTotalSegundos = leerDatos();
        imprimirTiempo(tiempoTotalSegundos + 1);
    }

    /*
     * Retorna un entero que representa el tiempo introducido en segundos.
     * 
     * @param None
     * @return int Tiempo introducido en segundos
     * @authro Hugo
     */
    public static int leerDatos() throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader lector = new BufferedReader(input);
        String[] entrada;

        System.out.print("Introduzca el tiempo. Separado por espacios. ");
        System.out.print("Ejemplo: [17 32 11]: ");
        entrada = lector.readLine().split(" ");

        return Integer.parseInt(entrada[0]) * HORAS_A_SEGUNDOS +
            Integer.parseInt(entrada[1]) * MINUTOS_A_SGUNDOS +
            Integer.parseInt(entrada[2]);
    }

    /*
     * Imprime con formato por la salida de datos estándar el tiempo
     * que se pasa como parámetro.
     * 
     * @param tiempo representa el tiempo a imprimir en segundos
     * @return void
     * @author Hugo
     */
    public static void imprimirTiempo(int tiempo) {
        int horas = (tiempo / HORAS_A_SEGUNDOS) % 24;
        tiempo %= HORAS_A_SEGUNDOS;
        int minutos = tiempo / MINUTOS_A_SGUNDOS;
        tiempo %= MINUTOS_A_SGUNDOS;
        int segundos = tiempo;

        System.out.print(((horas < 10 ? ("0" + horas) : horas) + ":"));
        System.out.print(((minutos < 10 ? ("0" + minutos) : minutos) + ":"));
        System.out.print(((segundos < 10 ? ("0" + segundos) : segundos) + "\n"));
    }
}
