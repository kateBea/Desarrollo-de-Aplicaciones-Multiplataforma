package otras_clases;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Este ejemplo muestra un uso básico de la clase
 * ChronoUnit para mostrar la diferencia en días entre dos fechas
 * @author Hugo Pelayo
 * @Fecha 23 de abril de 2023
 * */
public class EjemploChronoUnit {
    public static void main(String[] args) {
        LocalDate fecha1 = LocalDate.of(2023, 4, 23);
        LocalDate fecha2 = LocalDate.of(2023, 5, 1);

        // Calcula la diferencia en días
        long dias = ChronoUnit.DAYS.between(fecha1, fecha2);
        System.out.println(dias);

    }
}
