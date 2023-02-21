import java.util.ArrayList;

import publicaciones.*;

public class Ejercicio3_Pelayo {
    public static void main(String[] args) {
        ArrayList<Publicacion> publicaciones = new ArrayList<>();

        // añadimos publicaciones
        publicaciones.add(new Libro("Hugo", "Atardecer", 2023, "Desconocido"));
        publicaciones.add(new Revista("Julio", "Shenzen", 2019, 1, 2));
        publicaciones.add(new Tesis("Hugo", "Vulkan Engine", 2018, "UPC", 9));

        for (Publicacion publicacion : publicaciones)
            System.out.println(publicacion.toString() + "\n-------------------------");
    }
}
