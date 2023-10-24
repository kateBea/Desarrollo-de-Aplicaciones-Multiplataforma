package ejemplos_de_uso;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

public class PredicateUsage {
    public static void main(String[] args) {
        Random rand = new Random();
        List<Double> list = new ArrayList<>();

        for (int i = 0; i < 12; ++i) {
            list.add(rand.nextDouble() * 10.0);
        }

        System.out.println("List size: " + list.size());
        for (Double num : list)
            System.out.println(num);
        
        list.removeIf(new Predicate<Double>() {
            public boolean test(Double other) {
                return other > 5.0;
            }
        });

        System.out.println("List size: " + list.size());
        for (Double num : list)
            System.out.println(num);
 
    }
}