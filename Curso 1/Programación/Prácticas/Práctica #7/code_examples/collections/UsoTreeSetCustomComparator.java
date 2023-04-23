package collections;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Este ejemplo muestra un uso básico
 * de la interfaz Set, utilizando un comparador personalizado
 * @author Hugo Pelayo
 * @Fecha 23 de abril de 2023
 * */
public class UsoTreeSetCustomComparator {
    public static class ComparadorStr implements Comparator<String> {
        public int compare(String first, String second) {
            // implementamos nuestro comparador
            // ver documentación Comparator para más detalles
            return first.compareToIgnoreCase(second);
        }
    }

    public static void main(String[] args) {
        Set<String> nombres = new TreeSet<>(new ComparadorStr());

        nombres.add("Pedro");
        nombres.add("Gerald");
        nombres.add("Barbie");

        // se imprimen en orden
        for (String nombre : nombres)
            System.out.println(nombre);
    }
}