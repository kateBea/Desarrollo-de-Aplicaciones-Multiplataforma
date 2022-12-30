import java.io.*;

public class Ejercicio9 {
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader lector = new BufferedReader(input);
    public static void main(String[] args) throws IOException {
        String[] telf = new String[2];

        do {
            System.out.print("Por favor introduce un teléfono fijo: ");
            telf = lector.readLine().split("-");

            if (!controlPatron(telf))
                System.out.print("Teléfono fijo no válido, inténtalo de nuevo.");
            else {
                
            }
        }
        while (true);
    }

    public static boolean todoDigitos(String num) {
        for (int i = 0; i < num.length(); ++i)
            if (!Character.isDigit(num.charAt(i)))
                return false;

        return true;
    }
}