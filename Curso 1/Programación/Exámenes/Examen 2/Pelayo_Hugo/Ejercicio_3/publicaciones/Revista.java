package publicaciones;

/**
 * Clase Ejercicio 3
 * 
 * Representa una Revista
 * 
 * @author Hugo Pelayo
 */
public class Revista extends Publicacion{
    int numero;
    int volumen;

    
    public Revista(String autor, String titutlo, int anioPublicacion, int numero, int volumen) {
        super(autor, titutlo, anioPublicacion);
        this.numero = numero;
        this.volumen = volumen;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    @Override
    public String toString() {
        return super.toString() + 
                String.format("\nNúmero: %d\n" +
                            "Volumen: %d",
            this.numero, this.volumen);
    }   
}
