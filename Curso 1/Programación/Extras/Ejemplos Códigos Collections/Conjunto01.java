import java.util.HashSet;

/*
 * Ejemplos de Colecciones
 * Ejemplo: Uso Set, concreo clase Hashset.
 * 
 */
import java.util.*;
public class Conjunto01 {
   public static void main (String[] argumentos) 
   {

        Set<String> conjunto = new HashSet<String>();

        //añadimos elementos
        conjunto.add("Juan");
        conjunto.add("Pedro");
        conjunto.add("Miguel");
        conjunto.add("José");

        //recorrer la colección 
        System.out.println ("** Contenido del conjunto: ***");
        for (String elemento :conjunto){
            System.out.println ("Valor es: "+ elemento);

        }
        // lo escribimos en orden pero lo muestra en otro
        conjunto.add("Miguel");
        conjunto.add("José");
        System.out.println ("Conjunto: " + conjunto);




   }
}
