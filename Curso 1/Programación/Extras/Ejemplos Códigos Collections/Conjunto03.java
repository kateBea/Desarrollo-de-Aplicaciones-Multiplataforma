/*
 * Ejemplos de Colecciones 
 * Ejemplo: Uso Set (no permite duplicados), 
 * concreto clase LinkekHashSet 
 * los valores del conjunto se encuentran en el orden que se insertan
 * 
 */
import java.util.*;
public class Conjunto03 {
   public static void main (String[] argumentos) 
   {
        //creamos la colección TreeSet usando genéricos
        Set<Character> conjuntoLinked = new LinkedHashSet<Character>();

        //añadimos valores
        conjuntoLinked.add('a');
        conjuntoLinked.add('z');
        conjuntoLinked.add('c');
        conjuntoLinked.add('s');

        //recorremos
        for (Character valor: conjuntoLinked){
            System.out.println ("Valor es "+ valor);
        }
        conjuntoLinked.add('z');
        conjuntoLinked.add('?');
        System.out.println ("El conjunto tiene: " + conjuntoLinked);


       


   }
}
