
/*
 * Ejemplos de Colecciones
 * Ejemplo: Uso de Map, en concreto TreeMap que ordena las claves.
 * 
 */
import java.util.*;
public class Map2 {
    public static void main (String[] argumentos)
    {
        //los mapas los elementos son pares del tipo clave-valor


        Map<String, Double> cuentas = new TreeMap<String, Double>();
        
        // a -- 3258.00
        // v -- 1250.00
        // d --- 4005.70
        // a --- 8000.75

        cuentas.put("a", 3258.00);
        cuentas.put("v", 1250.00);
        cuentas.put("d", 40005.70);
        cuentas.put("a", 80005.75); //se queda con el último

        //recorremos la estructura de datos con for-each
        for (Map.Entry<String, Double> entrada: cuentas.entrySet()){
            System.out.println ("Clave es " + entrada.getKey() + " - Valor: " + entrada.getValue());
        }
    }
    
}
