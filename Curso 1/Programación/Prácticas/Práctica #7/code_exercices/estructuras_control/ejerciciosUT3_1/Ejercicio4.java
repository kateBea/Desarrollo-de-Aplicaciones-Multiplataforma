package estructuras_control.ejerciciosUT3_1;

/**
 * Este programa muestra por pantalla los 20 primeros números enteros
 * que hay justa después del número 1
 * 
 * Creado por Hugo Pelayo
 * 25 de marzo de 2023
 */
public class Ejercicio4 {
    public static void main(String[] args) {
        int n = 1;

        // enunciado ambiguo. Se considera los veinte
        // primeros números más grandes que el de la declaración
        for (int i = 0; i < 20; ++i)
            System.out.println(i + n + 1);
    }
}