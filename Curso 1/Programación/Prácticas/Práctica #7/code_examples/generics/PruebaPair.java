package generics;

/**
 * Este ejemplo muestra un uso básico la utilidad Pair
 * @author Hugo Pelayo
 * @Fecha 23 de abril de 2023
 * */
public class PruebaPair {
    public static void main(String[] args) {
        // silenciar advertencia unchecked assigment
        @SuppressWarnings("unchecked")
        Pair<Integer, String>[] numerous = new Pair[3];

        numerous[0] = new Pair<>(1, "Uno");
        numerous[1] = new Pair<>(2, "Dos");
        numerous[2] = new Pair<>(3, "Tres");

        for (Pair<Integer, String> par : numerous)
            System.out.println(par.getFirst() + " con representación " + par.getSecond());
    }
}
