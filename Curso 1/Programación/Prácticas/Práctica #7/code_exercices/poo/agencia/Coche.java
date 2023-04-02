package poo.agencia;

public class Coche extends Vehiculo {
    private int m_Puertas;

    public Coche(String matricula, String marca, String modelo, double potencia, int puertas) {
        super(matricula, marca, modelo, potencia);
        m_Puertas = puertas;
    }
    public int getPuertas() {
        return m_Puertas;
    }

    public void setPuertas(int puertas) {
        m_Puertas = puertas;
    }


    
}
