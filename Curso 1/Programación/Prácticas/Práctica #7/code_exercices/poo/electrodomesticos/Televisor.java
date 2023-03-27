package poo.electrodomesticos;

public class Televisor extends Producto {
    private float m_Pulgadas;

    public Televisor(String fabricante, String serie, double precio, float pulgadas) {
        super(fabricante, serie, precio);
        m_Pulgadas = pulgadas < 0.0f ? 0.0f : pulgadas;
    } 

    public float getPulgadas() {
        return m_Pulgadas;
    }

    public void setPulgadas(float pulgadas) {
        if (!(pulgadas < 0.0))
            m_Pulgadas = pulgadas;
    }
    
}
