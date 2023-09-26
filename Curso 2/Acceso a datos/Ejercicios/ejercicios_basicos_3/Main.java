package ejercicios_basicos_3;

import java.util.HashMap;
import utilidades.FormattedIO;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Estudiante> listaEstudiantes = new HashMap<>();

        do {
            Estudiante est = new Estudiante();
            est.leer();
            listaEstudiantes.put(est.getNia(), est);
        }
        while (notExit());

        mostrarEstudiantes(listaEstudiantes);
    }

    private static void mostrarEstudiantes(HashMap<String, Estudiante> listaEstudiantes) {
        // Mostrar en orden inverso, cambiar estructura de datos
        Object[] keySet = listaEstudiantes.keySet().toArray();
        
        // Formatting
        System.out.println();

        for (int index = keySet.length - 1; index >= 0; --index)
            listaEstudiantes.get(keySet[index]).mostrar();
    }

    public static boolean notExit() {
        String input = FormattedIO.leerCadena("¿Quieres seguir? [Y/n] -> ");
        return input.equalsIgnoreCase("Y");
    }
}
