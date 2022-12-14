import java.io.*;

public class Ejercicio6{
    private static final int HORAS_A_SEGUNDOS = 3600;
    private static final int MINUTOS_A_SGUNDOS = 60;

    public static void main(String[] args) throws IOException{
        int tiempoTotalSegundos;
        tiempoTotalSegundos = leerDatos();
        imprimirTiempo(tiempoTotalSegundos + 1);
    }

    public static int leerDatos() throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader lector = new BufferedReader(input);
        String[] entrada;

        System.out.print("Introduzca el tiempo. Separado por espacios. ");
        System.out.print("Ejemplo: [17 32 11]: ");
        entrada = lector.readLine().split(" ");

        return Integer.parseInt(entrada[0]) * HORAS_A_SEGUNDOS +
            Integer.parseInt(entrada[1]) * MINUTOS_A_SGUNDOS +
            Integer.parseInt(entrada[2]);
    }

    public static void imprimirTiempo(int tiempo) {
        int horas = (tiempo / HORAS_A_SEGUNDOS) % 24;
        tiempo %= HORAS_A_SEGUNDOS;
        int minutos = tiempo / MINUTOS_A_SGUNDOS;
        tiempo %= MINUTOS_A_SGUNDOS;
        int segundos = tiempo;

        System.out.print(((horas < 10 ? ("0" + horas) : horas) + ":"));
        System.out.print(((minutos < 10 ? ("0" + minutos) : minutos) + ":"));
        System.out.print(((segundos < 10 ? ("0" + segundos) : segundos) + "\n"));
    }
}
