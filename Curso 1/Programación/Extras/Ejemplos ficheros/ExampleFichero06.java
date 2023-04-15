/* Ejemplo creación de un nuevo directorio en el Escritorio */
import java.io.File;

public class ExampleFichero06 {
    public static void main(String[] args) {
        //en este caso creará un directorio en el escritorio, si existe indica que ya existe
        File f = new File("c:\\Users\\Usuario\\Desktop\\directorio_nuevo");
  
        // comprobar si el directorio puede ser creado 
        if (f.mkdirs()) {           
            System.out.println("Directorio creado");
        }
        else {
            System.out.println("Directorio ya existe");
        }

        File f2 = new File("c:\\Users\\Usuario\\Desktop2\\directorio_nuevo");
  
        // comprobar si el directorio puede ser creado 
        if (f2.mkdirs()) {           
            System.out.println("Directorio creado");
        }
        else {
            System.out.println("Directorio ya existe");
        }
    }
}
