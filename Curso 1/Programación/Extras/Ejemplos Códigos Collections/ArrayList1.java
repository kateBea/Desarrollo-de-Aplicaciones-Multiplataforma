/*
 * Ejemplos de Colecciones
 * Ejemplo 1: Uso de Array List
 * 
 * ArrayList: permitir añadir, eliminar, modificar
 * objetos de forma transparante programador
 * 
 * Doc: https://docs.oracle.com/javase/6/docs/api/java/util/ArrayList.html
 * 
 */
import java.util.ArrayList;
public class ArrayList1{
    public static void main (String[] argumentos){
        // creación de un ArrayList */

        ArrayList myArray1 = new ArrayList();
        //mostrar el nº elementos
        System.out.println( " El tamaño del objeto creado " + myArray1.size());

        //añadimos elemento con su metodo add
        myArray1.add("Hola");
        myArray1.add ("Otra cosa");
        System.out.println( " El tamaño del objeto creado " + myArray1.size());

        //mostrar todo el contenido
        System.out.println ("El contenido es " + myArray1);

        //añado otro elemento al objeto
        myArray1.add(4);
        System.out.println( " El tamaño del objeto creado " + myArray1.size());
        System.out.println ("El contenido es " + myArray1);

        //eliinar un elemento
        myArray1.remove ("Otra cosa");
        System.out.println ("El contenido es " + myArray1);

        //eliminar por la posicion
        myArray1.remove(0);
        System.out.println ("El contenido es " + myArray1);

        //añado más elelmentos
        myArray1.add (0, "Otro ejemplo");
        System.out.println ("El contenido es " + myArray1);
        myArray1.add("Adios");
        System.out.println ("El contenido es " + myArray1);

        //si la lista tiene el valor "Juan"
        System.out.println ("Juan está en la lista? " + myArray1.contains("Juan"));
        System.out.println ("Adios está en la lista? " + myArray1.contains("Adios"));




    }
}