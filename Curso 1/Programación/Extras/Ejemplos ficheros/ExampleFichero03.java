/*El siguiente ejemplo muestra información del fichero que se indica en el código, siempre y cuando esté en esa ubicación 
 */
import java.io.File;

public class ExampleFichero03 {
    public static void main(String[] args) {
        System.out.println("INFORMACIÓN SOBRE EL FICHERO:");
        File f = new File("c:\\Users\\Usuario\\Desktop\\code_examples_ficheros\\ExampleFichero03.java");  
        if(f.exists()){
              System.out.println("Nombre del fichero: "+f.getName());
              System.out.println("Ruta: "+f.getPath());
              System.out.println("Ruta absoluta: "+f.getAbsolutePath());
              System.out.println("Se puede leer: "+f.canRead());
              System.out.println("Se puede escribir: "+f.canWrite());
              System.out.println("Tamaño: "+f.length());
              System.out.println("Es un directorio: "+f.isDirectory()); 
             System.out.println("Es un fichero: "+f.isFile());
            System.out.println("Nombre del directorio padre: "+f.getParent());
        }else
            System.out.println("Fichero " + f.getName() + " no existe");
         
    }
}
