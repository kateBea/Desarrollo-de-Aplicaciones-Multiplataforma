package entrada_salida;

import java.time.LocalDateTime;

public class FormattedOutput {
    public static void main(String[] args) {
        String nombre = "Hugo";
        System.out.printf("Hola tu nombre es %s\n", nombre);
        System.out.printf("La fecha de hoy es: %tB %<te %<tY, y la actual en tu zona es %<tT %<Tp%n\n", LocalDateTime.now());
    }
}
