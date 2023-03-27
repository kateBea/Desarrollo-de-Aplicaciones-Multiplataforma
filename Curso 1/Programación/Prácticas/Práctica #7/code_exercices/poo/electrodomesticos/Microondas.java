package poo.electrodomesticos;

public class Microondas extends Producto {
    // potencia en vatios (W)
    private double m_Potencia;

    public Microondas(String fabricante, String serie, double precio, double potencia) {
        super(fabricante, serie, precio);
        m_Potencia = potencia < 0.0 ? 0.0 : potencia;
    } 

    public double getPotencia() {
        return m_Potencia;
    }

    public void setPotencia(double potencia) {
        if (!(potencia < 0.0))
            m_Potencia = potencia;
    }
}
