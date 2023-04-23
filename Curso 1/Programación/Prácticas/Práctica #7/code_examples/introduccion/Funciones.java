package introduccion;

/**
 * Este ejemplo muestra un uso básico de las funciones
 * @author Hugo Pelayo
 * @Fecha 23 de abril de 2023
 * */
public class Funciones {
    public static void main(String[] args) {
        // Llamamos al método
        int resultado = suma(3, 5);

        System.out.print("El resultado es: " + resultado);
    }

    public static int suma(int a, int b) {
        return a + b;
    }
}
