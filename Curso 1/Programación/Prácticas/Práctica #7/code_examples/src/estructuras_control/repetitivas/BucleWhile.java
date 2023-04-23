package estructuras_control.repetitivas;

/**
 * Muestra por pantalla los números del uno al diez
 * Creado por Hugo Pelayo
 * 23 de abril de 2023
 * */
public class BucleWhile {
    public static void main(String[] args) {
        int inicio = 1;
        final int FINAL = 10;

        while (inicio <= FINAL)
            System.out.print((inicio++) + " ");

        System.out.print('\n');
    }
}
