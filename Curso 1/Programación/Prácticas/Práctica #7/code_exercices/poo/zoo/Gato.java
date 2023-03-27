package poo.zoo;

public class Gato extends Animal {
    private PelajeType m_Pelaje;

    public static enum PelajeType {
        CORTO,
        MEDIANO,
        LARGO,
        DESCONOCIDO,
    }

    public Gato(String nombre, PelajeType pelaje, int edad) {
        super(nombre, edad);
        m_Pelaje = pelaje;
    }

    public Gato(String nombre, PelajeType pelaje) {
        super(nombre);
        m_Pelaje = pelaje;
    }

    public Gato(Gato other) {
        super(other);
        m_Pelaje = other.getPelaje();
    }
    
    public Gato() {
        super();
        m_Pelaje = PelajeType.DESCONOCIDO;
    }

    public PelajeType getPelaje() {
        return m_Pelaje;
    }

    public void setPelaje(PelajeType pelaje) {
        m_Pelaje = pelaje;
    }
}
