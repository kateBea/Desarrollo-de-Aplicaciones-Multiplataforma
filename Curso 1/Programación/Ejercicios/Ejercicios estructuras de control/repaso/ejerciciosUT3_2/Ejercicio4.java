package ejerciciosUT3_2;

public class Ejercicio4 {
    public static void main(String[] args) {
        int suma = 0; 
        for (int i = 1; i < 200; ++i)
            if (esPar(i) && !acabadoEnCero(i)) {
                suma += i;
                System.out.println(i);
            }
        
        System.out.println("Suma total: " + suma);
    }

    public static boolean esPar(int num) {
        return num % 2 == 0;
    }

    public static boolean acabadoEnCero(int num) {
        return num % 10 == 0;
    }
}