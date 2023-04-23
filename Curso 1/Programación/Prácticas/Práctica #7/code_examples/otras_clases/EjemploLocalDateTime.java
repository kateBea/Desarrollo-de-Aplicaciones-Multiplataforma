package otras_clases;

import java.time.LocalDateTime;

/**
 * Este ejemplo muestra un uso básico de la clase
 * LocalDateTime para mostrar la fecha y hora actuales
 * @author Hugo Pelayo
 * @Fecha 23 de abril de 2023
 * */
public class EjemploLocalDateTime {
    public static void main(String[] args) {
        LocalDateTime fechaHora = LocalDateTime.of(2023, 4, 23, 15, 30);
        System.out.println(fechaHora);
    }
}
