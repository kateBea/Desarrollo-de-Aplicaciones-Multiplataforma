package ejercicio2;

import java.io.*;

public class TestSerializacion {
    public static void main(String[] args) {
        System.out.println("************** Ejercicio 2 **************************");
        exposeSearializable("piscina.dat");
    }

    public static void exposeSearializable(String fileDir) {
        try {
            ObjectInputStream file = new ObjectInputStream(new FileInputStream((fileDir)));
            Piscina pisc = (Piscina) file.readObject();
            System.out.println(pisc.toString());
            file.close();
        }
        catch (IOException | ClassNotFoundException e) {
            System.out.println("Fichero no encontrado...");
        }
    }
}
