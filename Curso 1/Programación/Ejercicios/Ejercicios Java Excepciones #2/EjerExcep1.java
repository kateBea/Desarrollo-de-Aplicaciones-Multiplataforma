import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;
import java.io.BufferedReader;

public class EjerExcep1 {
    public static class NotaInvalida extends Exception {
        public NotaInvalida(String msg) {
            super(msg);
        }
    }

    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader reader = new BufferedReader(input);
    public static void main(String[] args) {
        int nota;
        char calificacion;
        boolean acabar = false;
        boolean notasValidas = true;
        int[] marks = new int[5];

        try {
            for (int i = 0; i < 5 && !acabar; ++i) {
                System.out.print("Introduzca calificación: ");
                calificacion = reader.readLine().charAt(0);
                nota = valorDeNota(calificacion);

                if (nota == -2)
                    throw new NotaInvalida("nota introducida no valida");
                else if (nota != -1)
                    marks[i] = nota;
                else 
                    acabar = true;
            }
        }
        catch (IOException io) {
            System.out.println(io.getMessage());
        }
        catch (NotaInvalida ni) {
            notasValidas = false;
            System.out.println(ni.getMessage());
        }

        if (notasValidas)
            System.out.println("El promedio de las cualificaciones es: " + 
                IntStream.of(marks).sum() / (double)marks.length);
    }

    public static int valorDeNota(char calificacion) {
        return switch(calificacion) {
            case 'A' -> 4;
            case 'B' -> 3;
            case 'C' -> 2;
            case 'D' -> 1;
            case 'E' -> 0;
            case 'F' -> -1;
            default -> -2;
        };
    }
}