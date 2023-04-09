package estructuras_control.ejerciciosUT3_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* Este programa piede una fecha por la entrada de datos y la valida
* 
* Creado por Hugo Pelayo
* 25 de marzo de 2023
*/
public class Ejercicio {
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader reader = new BufferedReader(input);

    private static final int[] diasPorMes = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    public static void main(String[] args) throws IOException{
        int dia =  leerEntero("Introduce un día (1-31): ");
        int mes = leerEntero("\nIntroduce un mes (1-12): ");
        int anio = leerEntero("\nIntroduce un año (1500-2200): ");

        System.out.printf("\nFecha introducida: %d/%d/%d\n\n", dia, mes, anio);
        
        if (valida(dia, mes, anio))
            System.out.println("Fecha válida");
        else 
            System.out.println("Fecha NO válida");
    }

    /*
     * Retorna cierto si la fecha indicada por los parámetros
     * es una fecha válida. "dia" hace referencia al día de la fecha,
     * "mes" refiere al mes y "anio" al año
     */
    public static boolean valida(int dia, int mes, int anio) {
        // si año es bisiesto febrero tiene 29 días (un día más)
        // si no pues se queda con el número de días establecido, que son 28 (sumamos 1 al final porque tenemos un menor stricto)
        // (es necesari validar el mes primero porque usamos un array de meses, si el més está fuera de rango hay problemas)
        return (mes > 1 && mes < 12) &&
               (dia > 0 && dia < (diasPorMes[mes - 1] + ((esBisiesto(anio) && mes == 2) ? 1 : 0)) + 1) &&
               (anio > 1499 && anio < 2201);

    }

    /*
     * Retorna cierto si "anio" es un año bisiesto, 
     * retorna falso en caso contrario
     */
    public static boolean esBisiesto(int anio) {
        return anio % 4 == 0;
    }

    /*
     * Lee un entero de la entrada estándar mostrando primero
     * el mensaje que se pasa como parámetro
     */
    public static int leerEntero(String promt) {
        int result = 0;
        System.out.print(promt);
        try {
            result = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException | IOException e) {
            System.out.println("Entrada inválida");
        }
        return result;
    }
}