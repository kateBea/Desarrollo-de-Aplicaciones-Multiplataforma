package poo.quiniela;

import java.io.InputStreamReader;
import java.util.Random;
import java.io.BufferedReader;
import java.io.IOException;



public class Quiniela {
    // para la lectura de datos de la entrada estándar
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader reader = new BufferedReader(input);

    // para generar indices aleatorios
    private static final Random rand = new Random();

    private String[] partido;
    private char[] apuesta;
    private final int NUMERO_PARTIDOS = 15;

    // atributo interno auxiliar que indicará si se han leído
    // ya los partidos
    private boolean partidosLeidos;
    // atributo interno auxiliar que indicará si se han leído
    // ya las apuestas
    private boolean apuestasLeidas;

    private static boolean apuestaValida(char apuesta) {
        return switch(apuesta) {
            case '1', 'X', '2' -> true;
            default -> false;
        };
    }

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
            if (!(acabar = apuestaValida(resultado)))
                System.out.println("Apuesta inválida, intente de nuevo.");

        }
        while (!acabar);

        return resultado;
    }

    public Quiniela() {
        partido = new String[NUMERO_PARTIDOS];
        apuesta = new char[NUMERO_PARTIDOS];

        partidosLeidos = false;
        apuestasLeidas = false;
    }

    public Quiniela(String[] partidos, char[] apuestas) {
        this.partido = partidos;
        this.apuesta = apuestas;

        partidosLeidos = false;
        apuestasLeidas = false;
    }

    public String[] getPartido() {
        return partido;
    }

    public void setPartido(String[] partido) {
        this.partido = partido;
    }

    public char[] getApuesta() {
        return apuesta;
    }

    public void setApuesta(char[] apuesta) {
        this.apuesta = apuesta;
    }

    public void pedirPartidos() {
        // se tiene que leer NUMERO_PARTIDOS cada 
        // vez que llamamos esta funcion
        String userInput;
        int indice = 0;

        try {
            do {
                System.out.print("Introduzca partido. El formato es: Equipo1 - Equipo2: ");

                userInput = reader.readLine();
                
                if (userInput.split("-").length == 2) 
                    this.partido[indice++] = userInput;
                else {
                    System.out.println("Formato de equipo inválido...");
                }
            }
            while (indice < NUMERO_PARTIDOS);

            partidosLeidos = true;
        }
        catch (IOException ioe) {
            System.out.println("No se leyeron todos las partidos correctamente");
            System.out.println(ioe.getMessage());
        }
    }

    public void mostrarPartidos() {
        if (partidosLeidos) {
            int indice = 1;
            for (String partido : this.partido) {
                String[] temp = partido.split("-");
                System.out.printf("Partido #%d: %s vs %s\n", indice++, temp[0].trim(), temp[1].trim());
            }
        }
        else
            System.out.println("No hay partidos válidos para mostrar");
    }

    public void pedirApuestas() {
        char[] inputApuestas;
        int indice = 0;
        if (partidosLeidos) {
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

    public void mostrarApuestasyPartidos() {
        if (!partidosLeidos) {
            System.out.println("No hay partidos válidos que mostrar");
            return;
        }

        if (!apuestasLeidas) {
            System.out.println("No hay apuestas válidas que mostrar");
            return;
        }

        for (int indice = 0; indice < NUMERO_PARTIDOS; ++indice) {
            System.out.printf(
                "Partido #%d [%s vs %s]. Apuesta: %c\n", 
                indice + 1, 
                partido[indice].split("-")[0].trim(), 
                partido[indice].split("-")[0].trim(), 
                apuesta[indice]
            );
        }
    }

    public void generarApuestasAleatorias() {
        char[] posibilidades = { '1', '2', 'X' };

        if (partidosLeidos) {
            for (int index = 0; index < apuesta.length; ++index)
                apuesta[index] = posibilidades[rand.nextInt(posibilidades.length)];
        }
        else 
            System.out.println("Debe leer partidos primero");

    }

    public void copiarPartidos(Quiniela other) {
        if (other.partidosLeidos) {
            int indice = 0;
            for (String partido : other.getPartido())
                this.partido[indice++] = new String(partido);
        }
    }

    public void copiarPartidos(String[] partidos) {
        int indice = 0;
        for (String partido : partidos)
            this.partido[indice++] = new String(partido);
    }

    public void copiarApuestas(Quiniela other) {
        if (other.apuestasLeidas) {
            int indice = 0;
            for (char ch : other.getApuesta()) 
                this.apuesta[indice++] = ch;
        }
    }

    public void copiarApuestas(char[] apuestas) {
        if (apuestas.length != NUMERO_PARTIDOS) {
            int indice = 0;
            for (char ch : apuestas) 
                this.apuesta[indice++] = ch;
        }
    }

    public int comprobrarApuestas(Quiniela other) {
        int acumulador = 0;
        if (this.apuestasLeidas && other.apuestasLeidas) {
            for (int indice = 0; indice < NUMERO_PARTIDOS; ++indice)
                acumulador += (this.apuesta[indice] == other.apuesta[indice]) ? 1 : 0;
        }

        return acumulador;
    }

}
