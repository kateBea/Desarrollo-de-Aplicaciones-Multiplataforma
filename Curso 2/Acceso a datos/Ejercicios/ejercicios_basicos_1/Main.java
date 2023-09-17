
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Estudiante> listaEstudiantes = new HashMap<>();

        while (notExit()) {
            Estudiante est = new Estudiante();
            est.leer();
            listaEstudiantes.put(est.getNia(), est);
        }

        mostrarEstudiantes(listaEstudiantes);
    }

    private static void mostrarEstudiantes(HashMap<String, Estudiante> listaEstudiantes) {
        
    }

    public static boolean notExit() {
        String input = Lector.leerCadena("¿Quieres seguir? [Y/n] -> ");
        return input.equalsIgnoreCase("Y");
    }
}
