package estructuras_control.ejerciciosUT3_1;

public class Ejercicio4 {
    public static void main(String[] args) {
        int n = 1;

        // enunciado ambiguo. Se considera los veinte
        // primeros números más grandes que el de la declaración
        for (int i = 1; i <= 20; ++i)
            System.out.println(i + n);
    }
}