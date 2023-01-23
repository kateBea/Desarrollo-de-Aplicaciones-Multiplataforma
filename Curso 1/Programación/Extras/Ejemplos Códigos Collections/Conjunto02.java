import java.util.HashSet;

/*
 * Ejemplos de Colecciones 
 * Ejemplo: Uso Set (no permite duplicados), concreto clase TreeSet que almacena de manor a mayor
 * 
 */
import java.util.*;
public class Conjunto02 {
   public static void main (String[] argumentos) 
   {
        //creamos la colección TreeSet usando genéricos
        Set<String> conjuntoTree = new TreeSet<String>();

        //añadimos valores
        conjuntoTree.add("Juan");
        conjuntoTree.add("Pedro");
        conjuntoTree.add("María");
        conjuntoTree.add("Josefa");

        //recorremos
        for (String valor: conjuntoTree){
            System.out.println ("Valor es "+ valor);
        }
        conjuntoTree.add("María");
        System.out.println ("El conjunto tiene: " + conjuntoTree);


       


   }
}
