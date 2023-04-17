package file_io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Esta programa lee una lista de productos de un fichero
 * y guarda en otro con nmbre similar los precios
 * de dichos productos habiendo aplicado el IVA
 * 
 * Creado por Hugo Pelayo
 * 17 de abril de 2023
 */
public class Ejercicio7 {
    // porcentaje sobre 100%
    private static final double IVA = 21.0;
    public static void main(String[] args) {
        if (args.length != 1) {
            usage();
            return;
        }

        File fichero = new File(args[0]);
        File ficheroOut = new File("productosConIVA.txt");
        ArrayList<String> productos;
        ArrayList<String> productosConIva;

        if (fichero.exists() && fichero.isFile()) {
            productos = readProducts(fichero);
            productosConIva = getPreciosConIva(productos);

            try {
                ficheroOut.createNewFile();
            } 
            catch (IOException e) {
                e.printStackTrace();
            }

            writeToFile(ficheroOut, productosConIva.toArray());
            
        }   
        else
            System.out.println("El fichero es un directorio o no existe\n");

        
    }

    /*
     * Muestra el uso de este programa
     */
    public static void usage() {
        System.out.println("usage: java Ejercicio7 arg");
        System.out.println("-> Este programa recibe un solo argumento que es la ruta completa del fichero con los productos");
        System.out.println("-> Es recomendable ejecutar desde la terminal");
    }

    /*
     * Lee los productos de un fichero. Se asume
     * que el fichero existe y no es un directorio
     */
    public static ArrayList<String> readProducts(File fichero) {
        ArrayList<String> productos = new ArrayList<>();
        String value;
        try {
            BufferedReader lector = new BufferedReader(new FileReader(fichero));
            while ((value = lector.readLine()) != null) {
                productos.add(value);
            }

            lector.close();
        } 
        catch (FileNotFoundException fne) { fne.printStackTrace(); }
        catch(IOException e) { e.printStackTrace(); }

        return productos;
    }

    /*
     * Escribe el contenido de "contents" al fichero indicado
     * Se asume que el fichero ya existe
     */
    public static void writeToFile(File fichero, Object... contents) {
        try {
            BufferedWriter escritor = new BufferedWriter(new FileWriter(fichero,false));
            for (Object item : contents) {
                try {
                    escritor.write(item.toString());
                } 
                catch (IOException e) {
                    e.printStackTrace();
                }
            }

            escritor.close();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * Retorna una lista de los productos con el precio aplicando IVA
     */
    public static ArrayList<String> getPreciosConIva(ArrayList<String> lista) {
        ArrayList<String> productos = new ArrayList<>();

        for (String producto : lista) {
            String[] tokens = producto.split(";");

            // se asume que el precio siempre está al final
            tokens[tokens.length - 1] = 
                Double.toString(Double.parseDouble(tokens[tokens.length - 1]) * ((IVA + 100.0) / 100.0));

            productos.add(String.join("; ", tokens));
        }

        return productos;
    }
}