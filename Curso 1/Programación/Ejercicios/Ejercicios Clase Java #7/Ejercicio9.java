import java.io.*;

public class Ejercicio9 {
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader lector = new BufferedReader(input);
    public static void main(String[] args) throws IOException {
        String[] telf = new String[2];
        int id;
        long digitos;

        do {
            System.out.print("Por favor introduce un teléfono fijo: ");
            telf = lector.readLine().trim().split("-");

            if (!controlPatron(telf))
                System.out.print("Teléfono fijo no válido, inténtalo de nuevo.");
            else {
                id = Integer.parseInt(telf[0]);
                digitos = Long.parseLong(telf[1]);

                System.out.println("Código de comunidad: " + id);
                System.out.println("Dígitos del número fijo: " + digitos);
                break;
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

    public static boolean controlPatron(String[] fijo) {
        boolean correcto = true;

        correcto = fijo[0].equals("91");
        correcto = correcto && fijo[1].length() == 7 && todoDigitos(fijo[1]);

        return correcto;
    }
}