package estructuras_control.ejerciciosUT3_6;

import java.util.Scanner;

/**
* Este programa piede un número binario del teclado y lo valida,
* luego muestra el correspondiente valor decimal
* 
* Creado por Hugo Pelayo
* 25 de marzo de 2023
*/
public class Ejercicio {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String userInput;
        boolean correcto = false;

        do {
            userInput = leerCadena("Entra valor binario: ");

            if (!(correcto = isValidBinary(userInput)))
                System.out.println("Valor binario incorrecto");
        }
        while (!correcto);

        int decimal = 0;

        for (int i = 0; i < userInput.length(); ++i) 
            decimal += userInput.charAt(i) == '1' ? Math.pow(2, i) : 0;
        
        System.out.println("Valor [base 2]:  " + userInput);
        System.out.println("Valor [base 10]: " + decimal);

        sc.close();
    }

    /*
     * Retorna cierto si number es una cadena binaria válida,
     * retorna falso en caso contrario
     */
    public static boolean isValidBinary(String number) {
        boolean correcto = true;
        int index = 0;
        while (index < number.length() && correcto) {
            correcto = (number.charAt(index) == '1') || 
                (number.charAt(index) == '0');
            
                ++index;
        }

        return correcto;
    } 

    /*
     * Lee una cadena de la entrada estándar mostrando primero
     * el mensaje que se pasa como parámetro
     */
    public static String leerCadena(String promt) {
        System.out.print(promt);
        return sc.nextLine();
    }
}