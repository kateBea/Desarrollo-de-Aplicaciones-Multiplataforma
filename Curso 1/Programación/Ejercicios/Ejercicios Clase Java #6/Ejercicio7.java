import java.io.*;

public class Ejercicio7 {
    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader lector = new BufferedReader(input);
        int numeroDeRepeticiones;
        String cadena;

        System.out.print("Introduce una cadena: ");
        cadena = lector.readLine();

        System.out.print("Introduce el número de repeticiones: ");
        numeroDeRepeticiones = Integer.parseInt(lector.readLine());

        System.out.print(repetirCadena(cadena, numeroDeRepeticiones));
    }

    public static String repetirCadena(String str, int veces) {
        String resultado = new String();
        for (int i = 0; i < veces; ++i)
            resultado = resultado.concat(str);

        return resultado;
    }
}
