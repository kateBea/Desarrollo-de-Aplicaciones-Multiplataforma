package otras_clases;

import java.time.LocalDate;

/**
 * Este ejemplo muestra un uso básico de la clase
 * LocalDate para mostrar la fecha actual
 * @author Hugo Pelayo
 * @Fecha 23 de abril de 2023
 * */
public class EjemploLocalDate {
    public static void main(String[] args) {
        LocalDate fecha = LocalDate.of(2023, 4, 23);
        System.out.println(fecha.getDayOfWeek());

    }
}
