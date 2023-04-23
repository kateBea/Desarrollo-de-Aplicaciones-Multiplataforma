package otras_clases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Este ejemplo muestra un uso básico de la clase
 * DateTimeFormatter para formatear un String con una fecha
 * @author Hugo Pelayo
 * @Fecha 23 de abril de 2023
 * */
public class EjemploDateTimeFormatter {
    public static void main(String[] args) {
        LocalDate fecha = LocalDate.of(2023, 4, 23);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaFormateada = fecha.format(formatter);

        System.out.println(fechaFormateada);

    }
}
