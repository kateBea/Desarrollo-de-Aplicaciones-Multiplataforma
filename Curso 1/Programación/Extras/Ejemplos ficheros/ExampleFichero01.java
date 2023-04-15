/*
 * En el siguiente ejemplo, se prueban algunos de los métodos de la clase File. Para ello, se crearán dos objetos ficheros: uno de un fichero (Persona.java) que si debería existir en el mismo directorio y otro (datos_empleados.dat) que no existe.
 */
import java.io.File;
public class ExampleFichero01 {
    public static void  main(String[] args) {
        File fichero1=new File("Persona.java"); //en este caso existe un fichero Persona.java en mismo directorio
        if(fichero1.exists()){
            System.out.println("Nombre del archivo "+fichero1.getName());
            System.out.println("Camino             "+fichero1.getPath());
            System.out.println("Camino absoluto    "+fichero1.getAbsolutePath());
            System.out.println("Se puede escribir  "+fichero1.canRead());
            System.out.println("Se puede leer      "+fichero1.canWrite());
            System.out.println("Tamaño             "+fichero1.length());
            
       }else
        System.out.println("Fichero " + fichero1.getName() + " no existe");

       File fichero2=new File("datos_empleados.dat"); //en este caso no existe el fichero
       if(fichero2.exists()){
           System.out.println("Nombre del archivo "+fichero2.getName());
           System.out.println("Camino             "+fichero2.getPath());
           System.out.println("Camino absoluto    "+fichero2.getAbsolutePath());
           System.out.println("Se puede escribir  "+fichero2.canRead());
           System.out.println("Se puede leer      "+fichero2.canWrite());
           System.out.println("Tamaño             "+fichero2.length());
        }else
            System.out.println("Fichero " + fichero2.getName() + " no existe");
    }
}
