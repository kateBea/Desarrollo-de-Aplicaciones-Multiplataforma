import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;

public class Ejercicio9 {
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader lector = new BufferedReader(input);

    public static void main(String[] args) throws IOException {
        gestor();
    }

    public static void gestor() throws IOException {
        System.out.print("Entre un número aleatorio entre 1 y 10 (ambos inclusos): ");
        String[] frases;
        int tamanioArray;
        int index;

        tamanioArray = Integer.parseInt(lector.readLine());
        frases = leerFrases(tamanioArray);


        do {
            mostrarMenu();

            System.out.print("Elección: ");
            index = Integer.parseInt(lector.readLine());

            if (!(index > 0 && index < 8))
                System.out.println("Índice fuera de rango, intenta de nuevo.");
            else {
                switch (index) {
                    case 1 -> mostrarContenido(frases);
                    case 2 -> mostrarContenidoMinusc(frases);
                    case 3 -> mostrarContenidoMayus(frases);
                    case 4 -> mostrarPrimLetraMinus(frases);
                    case 5 -> mostrarNumVocCons(frases);
                    case 6 -> mostrarContenidoMasLargo(frases);
                }
            }
        }
        while (index != 7);
    }

    public static String[] leerFrases(int limite) throws IOException {
        String[] result = new String[limite];
        for (int i = 0; i < limite; ++i) {
            System.out.println("Introduzca frase #" + (i + 1) + ":");
            result[i] = lector.readLine();
        }

        return result;
    }

    public static void mostrarMenu() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("1. Mostrar contenido del vector.");
        System.out.println("2. Mostrar todo el contenido en minúsculas.");
        System.out.println("3. Mostrar todo el contenido en mayúsculas.");
        System.out.println("4. Mostrar el contenido con la primera letra de cada palabra en minúsculas.");
        System.out.println("5. Mostrar el número de vocales y de consonantes de cada texto en cada posición.");
        System.out.println("6. Mostrar el contenido más largo.");
        System.out.println("7. Salir");
        System.out.println("--------------------------------------------------------------------------------");
    }

    public static void mostrarContenido(String[] frases) {
        for (int index = 0; index < frases.length; ++index) {
            System.out.println("Frase #" + (index + 1) + ": " + frases[index]);
        }
    }

    public static void mostrarContenidoMinusc(String[] frases) {
        for (int index = 0; index < frases.length; ++index) {
            System.out.println("Frase #" + (index + 1) + ": " + frases[index].toLowerCase());
        }
    }

    public static void mostrarContenidoMayus(String[] frases) {
        for (int index = 0; index < frases.length; ++index) {
            System.out.println("Frase #" + (index + 1) + ": " + frases[index].toUpperCase());
        }
    }

    public static void mostrarPrimLetraMinus(String[] frases) {
        boolean primeraPalabra;
        int primeraLetra;
        StringBuffer aux;

        for (int i = 0; i < frases.length; ++i) {
            primeraPalabra = true;
            
            System.out.print("Frase #" + (i + 1) + ": ");
            for (String str : frases[i].split(" ")) {
                if (primeraPalabra) 
                    primeraPalabra = false;
                else
                    System.out.print(" ");

                primeraLetra = primeraLetra(str);
                if (primeraLetra != -1 && Character.isLetter(Character.toUpperCase(str.charAt(primeraLetra)))) {
                    aux = new StringBuffer(str);
                    aux.setCharAt(0, Character.toLowerCase(str.charAt(primeraLetra)));

                    System.out.print(aux);
                }
                else {
                    // en caso de no haber letras
                    // por ejemplo si tenemos una palabra o String como "3289"
                    // en ese caso no hay letras y no hay nada que convertir a minúsculas
                    System.out.print(str);
                }
                
            }

            System.out.print("\n");
        }
    }

    public static int primeraLetra(String palabra) {
        for (int i = 0; i < palabra.length(); ++i)
            if (Character.isLetter(palabra.charAt(i)))
                return i;

        return -1;
    }

    public static void mostrarNumVocCons(String[] frases) {
        int numeroVocales;
        int numeroConsonantes;
        for (int i = 0; i < frases.length; ++i) {
            // solución alternativa: retornar un array de dos posiciones que 
            // represente, por una parte, número de consonantes y por otra el número
            // de vocales
            numeroVocales = contarVocales(frases[i]);
            numeroConsonantes = contarConsonantes(frases[i]);

            System.out.printf("Frase #%d tiene [%d] vocales y [%d] consonantes.\n", i + 1, numeroVocales, numeroConsonantes);
        }
    }

    public static int contarVocales(String cadena) {
        int resultado = 0;
        for (int i = 0; i < cadena.length(); ++i) 
            if (Character.isLetter(cadena.charAt(i)) && esVocal(cadena.charAt(i)))
                ++resultado;

        return resultado;
    }

    public static int contarConsonantes(String cadena) {
        int resultado = 0;
        for (int i = 0; i < cadena.length(); ++i) 
            if (Character.isLetter(cadena.charAt(i)) && !esVocal(cadena.charAt(i)))
                ++resultado;

        return resultado;
    }

    public static boolean esVocal(char ch) {
        // se asume el caracter es alfabético (no es dígito)
        return switch(ch) {
            case 'a', 'i', 'u', 'e', 'o', 'A', 'I', 'U', 'E', 'O' -> true;
            default -> false;
        };
    }

    public static void mostrarContenidoMasLargo(String[] frases) {
        int masLargo = 0;
        
        for (int i = 0; i < frases.length; ++i)
            if (frases[i].length() > frases[masLargo].length())
                masLargo = i;

        System.out.println("Frase más larga: " + frases[masLargo]);
    }
}