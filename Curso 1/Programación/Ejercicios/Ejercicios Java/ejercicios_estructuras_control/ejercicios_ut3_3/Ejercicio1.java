package ejercicios_estructuras_control.ejercicios_ut3_3;

public class Ejercicio1 {
    public static void main(String[] args) {
        int suma = 0;

        for (int i = 33; i <= 66; ++i)
            suma += multiploTres(i) ? i : 0;

        System.out.println("Total: " + suma);
    }

    public static boolean multiploTres(int num) {
        return num % 3 == 0;
    }
}