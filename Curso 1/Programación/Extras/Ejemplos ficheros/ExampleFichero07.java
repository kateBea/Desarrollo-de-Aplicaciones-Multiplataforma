/* Ejemplo creación de un nuevo directorio en el Escritorio */
import java.io.File;

public class ExampleFichero07 {
    public static void main(String[] args) {
        //en este caso creará un directorio en el escritorio, si existe indica que ya existe
        File f = new File("c:\\Users\\Usuario\\Desktop\\directorio_nuevo");
  
        // comprobar si el directorio puede ser creado 
        if (f.mkdir()) {           
            System.out.println("Directorio creado");
        }
        else {
            System.out.println("Directorio ya existe");
        }

        // en este segundo ejemplo se indica Desktop2 el cual no existe
        // la primera vez creará los dos directorios.
        File f2 = new File("c:\\Users\\Usuario\\Desktop2\\directorio_nuevo"); 
     
        if (f2.mkdir()) {           
            System.out.println("Directorio creado");
        }
        else {
            System.out.println("No se pudo crear o ya existe");
        }
    }
}
