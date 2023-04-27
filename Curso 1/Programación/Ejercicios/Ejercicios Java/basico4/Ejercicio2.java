package basico4;

import java.util.Random;

public class Ejercicio2 {
    private static final int COTA_INFERIOR = 0;
    private static final int COTA_SUPERIOR = 300000;
    private static final Random rand = new Random();
    public static void main(String[] args) {
        final int FILAS = 3;
        final int COLUMNAS = 20;

        float[][] sueldos_empleados = new float[FILAS][COLUMNAS];

        generarSueldos(sueldos_empleados);
        calcularRetencion(sueldos_empleados);
        calcularSalarioNeto(sueldos_empleados);
        imprimir(sueldos_empleados);
    }

    public static void generarSueldos(float[][] matriz) {
        for (int index = 0; index < matriz[0].length; ++index) {
            matriz[0][index] = rand.nextFloat(COTA_INFERIOR, COTA_SUPERIOR + 1);
        }
    }

    public static void calcularRetencion(float[][] matriz) {
        for (int index = 0; index < matriz[0].length; ++index) {
            // retención en procentajes
            if (matriz[0][index] >= 0 && matriz[0][index] <= 17707)
                matriz[1][index] = 24.0f;
            else if (matriz[0][index] <= 33007)
                matriz[1][index] = 30.0f;
            else if (matriz[0][index] <= 53407)
                matriz[1][index] = 40.0f;
            else if (matriz[0][index] <= 120000)
                matriz[1][index] = 47.0f;
            else if (matriz[0][index] <= 175000)
                matriz[1][index] = 49.0f;
            else if (matriz[0][index] <= 300000)
                matriz[1][index] = 51.0f;
        }
    }

    public static void calcularSalarioNeto(float[][] matriz) {
        for (int index = 0; index < matriz[0].length; ++index) {
            matriz[2][index] = matriz[0][index] - (matriz[0][index] * (matriz[1][index] / 100.0f));
        }
    }

    public static void imprimir(float[][] sueldos_empleados) {
        final int TOTAL_EMPLEADOS = sueldos_empleados[0].length;
        System.out.println("                Sueldo    Retención    Salario Bruto");
        System.out.println("                ------    ---------    -------------");
        for (int index = 0; index < TOTAL_EMPLEADOS; ++index) {
            if (index + 1 < 10)
                System.out.print("Empleado #" + (index + 1) + "  ");
            else
                System.out.print("Empleado #" + (index + 1) + " ");
            System.out.println("  " + sueldos_empleados[0][index] + "     " +  
                    sueldos_empleados[1][index] + "         " + sueldos_empleados[2][index]);
        }
    }
}