/*
Crear la clase diccionario, para traducir del español al inglés:

Atributo: Hashtable <String, String> dic;

Constructor:

        public diccionario(){
                dic = new Hashtable<String, String> ();
        }

Métodos: 

public void limpiar();			Para vaciar el hash.
public int cantElementos();			Devuelve el número de elementos que tiene.
public boolean isVacio();			Verificar si el hash está vacío.
public void imprimir(Hastable h); 		Imprimir el hash.
public void insertar(String pal1, String pal2)	Insertar entrada.

Método main:

-	Instanciar la clase
-	Dar de alta 5 entradas en el diccionario.
-	Imprimir el hash
-	Decir cuántos elementos tiene.
-	Vaciar el hash si no está vacío.
-	Si está vacío dar de alta 3 entradas.
-	Imprimir el hash

 * 
 * 
 */
import java.util.*;

public class Diccionario {

    Hashtable<String, String> dic;

    
    public Diccionario(){
        dic = new Hashtable<String, String>();
    }

    public void limpiar (){
        dic.clear();

    }
    public int cantElementos(){
        return dic.size();

    }
    public boolean isVacio(){
        return dic.isEmpty();


    }
    public void imprimir (Hashtable<String, String> ht){
        Enumeration <String> claves = ht.keys();
    
        while (claves.hasMoreElements()){ //recorremos mientras tiene elementos
            String obj = claves.nextElement();
            String valor = ht.get(obj);
            System.out.println( obj + " " + valor +"\n");
        }

    }
    public void insertar (String palabra1, String palabra2){
        //comprobamos que no esté la palabra
        if (!dic.containsKey(palabra1)){
            dic.put(palabra1, palabra2);
        }

    }

    public static void main(String[] args) {
        // instancio la clase
        Diccionario d = new Diccionario();

        // inserto 5 elementos
        d.insertar("gato", "cat");
        d.insertar ("perro", "dog");
        d.insertar ("lápiz", "pencil");
        d.insertar ("mesa", "table");
        d.insertar ("libro", "book");

        // imprimir

        d.imprimir (d.dic);

        // nº elementos 

        System.out.println (" Tiene " + d.cantElementos() + " elementos.");

        //vaciar si no está vacío
        if (!d.isVacio()){
            d.limpiar();
        }

        // nº elementos 

        System.out.println (" Tiene " + d.cantElementos() + " elementos.");

        //imprimir 
        d.imprimir(d.dic);

    }
}
