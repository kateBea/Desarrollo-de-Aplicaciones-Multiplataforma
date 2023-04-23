package estructuras_control.selectivas;

import java.util.Scanner;

public class EnhancedSwitch {
    private static final Scanner lector = new Scanner(System.in);
    public static void main(String[] args) {
        String valorEnString;
        System.out.print("Introduce un número entre el 1 y el 4: ");
        int userInput = lector.nextInt();

        valorEnString = switch (userInput) {
            case 1 -> "Uno";
            case 2 -> "Dos";
            case 3 -> "Tres";
            case 4 -> "Cuatro";
            default -> "Desconocido";
        };

        System.out.println("Has introducido el valor: " + valorEnString);
        lector.close();
    }
}
