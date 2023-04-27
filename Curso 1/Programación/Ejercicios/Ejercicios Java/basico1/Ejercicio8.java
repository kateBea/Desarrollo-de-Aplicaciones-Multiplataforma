package basico1;

/* Título: Ejercicio 8
* Algoritmo: Gestor de facturas
* Fecha: 13/11/2022
* Autor: Hugo Pelayo
* */

import java.io.*;

public class Ejercicio8 {
    public static void main(String[] args) throws IOException {
        /*
            Por cada factura de artículo desinfectante tenemos:
                - Código de artículo
                - Cantidad vendida en litros
                - Precio en litro
         */

        InputStreamReader inputReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputReader);
        // variables de entrada
        int codigoArticulo;
        int cantidadEnLitros;
        float precioPorLitro;

        // constantes
        final int limiteArticulos = 5;
        final float valorFactura = 600;

        // variables de calculos
        int cantidadLitrosArticuloUno = 0;  // cantidad en litros vendida del primer art
        float facturacionTotal = 0;         // facturación total de todos los artículos
        int facturasEnRango = 0;       // facturas emitidas de más de 600 euros

        for(int i = 0; i < limiteArticulos; ++i) {
            // lectura de datos
            System.out.printf("Datos de artículo #%d\n", (i + 1));
            System.out.print("Introduzca el código de artículo:         ");
            codigoArticulo = Integer.parseInt(reader.readLine());
            System.out.print("Introduzca la cantidad vendida en litros: ");
            cantidadEnLitros = Integer.parseInt(reader.readLine());
            System.out.print("Introduzca el precio en litros:           ");
            precioPorLitro = Float.parseFloat(reader.readLine());

            // registrar cantidad en litros del artículo 1
            if (i == 0) {
                cantidadLitrosArticuloUno = codigoArticulo;
            }

            facturacionTotal += (float)cantidadEnLitros * precioPorLitro;

            if (((float)cantidadEnLitros * precioPorLitro) > valorFactura)
                ++facturasEnRango;
        }

        System.out.println("Facturación total es de: " + facturacionTotal);
        System.out.println("Cantidad facturada en litros del artículo 1 es de: " + cantidadLitrosArticuloUno);
        System.out.println("Total de facturas emitidas de mas de " + valorFactura + ": " + facturasEnRango);
    }
}