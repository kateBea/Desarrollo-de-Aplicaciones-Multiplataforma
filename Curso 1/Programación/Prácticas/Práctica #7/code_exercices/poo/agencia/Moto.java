package poo.agencia;

public class Moto extends Vehiculo {
    // Indica si esta moto tiene maletín portacasco
    // en cuyo caso es cierto, en caso contrario es falso
    private boolean m_Maletin;
    
    /**
     * Inicializa esta Moto con los valores que se pasa 
     * como parámetros. Si las referencias son nulas, se consideran
     * desconocidos y, en caso de ser negativa la potencia, esta se inicializa a 0
     * @param matricula Matrícula para esta Moto
     * @param marca Marca para esta Moto
     * @param modelo Modelo para esta Moto
     * @param potencia Caballos de potencia para esta Moto
     * @param maletin Indica si esta moto debellevar maletín portacasco, true si sí, false si no
     */
    public Moto(String matricula, String marca, String modelo, double potencia, boolean maletin) {
        super(matricula, marca, modelo, potencia);
        m_Maletin = maletin;
    }

    /**
     * Retorna cierto si esta Moto lleva maletín portacasco falso en caso contrario
     * @return Indica si esta Moto lleva o no maletín portacasco
     */
    public boolean tieneMaletin() {
        return m_Maletin;
    }

    /**
     * Indica que esta Moto debe llevar maletín portacasco
     */
    public void setPoseerMaletin() {
        m_Maletin = true;
    }

    /**
     * Indica que esta Moto no debe llevar maletín portacasco
     */
    public void unsetPoseerMaletin() {
        m_Maletin = false;
    }    
}
