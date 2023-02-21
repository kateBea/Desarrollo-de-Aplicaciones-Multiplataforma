package publicaciones;

/**
 * Clase Ejercicio 3
 * 
 * Representa una Tésis
 * 
 * @author Hugo Pelayo
 */
public class Tesis extends Publicacion{
    String universidad;
    int calificacion;

    public Tesis(String autor, String titutlo, int anioPublicacion, String universidad, int calificacion) {
        super(autor, titutlo, anioPublicacion);
        this.universidad = universidad;
        this.calificacion = calificacion;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return super.toString() + 
                String.format("\nUniversidad: %s\n" +
                            "Calificación: %d",
            this.universidad, this.calificacion);
    }      
}
