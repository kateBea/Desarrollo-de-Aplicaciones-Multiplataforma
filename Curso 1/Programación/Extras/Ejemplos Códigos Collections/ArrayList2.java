/*
 * Ejemplos de Colecciones
 * Ejemplo 2: Uso de Array List
 * 
 * ArrayList: permitir añadir, eliminar, modificar
 * objetos de forma transparante programador
 * 
 * Doc: https://docs.oracle.com/javase/6/docs/api/java/util/ArrayList.html
 * 
 */
import java.util.ArrayList;
import java.util.Iterator;
public class ArrayList2{
    public static void main (String[] argumentos){
        // creación array con nombres

        ArrayList<String> names = new ArrayList<String>();

        //añadimos elementos
        names.add("Pedro");
        names.add("Lucía");
        names.add("Rebeca");

        //mostrar el contenido y su tamaño
        System.out.println ("El objeto tiene " + names.size() + " elementos con estos valores: " + names);

        //eliminar el primer elemento
        names.remove(0);
        System.out.println (names);

        names.set(0, "Perico");
        System.out.println (names);

        ArrayList<String> friends = names; 
        //tengo dos objetos friends y names que apuntan a misma posicion
        System.out.println ("names : " + names);
        System.out.println ("friends: " + friends);
       
        names.add("María");
        System.out.println ("names : " + names);
        System.out.println ("friends: " + friends);

        friends.remove ("Perico");
        System.out.println ("names : " + names);
        System.out.println ("friends: " + friends);
      
        //formas de recorrer la colección names


        //1ª bucle for
        System.out.println ("****** Recorrido con for ***********");
        for (int posicion=0; posicion < names.size(); posicion++){
            System.out.println ("Nombre " + posicion + ": " + names.get(posicion));
        }


        //2ª usando los iteradores
        System.out.println ("****** Recorrido con iterator ***********");
        Iterator<String> it = names.iterator();
        while (it.hasNext()){
            System.out.println (it.next());
        }



        //3ª usando for-each
        System.out.println ("****** Recorrido con for-each ***********");
        for (String elemento:names){
            System.out.println (elemento);
        }




    }
}