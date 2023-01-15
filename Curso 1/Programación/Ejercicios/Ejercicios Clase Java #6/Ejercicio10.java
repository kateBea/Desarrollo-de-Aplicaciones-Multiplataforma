/* 
 * Este programa calcula las ganancias anuales de una explotación ganadera 
 * vendedora de leche. El mismo programa genera los datos sobre los cuales se
 * trabaja posteriormente.
 * 
 * @author Hugo
 * @version 1.0
 * @date 13 de enero de 2023
 * 
 * 
 */

import java.util.Random;

public class Ejercicio10 {
    private static final float COTA_INF_LITROS = 1000.0f;
    private static final float COTA_SUP_LITROS = 1500.0f;
    private static final float COTA_INF_VENTA = 0.5f;
    private static final float COTA_SUP_VENTA = 1.5f;
    private static final Random rand = new Random();

    public static void main(String[] args) {
        float[][] datos;

        datos = generarDatos();
        mostrarGanancias(datos);
    }

    /*
     * Genera datos aleatorios de ventas
     * 
     * @param None
     * @return float[][] matriz que contiene los datos de venta generados
     * @author Hugo
     */
    public static float[][] generarDatos() {
        final int MESES = 12;
        // la primera fila representa la cantidad de litros vendidos cada mes
        // la segunda fila representa el precio de venta de del mes
        float[][] datos = new float[2][12];

        for (int i = 0; i < MESES; ++i) {
            datos[0][i] = rand.nextFloat(COTA_INF_LITROS, COTA_SUP_LITROS);
            datos[1][i] = rand.nextFloat(COTA_INF_VENTA, COTA_SUP_VENTA);
        }

        return datos;
    }

    /*
     * Muestra por pantalla las ganacias obtenidas de una 
     * serie de ventas realizadas en doce meses
     * 
     * @param datos representa los litros vendidos junto con el precio de venta
     * @return void
     * @authro Hugo
     */
    public static void mostrarGanancias(float[][] datos) {
        final int MESES = 12;
        float ganancias = 0;

        for (int i = 0; i < MESES; ++i)
            // sumatorio ganacias de cada mes
            ganancias += datos[0][i] * datos[1][i];

        System.out.printf("Total de ganancias es: %.4f\n", ganancias);
    }
}
