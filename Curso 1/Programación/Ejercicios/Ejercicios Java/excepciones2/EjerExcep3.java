package excepciones2;

import java.util.ArrayList;

import excepciones2.publicaciones.Publicacion;
import excepciones2.publicaciones.FechaMal;
import excepciones2.publicaciones.Libro;
import excepciones2.publicaciones.Revista;
import excepciones2.publicaciones.Tesis;

public class EjerExcep3 {
    public static void main(String[] args) {
        ArrayList<Publicacion> publicaciones = new ArrayList<>();

        try {
            // añadimos publicaciones
            publicaciones.add(new Libro("Hugo", "Atardecer", 2023, "Desconocido"));
            publicaciones.add(new Revista("Julio", "Shenzen", 2019, 1, 2));
            publicaciones.add(new Tesis("Hugo", "Vulkan Engine", 2018, "UPC", 9));
        }
        catch (FechaMal e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        for (Publicacion publicacion : publicaciones)
            System.out.println(publicacion.toString() + "\n-------------------------");

        try {
            publicaciones.add(new Tesis("Gerald", "Ray casting", 2024, "UPC", 9));
        } 
        catch (FechaMal e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}