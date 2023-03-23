package estructuras_control.ejerciciosUT3_3;

public class Ejercicio3 {
    public static void main(String[] args) {

        for (int valor = 1; valor <= 120 / 2; ++valor)
            if (esDivisible(120, valor))
                System.out.printf("120 es divisible por [ %d ]\n", valor);
        
    }

    public static boolean esDivisible(int dividendo, int divisor) {
        return dividendo % divisor == 0;
    }
}