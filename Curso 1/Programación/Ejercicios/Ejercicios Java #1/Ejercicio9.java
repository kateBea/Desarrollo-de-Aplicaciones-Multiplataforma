/* Título: Ejercicio 10
* Algoritmo: Indica si un número es primo o no
* Fecha: 13/11/2022
* Autor: Hugo Pelayo
* */

import java.io.*;

public class Ejercicio9 {
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
        char tipoArticulo;

        // constantes
        final int limiteArticulos = 5;
        final float valorFactura = 600;
        final float precioPorLitroTipo1 = 0.6f;
        final float precioPorLitroTipo2 = 3.0f;
        final float precioPorLitroTipo3 = 1.25f;

        // variables de calculos
        int cantidadLitrosArticuloUno = 0;  // cantidad en litros vendida del primer art
        float facturacionTotal = 0;         // facturación total de todos los artículos
        int facturasEnRango = 0;       // facturas emitidas de más de 600 euros
        float precioPorLitro = 0;

        for(int i = 0; i < limiteArticulos; ++i) {
            // lectura de datos
            System.out.printf("Datos de artículo #%d\n", (i + 1));
            System.out.print("Introduzca el código de artículo:         ");
            codigoArticulo = Integer.parseInt(reader.readLine());
            System.out.print("Introduzca la cantidad vendida en litros: ");
            cantidadEnLitros = Integer.parseInt(reader.readLine());
            System.out.print("Introduzca el tipo de artículo [a, b, c]: ");
            tipoArticulo = reader.readLine().charAt(0);

            // registrar cantidad en litros del artículo 1
            if (i == 0) {
                cantidadLitrosArticuloUno = cantidadEnLitros;
            }

            switch(tipoArticulo) {
                case 'a':
                    precioPorLitro = precioPorLitroTipo1;
                    break;
                case 'b':
                    precioPorLitro = precioPorLitroTipo2;
                    break;
                case 'c':
                    precioPorLitro = precioPorLitroTipo3;
                    break;
                default:
                    System.out.println("Identificador de artículo inválido, por favor inténtelo de nuevo: ");

                    do {
                        System.out.print("Introduzca el tipo de artículo [a, b, c]: ");
                        tipoArticulo = reader.readLine().charAt(0);
                    }
                    while (!(tipoArticulo == 'a' || tipoArticulo == 'b' || tipoArticulo == 'c'));
                    break;
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