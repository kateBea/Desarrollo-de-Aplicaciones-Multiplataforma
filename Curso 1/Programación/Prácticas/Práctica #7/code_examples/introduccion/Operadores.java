package introduccion;

/**
 * Este ejemplo muestra un uso básico de los operadores
 * de la interfaz Set
 * @author Hugo Pelayo
 * @Fecha 23 de abril de 2023
 * */
public class Operadores {
    public static void main(String[] args) {
        int a = 4 + 7;
        int b = 5 - 7;
        int c = 7 * 8;
        int d = 10 / 2;
        int e = 11 % 7;

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);

        // Primero muestra el valor de a y luego increméntalo
        System.out.println(a++);
        // Primero incrementa el valor de a y luego muéstralo
        System.out.println(++a);
    }
}
