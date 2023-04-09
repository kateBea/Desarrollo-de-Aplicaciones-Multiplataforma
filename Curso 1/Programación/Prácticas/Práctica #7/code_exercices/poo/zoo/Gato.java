package poo.zoo;

/**
 * Representa un Gato
 * @author Hugo Pelayo
 * @version 1.0
 */
public class Gato extends Animal {
    private PelajeType m_Pelaje;

    /**
     * Representa un tipo de pelaje de un Gato
     */
    public static enum PelajeType {
        CORTO,
        MEDIANO,
        LARGO,
        DESCONOCIDO,
    }

    /**
     * Inicializa este Gato con los parámetros que se
     * pasan como parámetro
     * @param nombre Nombre para este Gato
     * @param pelaje Pelaje para este Gato
     * @param edad Edad para este Gato
     */
    public Gato(String nombre, PelajeType pelaje, int edad) {
        super(nombre, edad);
        m_Pelaje = pelaje;
    }

    /**
     * Inicializa este Gato con los parámetros que se
     * pasan como parámetro. La edad se inicializa a 0
     * @param nombre Nombre para este Gato
     * @param pelaje Pelaje para este Gato
     */
    public Gato(String nombre, PelajeType pelaje) {
        super(nombre);
        m_Pelaje = pelaje;
    }

    /**
     * Inicializa este Gato como copia del que
     * se pasa cómo parámetro
     * @param other Animal del cual este se copia
     */
    public Gato(Gato other) {
        super(other);
        m_Pelaje = other.getPelaje();
    }
    
    /**
     * Inicializa por defecto este Gato.
     * El pelaje es desconocido
     */
    public Gato() {
        super();
        m_Pelaje = PelajeType.DESCONOCIDO;
    }

    /**
     * Retorna el pelaje de este Gato
     * @return Pelaje de este Gato
     */
    public PelajeType getPelaje() {
        return m_Pelaje;
    }

    /**
     * Cambia el pelaje de este Gato por el que se pasa como parámetro
     * @param pelaje Nuevo pelaje para este Gato
     */
    public void setPelaje(PelajeType pelaje) {
        m_Pelaje = pelaje;
    }
}
