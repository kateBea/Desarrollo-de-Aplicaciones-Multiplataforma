package ejerciciosUT3_3;

public class Ejercicio2 {
    public static void main(String[] args) {
        int suma = 0;

        for (int i = 1; i <= 40; ++i)
            suma += !endWith(i, 5) ? i : 0;

        System.out.println("Total: " + suma);
    }

    public static boolean endWith(int num, int lastdigit) {
        return num % 10 == lastdigit;
    }
}