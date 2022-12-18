import java.util.Random;

public class Ejercicio10 {
    private static final int COTA_INF_LITROS = 1000;
    private static final int COTA_SUP_LITROS = 1500;
    private static final float COTA_INF_VENTA = 0.5f;
    private static final float COTA_SUP_VENTA = 1.5f;
    private static final Random rand = new Random();

    public static void main(String[] args) {
        float[][] datos = new float[2][12];

        generarDatos(datos);
        mostrarGanancias(datos);
    }

    public static void generarDatos(float[][] datos) {
        final int MESES = 12;

        for (int i = 0; i < MESES; ++i) {
            datos[0][i] = (float)rand.nextInt(COTA_INF_LITROS, COTA_SUP_LITROS);
            datos[1][i] = rand.nextFloat(COTA_INF_VENTA, COTA_SUP_VENTA);
        }
    }

    public static void mostrarGanancias(float[][] datos ) {
        final int MESES = 12;
        float ganancias = 0;

        for (int i = 0; i < MESES; ++i)
            // sumatorio ganacias de cada mes
            ganancias += datos[0][i] * datos[1][i];

        System.out.printf("Total de ganancias es: %.4f\n", ganancias);
    }
}
