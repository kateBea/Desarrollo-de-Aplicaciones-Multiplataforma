package estructuras_control.ejerciciosUT3_2;

public class Ejercicio2 {
    public static void main(String[] args) {
        for (int i = 1; i <= 20; ++i)
            if (esPar(i))
                System.out.println(i);
    }

    public static boolean esPar(int num) {
        return num % 2 == 0;
    }
}