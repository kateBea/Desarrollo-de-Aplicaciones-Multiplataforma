package entrada_salida;

import java.time.LocalDateTime;

/**
 * Este ejemplo muestra un uso básico de formateo de fechas
 * @author Hugo Pelayo
 * @Fecha 23 de abril de 2023
 * */
public class FormattedOutput {
    public static void main(String[] args) {
        String nombre = "Hugo";
        System.out.printf("Hola tu nombre es %s\n", nombre);
        System.out.printf("La fecha de hoy es: %tB %<te %<tY, y la actual en tu zona es %<tT %<Tp%n\n", LocalDateTime.now());
    }
}
