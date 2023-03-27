package poo.electrodomesticos;

public class Lavadora extends Producto {
    // capacidad en kilogramos
    private double m_Capacidad;

    public Lavadora(String fabricante, String serie, double precio, double capacidad) {
        super(fabricante, serie, precio);
        m_Capacidad = capacidad < 0.0 ? 0.0 : capacidad;
    } 

    public double getCapacidad() {
        return m_Capacidad;
    }

    public void setCapacidad(double capacidad) {
        if (!(capacidad < 0.0))
            m_Capacidad = capacidad;
    }
}
