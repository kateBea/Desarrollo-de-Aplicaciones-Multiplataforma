/* 
 * Este programa recibe un número fijo por la línea de comandos y extrae el código de comunidad
 * y el resto de dígitos, guarda el código de comunidad en un entero estándard y el resto de dígitos 
 * en un entero de tipo long. Muestra ambos datos por pantalla.
 * 
 * @author Hugo
 * @version 1.0
 * @date 14 de enero de 2023
 */

import java.io.*;

public class Ejercicio9 {
    public static void main(String[] args) throws IOException {
        int id;
        long digitos;

        // guardará el código de comunidad junto con los otrso dígitos
        String[] telf;

        // control de datos de línea de comandos
        if (args.length == 0) {
            uso();
            return;
        }

        telf = args[0].trim().split("-");

        if (!controlPatron(telf))
            System.out.print("Teléfono fijo no válido, inténtalo de nuevo.");
        else {
            // conversión de datos
            id = Integer.parseInt(telf[0]);
            digitos = Long.parseLong(telf[1]);
            
            // mostrar valores por la salida de datos
            System.out.println("Código de comunidad: " + id);
            System.out.println("Dígitos del número fijo: " + digitos);
        }

    }

    /*
     * Este método muestra el uso apropiado del programa de un mensaje
     * por pantalla del uso apropiado del programa.
     * 
     * @param None
     * @return void
     * @author Hugo
     */
    public static void uso() {
        System.out.println("Programa requiere de solo un agrumento.");
        System.out.println("Ejemplo: java Ejercicio9.java '91-8885566'");
    }

    /*
     * Este método retorna cierto si el String representa una cadena formada por
     * sólo dígitos, retorn afalso en caso contrario. Se asume que los caracteres 
     * son contiguos y no se separan por espacios ny saltos de línea.
     * 
     * @param num la cadena a ser evaluada
     * @return boolean cierto si el String contiene sólo dígitos
     * @author Hugo
     */
    public static boolean todoDigitos(String num) {
        for (int i = 0; i < num.length(); ++i)
            if (!Character.isDigit(num.charAt(i)))
                return false;

        return true;
    }

    /*
     * Realiza control de errores sobre un los datos de un número de telefo fijo.
     * 
     * @param fijo array conteniendo el código de comunidad y dígitos de un fijo
     * @return void
     * @author Hugo
     */
    public static boolean controlPatron(String[] fijo) {
        boolean correcto = true;

        correcto = fijo[0].equals("91");
        correcto = correcto && fijo[1].length() == 7 && todoDigitos(fijo[1]);

        return correcto;
    }
}