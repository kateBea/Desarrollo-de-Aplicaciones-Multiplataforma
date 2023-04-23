package estructuras_control.repetitivas;

/**
 * Este ejemplo muestra un uso básico del bucle while
 * para mostrar los valores en un rango de enteros
 * @author Hugo Pelayo
 * @Fecha 23 de abril de 2023
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
