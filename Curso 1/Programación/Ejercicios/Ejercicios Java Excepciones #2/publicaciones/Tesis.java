package publicaciones;

/**
 * Representa una Tésis
 * 
 * @author Hugo Pelayo
 * @version 1.0
 */
public class Tesis extends Publicacion{
    private String universidad;
    private int calificacion;

    public Tesis(String autor, String titutlo, int anioPublicacion, String universidad, int calificacion) throws FechaMal {
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
