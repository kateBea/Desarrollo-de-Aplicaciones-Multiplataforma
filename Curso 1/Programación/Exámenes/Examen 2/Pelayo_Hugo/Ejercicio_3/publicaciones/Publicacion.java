package publicaciones;

/**
 * Clase Ejercicio 3
 * 
 * Representa una Publicación
 * 
 * @author Hugo Pelayo
 */
public class Publicacion {
    private String autor;
    private String titutlo;
    private int anioPublicacion;

    
    public Publicacion(String autor, String titutlo, int anioPublicacion) {
        this.autor = autor;
        this.titutlo = titutlo;
        this.anioPublicacion = anioPublicacion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitutlo() {
        return titutlo;
    }

    public void setTitutlo(String titutlo) {
        this.titutlo = titutlo;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }
    
    @Override
    public String toString() {
        return String.format("Autor: %s\n" +
                            "Título: %s\n" +
                            "Año de publicación: %d",
            this.autor, this.titutlo, this.anioPublicacion);
    }
}
