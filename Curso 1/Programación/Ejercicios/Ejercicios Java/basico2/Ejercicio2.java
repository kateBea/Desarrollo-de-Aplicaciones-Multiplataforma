package basico2;

import java.io.*;

public class Ejercicio2 {
    public static void main(String[] args) throws IOException{
        InputStreamReader inputReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputReader);
        final int limite = 10;
        float[] numeros = new float[limite];
        float minimo;
        int indiceMinimo;

        System.out.println("Introduce diez números reales");

        for (int index = 0; index < limite; ++index) {
            numeros[index] = Float.parseFloat(reader.readLine());
        }

        for (int i = 0; i < limite - 1; ++i) {
            minimo = numeros[i];
            indiceMinimo = i;
            for (int j = i + 1; j < limite; ++j) {
                if (numeros[j] < minimo) {
                    minimo = numeros[j];
                    indiceMinimo = j;
                }
            }
            // swap
            numeros[indiceMinimo] = numeros[i];
            numeros[i] = minimo;
        }
        
        System.out.println("Los números en orden son");
        for (float fl : numeros) {
            System.out.print(fl + " ");
        }
    }
}
