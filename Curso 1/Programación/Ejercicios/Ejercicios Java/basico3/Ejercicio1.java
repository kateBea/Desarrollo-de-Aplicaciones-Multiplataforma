package basico3;

import java.io.*;

public class Ejercicio1 {
    public static void main(String[] args) throws IOException {
        InputStreamReader inputStream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStream);
        int rangoInferior;
        int rangoSuperior;

        System.out.print("Introduza el rango inferior: ");
        rangoInferior = Integer.parseInt(reader.readLine());
        System.out.print("Introduza el rango superior: ");
        rangoSuperior = Integer.parseInt(reader.readLine());

        if (rangoInferior < rangoSuperior)
            imprimirSecuencia(rangoInferior, rangoSuperior);
        else
            System.out.println("Rango inferior debe ser más pequeño");
    }

    public static void imprimirSecuencia(int rInf, int rSup) {
        for (int index = rInf; index < rSup; ++index) {
            System.out.print(index + " ");
        }

        System.out.println();
    }
}