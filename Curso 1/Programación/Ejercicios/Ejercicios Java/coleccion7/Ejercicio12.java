package coleccion7;

/*
 * Este programa lee un entero de la entrada de datos, y crea un arreglo de de frases con el tamaño
 * indicado por el valor del entero leído. El entero debe estar en el rango [1, 11).
 * Sobre las frases usuario puede realizar las operaciones de: mostrar todo el contenido
 * de todas las frases, mostrar el contenido en minúsculas o mayúsculas, mostrar el
 * contenido de la primera letra de cada palabra en mayúsculas, mostrar el número de vocales y consonantes
 * de cada frase y mostrar el contenido más largo.
 *
 * NOTA: sobre intervalos. [x, y] -> x, y incluidos
 *                         [x, y) -> x, y-1 incluidos (y está excluido)
 *
 * @author Hugo
 * @version 1.0
 * @date 14 de enero de 2023
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;

public class Ejercicio12 {
    // para la lectura de datos por la entrada de datos
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader lector = new BufferedReader(input);

    public static void main(String[] args) throws IOException {
        gestor();
    }

    /*
     * Método para gestionar las frases que se leen por la entrada de datos.
     * Lee una serie finita de String por la entrada de datos y ofrece operaciones sobre ellas.
     *
     * @param None
     * @return void
     * @author Hugo
     */
    public static void gestor() throws IOException {
        String[] frases;
        int tamanioArray;

        // indica una operación a realizar sobre las frases
        int opcion;

        // inicializar el arreglo con las frases del usuario
        tamanioArray = leerEntero();
        frases = leerFrases(tamanioArray);

        do {
            mostrarMenu();

            // leemos la opción
            System.out.print("Elección: ");
            opcion = Integer.parseInt(lector.readLine());

            // asegurarse de que la opción está dentro de
            // los límites preestablecidos
            if (!(opcion > 0 && opcion < 8))
                System.out.println("Índice fuera de rango, intenta de nuevo.");
            else {
                switch (opcion) {
                    case 1 -> mostrarContenido(frases);
                    case 2 -> mostrarContenidoMinusc(frases);
                    case 3 -> mostrarContenidoMayus(frases);
                    case 4 -> mostrarPrimLetraMayus(frases);
                    case 5 -> mostrarNumVocCons(frases);
                    case 6 -> mostrarContenidoMasLargo(frases);
                }
            }
        }
        while (opcion != 7);
    }

    /*
     * Método que lee un entero de la entrada de datos. Se asegura que el entero
     * esté en el rango [0, 11).
     *
     * @param None
     * @return int el entero leído
     * @author Hugo
     */
    public static int leerEntero() throws IOException {
        System.out.print("Entre un número entre 1 y 10 (ambos inclusos): ");
        int resultado;

        // se itera mientras resultado no pertenezca a [1, 10]
        while (!((resultado = Integer.parseInt(lector.readLine())) > - 1 && resultado < 11))
            System.out.print("Por favor, introduzca un número en el intervalo [1, 11): ");

        return resultado;
    }

    /*
     * Este método lee una serie de Sting por la entrada de datos
     * y los retorna en forma de arreglo. Los String no pueden estar vacíos.
     *
     * @param limite índica el número total de cadenas a leer
     * @return String[] el arreglo conteniendo las cadenas leídas
     * @author Hugo
     */
    public static String[] leerFrases(int limite) throws IOException {
        String[] result = new String[limite];
        for (int i = 0; i < limite; ++i) {
            System.out.println("Introduzca frase #" + (i + 1) + ":");
            result[i] = leerCadena();
        }

        return result;
    }

    /*
     * Método que lee un String de la entrada de datos. Se asegura de
     * que el String no esté vació.
     *
     * @param None
     * @return String la cadena leída
     * @author Hugo
     */
    public static String leerCadena() throws IOException {
        String resultado;

        // intentar leer otra vez la cadena si está vacía
        // NOTA: se considera vacía si solo tiene espacios o sólo saltos de línea
        while ((resultado = lector.readLine().trim()).length() == 0)
            System.out.print("La frase está vacía, inténtelo de nuevo: ");

        return resultado;
    }

    /*
     * Función que muestra por la entrada las funcionalidades principales
     * del programa a través de un menú formateado por pantalla.
     *
     * @param None
     * @return void
     * @author Hugo
     */
    public static void mostrarMenu() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("1. Mostrar contenido del vector.");
        System.out.println("2. Mostrar todo el contenido en minúsculas.");
        System.out.println("3. Mostrar todo el contenido en mayúsculas.");
        System.out.println("4. Mostrar el contenido con la primera letra de cada palabra en mayúsculas.");
        System.out.println("5. Mostrar el número de vocales y de consonantes de cada texto en cada posición.");
        System.out.println("6. Mostrar el contenido más largo.");
        System.out.println("7. Salir");
        System.out.println("--------------------------------------------------------------------------------");
    }

    /*
     * Muestra por la salida de datos los String de un arreglo de cadenas.
     *
     * @param frases el arreglo conteniendo las cadenas
     * @return void
     * @author Hugo
     */
    public static void mostrarContenido(String[] frases) {
        for (int index = 0; index < frases.length; ++index) {
            System.out.println("Frase #" + (index + 1) + ": " + frases[index]);
        }
    }

    /*
     * Muestra por la salida de datos los String de un arreglo de cadenas,
     * con todas las letras en minúsculas.
     *
     * @param frases el arreglo conteniendo las cadenas
     * @return void
     * @author Hugo
     */
    public static void mostrarContenidoMinusc(String[] frases) {
        for (int index = 0; index < frases.length; ++index) {
            System.out.println("Frase #" + (index + 1) + ": " + frases[index].toLowerCase());
        }
    }

    /*
     * Muestra por la salida de datos los String de un arreglo de cadenas,
     * con todas las letras en mayúsculas.
     *
     * @param frases el arreglo conteniendo las cadenas
     * @return void
     * @author Hugo
     */
    public static void mostrarContenidoMayus(String[] frases) {
        for (int index = 0; index < frases.length; ++index) {
            System.out.println("Frase #" + (index + 1) + ": " + frases[index].toUpperCase());
        }
    }

    /*
     * Muestra por la salida de datos los String de un arreglo de cadenas,
     * con solo las primeras de todas las palabras en minúsculas
     *
     * @param frases el arreglo conteniendo las cadenas
     * @return void
     * @author Hugo
     */
    public static void mostrarPrimLetraMayus(String[] frases) {
        // indica que no hay que poner un espacio
        // al principio de cada frase
        boolean primeraPalabra;

        // índice que contiene la primera letra de cada palabra
        // importante en casos como cuando una palabra no empieza por
        // letra (e.g.: por dígito), como 1M (1 de marzo)
        int primeraLetra;

        // se utiliza para reconstruir las palabras de cada
        // una de las cadenas del arreglo de String, ya que las cadenas
        // de la clase String son inmutables
        StringBuffer aux;

        for (int i = 0; i < frases.length; ++i) {
            primeraPalabra = true;

            System.out.print("Frase #" + (i + 1) + ": ");
            for (String str : frases[i].split(" ")) {
                // sirve para no poner un espacio al principio de cada cadena
                if (primeraPalabra)
                    primeraPalabra = false;
                else
                    System.out.print(" ");

                // obtener el índice del primer carácter
                // alfabético de la palabra
                primeraLetra = primeraLetra(str);

                if (primeraLetra != -1) {
                    aux = new StringBuffer(str);

                    // se pone el primer carácter alfabético en mayúsculas
                    aux.setCharAt(primeraLetra, Character.toUpperCase(str.charAt(primeraLetra)));

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

    /*
     * Retorna el índice al primer carácter alfabético de una palabra
     *
     * @param palabra representa la palabra a ser evaluada
     * @return int el índice donde se encuentra el primer carácter alfabético, -1 si no hay
     * @author Hugo
     */
    public static int primeraLetra(String palabra) {
        for (int i = 0; i < palabra.length(); ++i)
            if (Character.isAlphabetic(palabra.charAt(i)))
                return i;

        return -1;
    }

    /*
     * Muestra por pantalla el número de vocales y consonantes de cada una de
     * las cadenas contenidas en un arreglo de cadenas
     *
     * @param frases arreglo conteniendo las cadenas
     * @return void
     * @author Hugo
     */
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

    /*
     * Cuenta el número de vocales de un String
     *
     * @param cadena el String del cual cuenta el número de vocales
     * @return int el número total de vocales
     * @author Hugo
     */
    public static int contarVocales(String cadena) {
        int resultado = 0;
        for (int i = 0; i < cadena.length(); ++i)
            if (Character.isLetter(cadena.charAt(i)) && esVocal(cadena.charAt(i)))
                ++resultado;

        return resultado;
    }

    /*
     * Cuenta el número de consonantes de un String
     *
     * @param cadena el String del cual cuenta el número de vocales
     * @return int el número total de vocales
     * @author Hugo
     */
    public static int contarConsonantes(String cadena) {
        int resultado = 0;
        for (int i = 0; i < cadena.length(); ++i)
            if (Character.isLetter(cadena.charAt(i)) && !esVocal(cadena.charAt(i)))
                ++resultado;

        return resultado;
    }

    /*
     * Retorna cierto si el carácter es una vocal, retorna
     * falso en caso contrario.
     *
     * @param ch el carácter a ser evaluado
     * @return boolean cierto si ch es vocal, falso en caso contrario
     * @author Hugo
     */
    public static boolean esVocal(char ch) {
        // se asume el caracter es alfabético (no es dígito)
        return switch(ch) {
            case 'a', 'i', 'u', 'e', 'o', 'A', 'I', 'U', 'E', 'O' -> true;
            default -> false;
        };
    }

    /*
     * Muestra por pantalla la cadena más larga de un arreglo de String
     *
     * @param frases el arreglo conteniendo las cadenas
     * @return void
     * @author Hugo
     */
    public static void mostrarContenidoMasLargo(String[] frases) {
        int masLargo = 0;

        for (int i = 0; i < frases.length; ++i)
            if (frases[i].length() > frases[masLargo].length())
                masLargo = i;

        System.out.println("Frase más larga: " + frases[masLargo]);
    }
}