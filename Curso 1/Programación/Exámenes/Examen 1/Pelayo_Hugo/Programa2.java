import java.util.Scanner;

public class Programa2 {
    private static final Scanner lector = new Scanner(System.in);

    public static void main(String[] args) {
        String cadena;

            do {
            cadena = leerCadena();

            if (esPalindroma(cadena))
                System.out.println("La palabra SÍ es palindromo");
            else
                System.out.println("La palabra NO es palindromo");

            System.out.print("¿Continuar? (s/n): ");
            cadena = lector.nextLine();
        }
        while (cadena.charAt(0) == 'S' || cadena.charAt(0) == 's');

        lector.close();
    }

    public static String leerCadena() {
        System.out.print("Escribe la palabra: ");
        return lector.nextLine();
    }

    public static boolean esPalindroma(String cadena) {
        cadena = cadena.replace(" ", "").toLowerCase();

        for (int i = 0; i < cadena.length() / 2; ++i)
            if (cadena.charAt(i) != cadena.charAt(cadena.length() - 1 - i))
                return false;

        return true;
    }
}
