/*
 * Título: Password
 * Algoritmo: Programa que valida una cadena como contraseña
 * Autor: Hugo Pelayo:
 * Fecha: 23.11.2022
 */

// NOTA: Más info sobre manipulación de cadenas
// https://docs.oracle.com/javase/7/docs/api/java/lang/String.html

import java.io.*;
import java.util.regex.Pattern;

public class Password {
    public static void main(String[] args) throws IOException {
        InputStreamReader inputStream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStream);
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
        while (password.length() < PASSWORD_MINIMUM_LENGHT || password.contains(" ") && !isValiPassword);

        System.out.println("Programa terminando...");
    }

    public static boolean validatePass(String pass) {
        // [0] -> Cierto si el string contiene al menos una mayúscula
        // [1] -> Cierto si el string contiene al menos una minúscula
        // [2] -> Cierto si el string contiene al menos un dígito
        // [3] -> Cierto si el string uno de los caracteres: *, +, -, _, #, $, %, &
        // [4] -> Cierto si el string contiene caracteres con tildes o dieresis
        boolean[] checks = new boolean[5];
        int codePt;


        for(int index = 0; index < pass.length(); ++index){
            codePt = pass.codePointAt(index);
            // Hay al menos una mayúscula
            if (codePt >= "A".codePointAt(0) && codePt <= "Z".codePointAt(0))
                checks[0] = true;
            // Hay al menos una minúscula
            if (codePt >= "a".codePointAt(0) && codePt <= "z".codePointAt(0))
                checks[1] = true;
            // Hay almenos un dígito
            if (Character.isDigit(pass.charAt(index)))
                checks[2] = true;

            // Contiene *, +, -, _, #, $, %, &
            if (pass.contains("*") || pass.contains("+") || pass.contains("-") || pass.contains("_") ||
                pass.contains("#") || pass.contains("$") || pass.contains("%") || pass.contains("&")) {
                checks[3] = true;
            }

            // Contiene acentos
            if (Pattern.matches(".*[ÀÁÄÂÉÈËÊÍÌÏÎÓÒÖÔÚÙÜÛáàäâéèëêíìïîóòöôúùüû].*", pass))
                checks[4] = true;
        }

        for (boolean valor : checks) {
            if (!valor)
                return false;
        }

        return true;
    }
}