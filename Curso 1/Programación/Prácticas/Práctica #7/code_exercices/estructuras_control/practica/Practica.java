package estructuras_control.practica;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;

/*
* Este programa permite dibujar tres tipos de figuras geométricas: 
* triángulos, círculos y rectángulos. Dota al usuario de la posibilidad
* de escoger qué figura dibujar
* 
* Creado por Hugo Pelayo
* 25 de marzo de 2023
*/
public class Practica {
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader lector = new BufferedReader(input);

    public static void main(String[] args){
        // para el control del bucle principal
        int opcion;
        boolean correcto = false;

        // para la impresión de figuras
        int lado;
        int base;
        int altura;
        
   
        do {
            mostrarMenu();
            opcion = leerEntero(null);

            if (!(correcto = opcion >= 1 && opcion <= 3))
                System.out.println("índice no válido");

        }
        while(!correcto);

        switch(opcion) {
            case 1 -> {
                do 
                    lado = leerEntero("\nIntroduzca la longitud del lado: ");
                while(lado < 2);
                dibujarCuadrado(lado);    
            }
            case 2 -> {
                do {
                    base = leerEntero("\nIntroduzca la longitud de la base: ");
                    altura = leerEntero("\nIntroduzca la longitud de la altura: ");
                }
                while(base < 0 && base > altura);
                dibujarRectangulo(base, altura);

            }
            
            case 3 -> {
                do 
                    base = leerEntero("\nIntroduzca un valor impar para la longitud de la base: ");
                while(base < 0);
                dibujarTriangulo(base);
            }
            
        }
    }

    /*
     * Dibuja un cuadrado por la consola usando asteriscos para su representación
     */
    public static void dibujarCuadrado(int lado) {
        dibujarRectangulo(lado, lado);
        System.out.println("\nCuadrado terminado");
    }

    /*
     * Dibuja un rectángulo por la consola usando asteriscos para su representación
     */
    public static void dibujarRectangulo(int base, int altura) {
        // cantidad de espacios entre caracteres
        char[] espacios = new char[base - 2];
        Arrays.fill(espacios, ' ');
        String esp = new String(espacios);

        System.out.println();

        for (int i = 0; i < altura; ++i) {
            if (i == 0 || i == altura - 1) {
                for (int j = 0; j < base; ++j)
                    System.out.print('*');
            }
            else {
                System.out.print('*');
                System.out.print(esp);
                System.out.print('*');

            }

            System.out.println();
        }

        System.out.println("\nRectángulo terminado");
    }

    /*
     * Dibuja un triángulo por la consola usando asteriscos para su representación
     */
    public static void dibujarTriangulo(int base) {
        int altura = (base - 1) / 2;
        int contadorEspaciosInteriores = 0;
        int contadorEspaciosExteriores = altura;

        for (int i = 0; i <= altura; ++i) {
            if (i == altura) {
                // abajo de todo pintamos tantos asteriscos 
                // como longitud de base tenemos
                for (int j = 0; j < base; ++j)
                    System.out.print('*');
            }
            else {
                for (int k = 0; k < contadorEspaciosExteriores; ++k)
                    System.out.print(' ');

                System.out.print('*');

                for (int k = 0; k < contadorEspaciosInteriores; ++k)
                    System.out.print(' ');

                if (i > 0)
                    System.out.print('*');
                

                contadorEspaciosExteriores = contadorEspaciosExteriores - 1;
                contadorEspaciosInteriores += (i > 0) ? 2 : 1;
            }

            System.out.println();
        }
    }

    /*
     * Muestra un menú por la consola con las diferentes
     * opciones para figuras geométricas
     */
    public static void mostrarMenu() {
        System.out.print(
            String.format("Figuras disponibles: \n" +
                          "\n1 Cuadrado\n" +
                          "\n2 Rectángulo\n" +
                          "\n3 Triángulo\n\n" +
                          "Pulsa el número de la opción deseada: ")
        );
    }

    /*
     * Lee un entero de la entrada estándar mostrando primero
     * el mensaje que se pasa como parámetro
     */
    public static int leerEntero(String promt) {
        int result;
        if (promt != null)
            System.out.print(promt);

        try {
            result = Integer.parseInt(lector.readLine());
        } 
        catch (NumberFormatException | IOException e) {
            System.out.println("Valor entero no válido");
            result = 0;
        }
        return result;
    }
}