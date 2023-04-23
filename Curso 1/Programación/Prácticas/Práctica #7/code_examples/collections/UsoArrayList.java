package collections;

import java.util.ArrayList;
import java.util.List;

/**
 * Este ejemplo muestra una utilización básica
 * con la interfaz de List
 * @author Hugo Pelayo
 * @Fecha 23 de abril de 2023
 * */
public class UsoArrayList {
    public static void main(String[] args) {
        List<String> nombres = new ArrayList<>();

        nombres.add("Pedro");
        nombres.add("Gerald");
        nombres.add("Barbie");

        for (String nombre : nombres)
            System.out.println(nombre);
    }
}
