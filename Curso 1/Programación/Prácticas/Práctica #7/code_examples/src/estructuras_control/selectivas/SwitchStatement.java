package estructuras_control.selectivas;

import java.util.Scanner;

public class SwitchStatement {
    private static final Scanner lector = new Scanner(System.in);
    public static void main(String[] args) {
        String valorEnString;
        System.out.print("Introduce un número entre el 1 y el 4: ");
        int userInput = lector.nextInt();

        switch (userInput) {
            case 1:
                valorEnString = "Uno";
                break;
            case 2:
                valorEnString = "Dos";
                break;
            case 3:
                valorEnString = "Tres";
                break;
            case 4:
                valorEnString = "Cuatro";
                break;
            default:
                valorEnString = "Desconocido";
                break;
        }

        System.out.println("Has introducido el valor: " + valorEnString);
        lector.close();
    }
}
