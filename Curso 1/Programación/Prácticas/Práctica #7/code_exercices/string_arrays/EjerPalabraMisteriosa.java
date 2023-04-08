package string_arrays;

/*
 * Título: Palabra misteriosa
 * Algoritmo: Descubrir palabra misteriosa
 * Fecha: 26.03.2023
 * Autor: Hugo Pelayo
 */

// NOTAS SOBRE BUGS:
// Al acertar una de las letras ocultas Si se vuelve a introducir la letra 
// adivinada (en el caso de aparecer una vez) cuenta como un error de 
// adivinanza y te consume una parte

import java.util.Random;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class EjerPalabraMisteriosa  {
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader lector = new BufferedReader(input);

    public enum GameState {
        RUNNING,    // Iniciar una sesión el juego
        STOPPED,    // Acabar una sesión del juego
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        // declaración de variables
        int         eleUsuario;
        Random      randObject;
        GameState   estado;
        String[]    juegoPalabras = {

                "almendra", "cataclismo", "hibernar", "aniquilar",
                "torbellino", "memoria", "unidad", "controlador",
                "terremoto", "reluciente", "aleatorio", "personaje",
                "anime", "caracteres", "lectura", "problema",
        };

        // Setup del bucle principal del juego
        randObject  = new Random();
        estado      = GameState.RUNNING;

        // bucle principal
        do {
            System.out.println("Para continuar selecciona una de las siguientes opciones:");
            System.out.println("[1]. Dejar de jugar.");
            System.out.println("[2]. Empezar una nueva sesión de juego.");

            System.out.print("\nElección: ");
            eleUsuario = Integer.parseInt(lector.readLine());

            switch (eleUsuario) {
                case 1 -> estado = GameState.STOPPED;
                case 2 -> estado = GameState.RUNNING;
                default -> {
                    System.out.println("Índice inválido...");
                }
            }

            // Salto de línea para formatear salida
            System.out.println();

            if (estado == GameState.RUNNING) {
                // empieza una nueva sesión de juego con una
                // palabra aleatoria del juego de palabras
                playGame(juegoPalabras[randObject.nextInt(0, juegoPalabras.length)]);
            }
        }
        while(estado == GameState.RUNNING);

        System.out.println("Finalizando juego...");
    }

    // Función que ejecuta una sesión de juego
    public static void playGame(String palabraEscogida) throws InterruptedException, IOException {
        char[]  resultado;                  // - Array que gestiona las letras adivinadas
                                            // y no adivinadas por el usuario hasta el momento
        char[]  partes;                     // - Representación de las partes sacrificables del usuario
        char    letra;                      // - Carácter que se lee del usuario
        boolean descubierto;                // - Flag que indica si el usuario ha acertado todas las letras
        int     letrasAdivinadas;           // - Contador que indica el número de letras adivinadas actualmente
        int     indice;                     // - Variable temporal que guarda el índice al array resultado del carácter que ha entrado el usuario
        int     contadorPartesRestantes;    // - Contador que indica cuantas partes más puede sacrificar el usuario en caso de fallo

        // Setup del bucle del juego
        partes                  = new char[]{ 'º', '>', '<', '|', '\\', '/' };
        contadorPartesRestantes = partes.length;
        resultado               = palabraEscogida.toCharArray();
        descubierto             = false;
        letrasAdivinadas        = 0;

        cuentaAtras();

        // Salto de línea para formatear salida
        System.out.println();

        do {
            // Pintamos el estado actual de las letras que estamos adivinando
            System.out.print("Estado actual de letras: ");

            for (int index = 0; index < palabraEscogida.length(); ++index) {
                // las letras acertadas estarán marcadas con un '*'
                // las que no lo están son las que todavía se debe adivinar y
                // por ello se imprimen en pantalla con un guion bajo
                if (resultado[index] != '*')
                    System.out.print("_ ");
                else
                    System.out.print(palabraEscogida.charAt(index) + " ");
            }


            System.out.print("\nIntroduce una letra: ");
            letra = lector.readLine().charAt(0);
            indice = busquedaLineal(resultado, letra);

            if (indice == -1) {
                contadorPartesRestantes--;
                System.out.print("Partes consumidas: ");
                for (int index = partes.length - 1; index >= contadorPartesRestantes; --index)
                    System.out.print("[" + partes[index] + "] ");

                System.out.println();
            }
            else {
                ++letrasAdivinadas;

                // palabra descubierta si hemos encontrado todas las letras
                descubierto = letrasAdivinadas == palabraEscogida.length();

                // marcamos la letra para que no se vuelva a buscar
                resultado[indice] = '*';
            }


        }
        while (contadorPartesRestantes > 0 && !descubierto);

        if (descubierto)
            System.out.println("¡Felicidades! Has descubierto la palabra secreta (:");
        else
            System.out.println("Has fracasado... ):");

        System.out.println("La palabra era: " + palabraEscogida);
    }

    // Función que busca una letra en un array de caracteres
    // devuelve el índice donde se encuentra en caso de existir,
    // devuelve -1 en caso contrario (devuelve el índice de la primera aparición)
    public static int busquedaLineal(char[] letras, char target) {
        for (int index = 0; index < letras.length; ++index) {
            if (letras[index] == target) {
                return index;
            }
        }
        return -1;
    }

    // Función que inicia una cuenta atrás de tres segundos
    public static void cuentaAtras() throws InterruptedException {
        final long sleepTime = 1000;

        // cuenta atrás
        for (int i = 0; i < 3; ++i) {
            switch (i) {
                case 0 -> {
                    System.out.println("!Preparado...¡");
                    Thread.sleep(sleepTime);
                }
                case 1 -> {
                    System.out.println("!Listo...¡");
                    Thread.sleep(sleepTime);
                }
                case 2 -> System.out.println("!Empecemos...¡");
            }
        }
    }
}
