import java.time.LocalDate;

import ejer1.*;

public class Ejercicio1 {
    public static void main(String[] args) {
        Employee empl = new Employee("1234576Y", "Juan", "Lopez", LocalDate.of(2023, 02, 12), 233.2);

        System.out.println(empl.toString());
    }
}
