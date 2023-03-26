package string_arrays;

/*
 * Título: Password
 * Algoritmo: Programa que valida una cadena como contraseña
 * Autor: Hugo Pelayo:
 * Fecha: 23.11.2022
 */

// NOTA: Más info sobre manipulación de cadenas
// https://docs.oracle.com/javase/7/docs/api/java/lang/String.html

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class EjerFortaleza {
    private static final InputStreamReader inputStream = new InputStreamReader(System.in);
    private static final BufferedReader reader = new BufferedReader(inputStream);
    public static void main(String[] args) throws IOException {
        final int PASSWORD_MINIMUM_LENGHT = 8;
        boolean isValiPassword = false;
        String password = new String("");

        do {
            System.out.print("Introduzca la contraseña por favor: ");
            password = reader.readLine();

            if (password.contains(" ")) {
                System.out.println("La contraseña no puede contener espacios.");
                System.out.println("Por favor, inténtelo de nuevo.");
            }
            else if (password.length() < PASSWORD_MINIMUM_LENGHT) {
                System.out.println("La contraseña requiere un mínimo de [" + PASSWORD_MINIMUM_LENGHT + "] caracteres.");
                System.out.println("Por favor, inténtelo de nuevo.");
            }

            isValiPassword = validatePass(password);
        }
        while (password.length() < PASSWORD_MINIMUM_LENGHT || password.contains(" ") || !isValiPassword);

        System.out.println("Programa terminando...");
    }

    public static boolean match(char ch) {
        return switch (ch) {
            case 'À', 'Á', 'Ä', 'Â',
                    'É', 'È', 'Ë', 'Ê',
                    'Í', 'Ì', 'Ï', 'Î',
                    'Ó', 'Ò', 'Ö', 'Ô',
                    'Ú', 'Ù', 'Ü', 'Û',
                    'á', 'à', 'ä', 'â',
                    'é', 'è', 'ë', 'ê',
                    'í', 'ì', 'ï', 'î',
                    'ó', 'ò', 'ö', 'ô',
                    'ú', 'ù', 'ü', 'û' -> true;
            default -> false;
        };
    }

    public static boolean validatePass(String pass) {

        // [0] -> Cierto si el string contiene al menos una mayúscula
        // [1] -> Cierto si el string contiene al menos una minúscula
        // [2] -> Cierto si el string contiene al menos un dígito
        // [3] -> Cierto si el string uno de los caracteres: *, +, -, _, #, $, %, &
        // [4] -> Cierto si el string contiene caracteres con tildes o dieresis
        boolean[] checks = new boolean[5];
        int index;
        int codePt;

        index = 0;
        while (index < pass.length() && !checks[4]){
            codePt = pass.codePointAt(index);
            // Contiene acentos
            if (match(pass.charAt(index)))
                checks[4] = true;
            // Hay al menos una mayúscula
            else if (codePt >= "A".codePointAt(0) && codePt <= "Z".codePointAt(0))
                checks[0] = true;

                // Hay al menos una minúscula
            else if (codePt >= "a".codePointAt(0) && codePt <= "z".codePointAt(0))
                checks[1] = true;

                // Hay almenos un dígito
            else if (Character.isDigit(pass.charAt(index)))
                checks[2] = true;

                // Contiene *, +, -, _, #, $, %, &
            else if (pass.contains("*") || pass.contains("+") || pass.contains("-") || pass.contains("_") ||
                    pass.contains("#") || pass.contains("$") || pass.contains("%") || pass.contains("&")) {
                   checks[3] = true;
            }
            
            ++index;
        }

        // El string contiene tildes
        if (checks[4])
            return false;

        for (index = 0; index < checks.length - 1; ++index) {
            if (!checks[index])
                return false;
        }

        return true;
    }
}