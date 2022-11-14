import java.util.Scanner;

public class Ejercicio1 {
    public static int busquedaBinaria(char[] letras, char target, int limInf, int limSup) {
        int midle = (limInf + limSup) / 2;
        if (limSup > limInf) {
            if (letras[midle] > target) return busquedaBinaria(letras, target, limInf, midle - 1);
            if (letras[midle] < target) return busquedaBinaria(letras, target, midle + 1, limSup);
            return midle;
        }

        return midle * -1;
    }

    public static void main(String[] args) {
        final int limite =  26;
        char[] letras = new char[limite];
        char target;
        Scanner sc = new Scanner(System.in);

        for (int contador = 0; contador < limite; ++contador)
            letras[contador] = (char)((contador) + 'a');

        for (int contador = 0; contador < limite; ++contador)
            System.out.printf("['%c'| %d ]  ", letras[contador], contador);

            System.out.print("\n¿Qué carácter buscas? ");
            target = sc.nextLine().charAt(0);

        int indice = busquedaBinaria(letras, target, 0, letras.length - 1);

        if (indice > -1) {
            System.out.printf("Carácter [%c] encontrado en índice [%d]", letras[indice], indice);
        }
        else {
            System.out.println("El carácter no existe");
        }

        sc.close();
    }
}
