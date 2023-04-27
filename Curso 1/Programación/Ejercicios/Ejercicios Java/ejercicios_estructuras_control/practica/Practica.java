package ejercicios_estructuras_control.practica;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;

public class Practica {
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader lector = new BufferedReader(input);
    public static void main(String[] args) throws IOException {
        int opcion;
        boolean correcto = false;

        
        do {
            mostrarMenu();
            opcion = Integer.parseInt(lector.readLine());

            correcto = opcion >= 1 && opcion <= 3;

        }
        while(!correcto);

        switch(opcion) {
            case 1 -> dibujarCuadrado();
            case 2 -> dibujarRectangulo();
            case 3 -> dibujarTriangulo();
        }
    }

    public static void dibujarCuadrado() throws IOException {
        int lado;
        
        do {
            System.out.print("\nIntroduzca la longitud del lado: ");
            lado = Integer.parseInt(lector.readLine());
        }
        while(lado < 2);

        // cantidad de espacios entre caracteres
        char[] espacios = new char[lado - 2];
        Arrays.fill(espacios, ' ');
        String esp = new String(espacios);

        System.out.println();

        for (int i = 0; i < lado; ++i) {
            if (i == 0 || i == lado - 1) {
                for (int j = 0; j < lado; ++j)
                    System.out.print('*');
            }
            else {
                System.out.print('*');
                System.out.print(esp);
                System.out.print('*');

            }

            System.out.println();
        }

        System.out.println("\nCuadrado terminado");
    }

    public static void dibujarRectangulo() throws IOException {
        int base;
        int altura;
        
        do {
            System.out.print("\nIntroduzca la longitud de la base: ");
            base = Integer.parseInt(lector.readLine());

            System.out.print("\nIntroduzca la longitud de la altura: ");
            altura = Integer.parseInt(lector.readLine());
        }
        while(base < 0 && base > altura);

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

    public static void dibujarTriangulo() throws IOException {
        int base;
        int altura;
        
        do {
            System.out.print("\nIntroduzca un valor impar para la longitud de la base: ");
            base = Integer.parseInt(lector.readLine());

        }
        while(base < 0);

        altura = (base - 1) / 2;
        int contadorEspaciosInteriores = 0;
        int contadorEspaciosExteriores = altura;

        for (int i = 0; i <= altura; ++i) {
            if (i == altura) {
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

    public static void mostrarMenu() {
        System.out.print(
            String.format("Figuras disponibles: \n" +
                          "\n1 Cuadrado\n" +
                          "\n2 Rectángulo\n" +
                          "\n3 Triángulo\n\n" +
                          "Pulsa el número de la opción deseada: ")
        );
    }
}