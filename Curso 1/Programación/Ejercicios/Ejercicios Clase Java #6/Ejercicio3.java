import java.io.*;

public class Ejercicio3 {
    public static void main(String[] args) throws IOException {
        float[] punto1;
        float[] punto2;

        punto1 = transformarCoordenadas(leerPunto());
        punto2 = transformarCoordenadas(leerPunto());

        System.out.println("La pendiente de la línea es: " + pendiente(punto1, punto2));
    }

    public static float[] transformarCoordenadas(String punto) {
         // [0] -> coordenada x, [1] -> coordenada y
        float[] resultado = new float[2];
        resultado[0] = Float.parseFloat(punto.split(" ")[0]);
        resultado[1] = Float.parseFloat(punto.split(" ")[1]);

        return resultado;
    }

    public static String leerPunto() throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader lector = new BufferedReader(input);
        String punto;

        System.out.print("Introduce coordenadas del punto. Ejemplo [3.1 4.2]: ");
        punto = lector.readLine();

        return punto;
    }

    public static float pendiente(float[] p1, float[] p2) {
        return (p2[1] - p1[1]) / (p2[0] - p1[0]); 
    }
}
