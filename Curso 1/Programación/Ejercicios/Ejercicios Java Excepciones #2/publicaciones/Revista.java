package publicaciones;

/**
 * Representa una Revista
 * @author Hugo Pelayo
 * @version 1.0
 */
public class Revista extends Publicacion{
    private int numero;
    private int volumen;

    
    public Revista(String autor, String titutlo, int anioPublicacion, int numero, int volumen) throws FechaMal {
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
