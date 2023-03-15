package ejerciciosUT3_5;

public class Ejercicio3 {
    public static void main(String[] args) {
        System.out.println("**** Bucle while ****");
        int indice = 0;
        while (indice < 20)
            System.out.print((indice++ + 1) + " ");

        System.out.println("\n**** Bucle do-while ****");
        indice = 0;
        do 
            System.out.print((indice++ + 1) + " ");
        while (indice < 20);

        System.out.println("\n**** Bucle for ****");
        indice = 0;
        for (; indice < 20; ++indice)
            System.out.print((indice + 1) + " ");
    }
}