package publicaciones;

/**
 * Clase Ejercicio 3
 * 
 * Representa un Libro
 * 
 * @author Hugo Pelayo
 */
public class Libro extends Publicacion {
    private String nombreEditorial;

    public Libro(String autor, String titutlo, int anioPublicacion, String nombreEditorial) {
        super(autor, titutlo, anioPublicacion);
        this.nombreEditorial = nombreEditorial;
    }

    public String getNombreEditorial() {
        return nombreEditorial;
    }

    public void setNombreEditorial(String nombreEditorial) {
        this.nombreEditorial = nombreEditorial;
    }

    @Override
    public String toString() {
        return super.toString() + 
                String.format("\nEditorial: %s",
            this.nombreEditorial);
    }

    
}
