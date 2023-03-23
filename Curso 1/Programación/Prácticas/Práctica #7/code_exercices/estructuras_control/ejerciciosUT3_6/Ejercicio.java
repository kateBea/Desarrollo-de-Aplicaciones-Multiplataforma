package estructuras_control.ejerciciosUT3_6;

import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String userInput;
        boolean correcto = false;

        do {
            System.out.print("Entra valor binario: ");
            userInput = sc.nextLine();
            correcto = isValidBinary(userInput);

            if (!correcto)
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
}