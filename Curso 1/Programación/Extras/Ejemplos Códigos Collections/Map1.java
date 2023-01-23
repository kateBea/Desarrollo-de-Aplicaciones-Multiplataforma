
/*
 * Ejemplos de Colecciones
 * Ejemplo: Uso de Map, en concreto HashMap.
 * 
 */
import java.util.*;
public class Map1 {
    public static void main (String[] argumentos)
    {
        //los mapas los elementos son pares del tipo clave-valor

        Map<Integer, String> alumnos = new HashMap<Integer, String>();
        
        // 01 -- Juan Perez
        // 02 -- María Jimenez
        //...

        alumnos.put(1, "Juan Pérez");
        alumnos.put(2, "María Jiménez");
        alumnos.put(3, "Rosa Ruiz");

        //recorremos la estructura de datos con for-each
        for (Map.Entry<Integer, String> entrada: alumnos.entrySet()){
            System.out.println ("Clave es " + entrada.getKey() + " - Valor: " + entrada.getValue());
        }
    }
    
}
