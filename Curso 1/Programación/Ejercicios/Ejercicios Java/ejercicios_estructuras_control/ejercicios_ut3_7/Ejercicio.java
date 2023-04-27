package ejercicios_estructuras_control.ejercicios_ut3_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio {
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader reader = new BufferedReader(input);

    private static final int[] diasPorMes = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    public static void main(String[] args) throws IOException{
        int dia;
        int mes;
        int anio;

        System.out.print("Introduce un día (1-31): ");
        dia = Integer.parseInt(reader.readLine());
        System.out.print("\nIntroduce un mes (1-12): ");
        mes = Integer.parseInt(reader.readLine());
        System.out.print("\nIntroduce un año (1500-2200): ");
        anio = Integer.parseInt(reader.readLine());

        System.out.printf("\nFecha introducida: %d/%d/%d\n\n", dia, mes, anio);
        
        if (valida(dia, mes, anio))
            System.out.println("Fecha válida");
        else 
            System.out.println("Fecha NO válida");
    }

    public static boolean valida(int dia, int mes, int anio) {
        // si año es bisiesto febrero tiene 29 días (un día más)
        // si no pues se queda con el número de días establecido, que son 28 (sumamos 1 al final porque tenemos un menor stricto)
        return (dia > 0 && dia < (diasPorMes[mes - 1] + ((esBisiesto(anio) && mes == 2) ? 1 : 0)) + 1) &&
               (mes > 1 && mes < 12) &&
               (anio > 1499 && anio < 2201);

    }

    public static boolean esBisiesto(int anio) {
        return anio % 4 == 0;
    }
}