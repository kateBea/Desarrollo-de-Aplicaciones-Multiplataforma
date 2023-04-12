package poo.quiniela;

import java.io.InputStreamReader;
import java.util.Random;
import java.io.BufferedReader;
import java.io.IOException;


/**
 * Representa una Quiniela
 * @author Hugo Pelayo
 * @version 1.0
 */
public class Quiniela {
    // Para la lectura de datos de la entrada estándar
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader reader = new BufferedReader(input);

    // Para generar indices aleatorios
    private static final Random rand = new Random();

    // Contiene los partidos de esta Quiniela
    private String[] partido;
    // Contiene las apuestas de esta Quiniela
    private char[] apuesta;
    // Indicador del número máximo de partidos y apuestas por Quiniela 
    private static final int NUMERO_PARTIDOS = 2;

    // Atributo interno auxiliar que indicará si se han leído ya los partidos
    private boolean partidosLeidos;

    // Atributo interno auxiliar que indicará si se han leído ya las apuestas
    private boolean apuestasLeidas;

    /*
     * Indica si una apuesta es válida en cuyo caso retorna cierto,
     * en caso contrario retorna falso
     */
    private static boolean apuestaValida(char apuesta) {
        return switch(apuesta) {
            case '1', 'X', '2' -> true;
            default -> false;
        };
    }

    /*
     * Retorna cierto si un partido es válido
     * El formato de cadena válido para un partido es
     * "Equipo1 - Equipo2" o "Equipo1 vs Equipo2"
     */
    private static boolean esPartidoValido(String partido) {
        return partido.split("-").length == 2 ||
        partido.split("vs").length == 2;
    }

    /*
     * Retorna cierto si esta Quiniela partidos leídos,
     * retorna falso en caso contrario
     */
    private boolean tienePartidosLeidos() {
        return partidosLeidos;
    }

    /*
     * Retorna cierto si esta Quiniela tiene apuestas leídas,
     * retorna falso en caso contrario
     */
    private boolean tieneApuestasLeidas() {
        return apuestasLeidas;
    }

    /*
     * Lee una apuesta de la entrada de datos y la valida
     */
    private static char leerApuesta() {
        String temp = "";
        boolean acabar = false;
        char resultado = 'X';

        do {
            try {
                System.out.print("Por favor introduzca un único carácter [1, 2, X]: ");
                temp = reader.readLine();
                
                // asegurar usuario introduce un único carácter
                if (temp.length() != 1)
                    continue;
                else 
                    resultado = temp.charAt(0);
            } 
            catch (IOException e) {
                System.out.println("Cadena inválida");
            }

            // si el carácter de apuesta es válido acabamos
            // si no seguimos solicitando apuesta
            if (!(acabar = apuestaValida(resultado)))
                System.out.println("Apuesta inválida, intente de nuevo.");

        }
        while (!acabar);

        return resultado;
    }

    /**
     * Inicializa esta Quiniela por defecto 
     */
    public Quiniela() {
        partido = new String[NUMERO_PARTIDOS];
        apuesta = new char[NUMERO_PARTIDOS];

        partidosLeidos = false;
        apuestasLeidas = false;
    }

    /**
     * Inicializa esta Quiniela con los partidos y apuesrtas 
     * que se pasan como parámetros
     * @param partidos Partidos para esta Quiniela
     * @param apuestas Apuestas para esta Quiniela
     */
    public Quiniela(String[] partidos, char[] apuestas) {
        this.partido = partidos;
        this.apuesta = apuestas;

        partidosLeidos = false;
        apuestasLeidas = false;
    }

    /**
     * Retorna los partidos de esta Quiniela
     * @return Partidos de esta Quiniela
     */
    public String[] getPartido() {
        return partido;
    }

    /**
     * Cambia la lista de partidos de esta Quiniela por
     * la que se pasa como parámetro. Si la referencia es nula
     * esta función no tiene efecto
     * @param partido Nueva lista de partidos de esta Quiniela
     */
    public void setPartido(String[] partido) {
        if (partido != null)
            this.partido = partido;
        else 
            System.out.println("Error: referencia nula setPartido()...");
    }

    /**
     * Retorna la lista de apuestas de esta Quiniela
     * @return Lista de apuestas de esta Quiniela
     */
    public char[] getApuesta() {
        return apuesta;
    }

    /**
     * Cambia la lista de apuestas de esta Quiniela por
     * la que se pasa como parámetro. Si la referencia es nula
     * esta función no tiene efecto
     * @param apuesta Nueva lista de apuestas de esta Quiniela
     */
    public void setApuesta(char[] apuesta) {
        if (apuesta != null)
            this.apuesta = apuesta;
        else 
            System.out.println("Error: referencia nula setApuesta()...");
    }

    /**
     * Pide por la entrada de datos una lista fija de partidos. Si hay algún 
     * error al leer los partidos, se invalidan los partidos de esta Quiniela si ya tenía.
     * Es necesario volver a leer todos los partidos correctamente para
     * poder realizar el resto de operaciones posibles sobre la lista de partidos
     */
    public void pedirPartidos() {
        // se tiene que leer NUMERO_PARTIDOS cada 
        // vez que llamamos esta funcion
        String userInput;
        int indice;

        System.out.println("Total de partidos a leer: " + NUMERO_PARTIDOS + '\n');
        try {
            indice = 0;
            do {
                System.out.print("Introduzca partido. El formato es: 'Equipo1 - Equipo2' o 'Equipo1 vs Equipo2': ");
                userInput = reader.readLine();
                
                if (esPartidoValido(userInput)) 
                    this.partido[indice++] = userInput;
                else {
                    System.out.println("Formato de equipo inválido...");
                }
            }
            while (indice < NUMERO_PARTIDOS);

            partidosLeidos = true;
        }
        catch (IOException ioe) {
            System.out.println("Error: No se leyeron todos las partidos correctamente");
            System.out.println(ioe.getMessage());
            partidosLeidos = false;
        }
    }

    /**
     * Muestra los partidos de esta Quiniela
     */
    public void mostrarPartidos() {
        int indice;

        if (tienePartidosLeidos()) {
            indice = 1;
            for (String partido : this.partido) {
                String[] temp;
                
                if (partido.contains("-"))
                    temp = partido.split("-");
                else 
                    temp = partido.split("vs");

                System.out.printf("Partido #%d: %s vs %s\n", indice++, temp[0].trim(), temp[1].trim());
            }
        }
        else
            System.out.println("No hay partidos válidos para mostrar");
    }

    /**
     * Pide por la entrada de datos una apuesta por cada partido. Para llamar a esta función
     * es necesario tener una lista de partidos válida, si una llamada a pedirPartidos()
     * no se ha completado de manera satisfactoria, esta función no tiene efecto hasta 
     * que se haya leído y válidado una lista de partidos
     */
    public void pedirApuestas() {
        char[] inputApuestas;
        int indice;

        if (tienePartidosLeidos()) {
            indice = 0;
            inputApuestas = new char[NUMERO_PARTIDOS];
            for (String item : this.partido) {
                System.out.println("Apuesta para partido [" + item + "]: ");
                inputApuestas[indice++] = leerApuesta();
            }
            
            apuesta = inputApuestas;
            apuestasLeidas = true;
        }   
        else
            System.out.println("Debe leer partidos primero");
    }

    /**
     * Muestra para cada partido sus apuestas
     */
    public void mostrarApuestasyPartidos() {
        if (!tienePartidosLeidos()) {
            System.out.println("No hay partidos válidos que mostrar");
            return;
        }

        if (!tieneApuestasLeidas()) {
            System.out.println("No hay apuestas válidas que mostrar");
            return;
        }

        for (int indice = 0; indice < NUMERO_PARTIDOS; ++indice) {
            System.out.printf(
                "Partido #%d [%s vs %s]. Apuesta: %c\n", 
                indice + 1, 
                partido[indice].split(partido[indice].contains("-") ? "-" : "vs")[0].trim(), 
                partido[indice].split(partido[indice].contains("-") ? "-" : "vs")[1].trim(), 
                apuesta[indice]
            );
        }
    }

    /**
     * Genera una lista de apuestas con una apuesta leatoria para 
     * cada partido válido. Es necesario tener una lista de partidos válidos, esto es,
     * que la última llamada a pedirPartidos() se haya completado satisfactoriamente
     */
    public void generarApuestasAleatorias() {
        char[] posibilidades = { '1', '2', 'X' };

        if (tienePartidosLeidos()) {
            for (int index = 0; index < apuesta.length; ++index)
                apuesta[index] = posibilidades[rand.nextInt(posibilidades.length)];
        }
        else 
            System.out.println("Debe leer partidos primero");

        apuestasLeidas = true;
    }

    /**
     * Copia los partidos de la Quiniela que se pasa como
     * parámetro a esta, si la referencia es nula esta función no tiene efecto
     * efecto
     * @param other Quiniela de la cual esta copia los partidos
     */
    public void copiarPartidos(Quiniela other) {
        if (other.tienePartidosLeidos() && other != null) {
            copiarPartidos(other.getPartido());
        }
    }

    /**
     * Copia los partidos que se pasan como parámetro a esta Quiniela, 
     * si la referencia es nula esta función no tiene efecto
     * efecto. Se asume que la lista de partidos está inicializada y es válida
     * @param partidos Nueva lista de partidos de esta Quiniela
     */
    public void copiarPartidos(String[] partidos) {
        if (partidos.length >= getMaxApuestasPartidos()) {
            int indice = 0;
            for (String partido : partidos)
                this.partido[indice++] = new String(partido);
        }
        else
            System.out.println("La cantidad de partidos es inferior al valor establecido...");
    }

    /**
     * Copia las apuestas de la Quiniela que se pasa como
     * parámetro a esta, si la referencia es nula esta función no tiene efecto
     * efecto
     * @param other Quiniela de la cual esta copia las apuestas
     */
    public void copiarApuestas(Quiniela other) {
        if (other.tieneApuestasLeidas()) {
            copiarApuestas(other.getApuesta());
        }
    }

    /**
     * Copia las apuestas que se pasan como parámetro a esta Quiniela, 
     * si la referencia es nula esta función no tiene efecto
     * efecto. Se asume que la lista de apuestas está inicializada y es válida
     * @param apuestas Nueva lista de apuestas de esta Quiniela
     */
    public void copiarApuestas(char[] apuestas) {
        if (apuestas.length >= getMaxApuestasPartidos()) {
            int indice = 0;
            for (char ch : apuestas) 
                this.apuesta[indice++] = ch;
        }
        else
            System.out.println("La cantidad de apuestas es inferior al valor establecido...");
    }

    /**
     * Retorna el número de apuestas por cada partido que coinciden
     * entre esta Quiniela y la que se pasa como parámetro
     * @param other Quiniela con la que se compara esta
     * @return Número de apuestas por partido iguales
     */
    public int comprobrarApuestas(Quiniela other) {
        int acumulador = 0;
        if (this.tieneApuestasLeidas() && other.tieneApuestasLeidas()) {
            for (int indice = 0; indice < getMaxApuestasPartidos(); ++indice)
                acumulador += (this.apuesta[indice] == other.apuesta[indice]) ? 1 : 0;
        }

        return acumulador;
    }

    /**
     * Retorna el número máximo de parejas de apuestas y partidos
     * @return Máximo número de apuestas y partidos
     */
    public static int getMaxApuestasPartidos() {
        return NUMERO_PARTIDOS;
    }

}
