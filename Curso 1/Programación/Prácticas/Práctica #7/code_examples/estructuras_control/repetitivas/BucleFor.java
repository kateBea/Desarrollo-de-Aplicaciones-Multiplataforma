package estructuras_control.repetitivas;

/**
 * Este ejemplo muestra un uso básico del bucle for
 * para mostrar los valores en un array de enteros
 * @author Hugo Pelayo
 * @Fecha 23 de abril de 2023
 * */
public class BucleFor {
    public static void main(String[] args) {
        int[] nums = { 2, 4, -1, 5, 8 };

        for (int i = 0; i < nums.length - 1; ++i)
            System.out.print(nums[i] + " ");

        System.out.print('\n');
    }
}
