package poo.agencia;

public class Moto extends Vehiculo {
    // cierto si esta moto tiene maletín portacasco
    private boolean m_Maletin;
    
    public Moto(String matricula, String marca, String modelo, double potencia, boolean maletin) {
        super(matricula, marca, modelo, potencia);
        m_Maletin = maletin;
    }

    public boolean tieneMaletin() {
        return m_Maletin;
    }

    public void setPoseerMaletin() {
        m_Maletin = true;
    }

    public void unsetPoseerMaletin() {
        m_Maletin = false;
    }


    
}
