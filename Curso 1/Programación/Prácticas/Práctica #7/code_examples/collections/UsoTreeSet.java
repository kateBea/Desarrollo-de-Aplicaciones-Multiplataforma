package collections;

import java.util.Set;
import java.util.TreeSet;

/**
 * Este ejemplo muestra un uso básico
 * de la interfaz Set
 * @author Hugo Pelayo
 * @Fecha 23 de abril de 2023
 * */
public class UsoTreeSet {
    public static void main(String[] args) {
        Set<String> nombres = new TreeSet<>();

        nombres.add("Pedro");
        nombres.add("Gerald");
        nombres.add("Barbie");

        // se imprimen en orden
        for (String nombre : nombres)
            System.out.println(nombre);
    }
}
