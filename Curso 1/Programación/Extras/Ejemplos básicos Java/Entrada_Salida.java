
/* En este fichero se muestra otra forma de leer datos por consola
 * Uso de la clase Scanner
 */
import java.util.Scanner; //necesario importar la clase

public class Entrada_Salida {
    public static void main(String[] argumentos) {
        // Declarar el objeto e inicializar con
        // el objeto de entrada estándar predefinido

        Scanner sc = new Scanner(System.in);

        // entrada de una cadena
        System.out.println("Escribe una cadena ");
        String name = sc.nextLine();

        // entrada de un carácter
        System.out.println("Escribe un caracter ");
        char gender = sc.next().charAt(0);

        // Entrada de datos numéricos
        // byte, short y float
        System.out.println("Escribe edad ");
        int age = sc.nextInt();
        System.out.println("Escribe tfno ");
        long mobileNo = sc.nextLong();
        System.out.println("Escribe un valor dcimal ");
        double average = sc.nextDouble();

        // Imprima los valores para verificar si la entrada
        // fue obtenida correctamente.
        System.out.println("Nombre: " + name);
        System.out.println("Género: " + gender);
        System.out.println("Edad: " + age);
        System.out.println("Teléfono: " + mobileNo);
        System.out.println("Promedio: " + average);
        sc.close();
    }
}
