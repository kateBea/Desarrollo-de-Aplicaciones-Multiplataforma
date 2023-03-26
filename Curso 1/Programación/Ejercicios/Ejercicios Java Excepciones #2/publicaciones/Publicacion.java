package publicaciones;

import java.time.LocalDate;


/**
 * Representa una Publicación
 * 
 * @author Hugo Pelayo
 * @version 1.0
 */
public class Publicacion {
    private String autor;
    private String titutlo;
    private int anioPublicacion;

    
    public Publicacion(String autor, String titutlo, int anioPublicacion) throws FechaMal{
        this.autor = autor;
        this.titutlo = titutlo;

        if (anioPublicacion > LocalDate.now().getYear() || anioPublicacion < 0)
            throw new FechaMal("El año de publicación es posterior al actual o es negativo");

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

    public void setAnioPublicacion(int anioPublicacion) throws FechaMal {
        if (anioPublicacion > LocalDate.now().getYear() || anioPublicacion < 0)
            throw new FechaMal("El año de publicación es posterior al actual o es negativo");

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
