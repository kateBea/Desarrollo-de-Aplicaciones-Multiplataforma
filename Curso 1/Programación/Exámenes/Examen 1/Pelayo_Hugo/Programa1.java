import java.io.*;

public class Programa1 {
    private static final char[] LETRAS = {'T', 'R', 'w', 'A', 'G', 'M',
                                            'Y', 'F', 'B', 'D', 'X', 'B', 'N',
                                            'J', 'Z', 'S', 'Q', 'V', 'H', 'L',
                                            'C', 'K', 'E', };

    public static void main(String[] args) throws IOException {
        String dni;
        char letra;

        do {
            // no hace falta tratamiento de errores sobre el DNI
            // será siempre una tira de dígitos

            dni = leerDni();
        }
        while(dni.length() != 8);

        letra = calcularLetra(dni);
        System.out.println("NIF: " + dni + "-" + letra);
    }

    public static String leerDni() throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader lector = new BufferedReader(input);
        String resultado;

        System.out.println("Introduzca un número de DNI: ");
        resultado = lector.readLine();

        return resultado;
    }

    public static char calcularLetra(String dni) {
        return LETRAS[Integer.parseInt(dni) % 23];
    }
}
