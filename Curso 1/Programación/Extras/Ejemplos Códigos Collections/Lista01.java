/* ejemplo de uso de colecciones, en concreto la Interfaz List */
import java.util.*;
public class Lista01 {
    public static void main (String[] argumentos)  {
        
        List<Integer> listaDeNumeros = new ArrayList<Integer>();

        System.out.println ("¿La lista está vacía?: " + listaDeNumeros.isEmpty());

        //añadir elementos a la lista
        listaDeNumeros.add(1);
        listaDeNumeros.add(2);
        listaDeNumeros.add(3);
        listaDeNumeros.add(4);

        System.out.println ("¿La lista está vacía?: " + listaDeNumeros.isEmpty());


        System.out.println ("**Recorrido con for ***");
        for (int posicion=0; posicion<listaDeNumeros.size();posicion++){
            System.out.println("Valor es: " +listaDeNumeros.get(posicion));
        }
        System.out.println ("****Recorrido con for each***");
        for(Integer elemento: listaDeNumeros){
            System.out.println ("Valor es " + elemento);
        }
        System.out.println ("****Recorrido con iterator***");
        Iterator<Integer> itListaDeNumeros = listaDeNumeros.iterator(); //crear un objeto iterator sobre la coleccion listaDeNumeros
        while (itListaDeNumeros.hasNext()){
            Integer num = itListaDeNumeros.next();
            System.out.println ("El valor es " + num);
        }
        System.out.println ("** Otra forma con expresiones Lambda ***");
        listaDeNumeros.forEach(System.out::println);

        //eliminar el elemento de la posición 0
        listaDeNumeros.remove(0);
        System.out.println ("Contenido después de borrar " + listaDeNumeros);

        System.out.println ("El segundo elemento es " + listaDeNumeros.get(2));

        //asignamos el valor 99 en la posición 1
        Integer aux = listaDeNumeros.set(1,99);
        System.out.println ("Aux: " + aux);      
        System.out.println ("Lista: " + listaDeNumeros); 

        //búsqueda de un elemento dentro de la lista
        System.out.println ("La posición del valor 99 es " + listaDeNumeros.indexOf(99));
        System.out.println ("La posición del valor de " + aux + " es " + listaDeNumeros.indexOf(aux));
        
        //añadimos más elementos
        listaDeNumeros.add(5);
        listaDeNumeros.add(45);
        listaDeNumeros.add(33);
        listaDeNumeros.add(27);
        System.out.println ("Lista: " + listaDeNumeros); 

        //generar una nueva sublista
        List<Integer> sublista  = listaDeNumeros.subList(2,7);
        System.out.println ("Contenido de la lista es " + listaDeNumeros);
        System.out.println ("Contenido de la sublista es " + sublista);

        //
        sublista.clear();
        System.out.println ("Contenido de la sublista es " + sublista);
        System.out.println ("Contenido de la lista es " + listaDeNumeros);
        listaDeNumeros.add(-5);
        listaDeNumeros.add(895);
        listaDeNumeros.add(303);
        listaDeNumeros.add(267); 
        System.out.println ("Contenido de la lista es " + listaDeNumeros);
        Collections.sort(listaDeNumeros);
        System.out.println ("Contenido de la lista es " + listaDeNumeros);
        
        //Saber el valor máximo
        System.out.println ("Valor máx: " + Collections.max(listaDeNumeros));

        //Saber el valor min
        System.out.println ("Valor máx: " + Collections.min(listaDeNumeros));
        
        











    }
}
