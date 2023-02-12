package figuras;

/**
 * <h2>Representa un Círculo</h2>
 * 
 * Esta clase representa un Círculo
 * 
 * @author Hugo Pelayo
 * @version 1.0
 */

public final class Circulo extends Figura {
    // Representa el radio de este Círculo
    private double m_Radio;

    public Circulo(String nombre, ColorType color, double radio) {
        super(nombre, color);
        m_Radio = radio < 0.0 ? 0.0 : radio;
    }

    public Circulo(String nombre, ColorType color, double coordx, double coordy, double radio) {
        super(nombre, color, coordx, coordy);
        m_Radio = radio < 0.0 ? 0.0 : radio;
    }

    public Circulo(Circulo other) {
        super(other);
    }

    public void setRadio(double radio) {
        m_Radio = radio < 0.0 ? 0.0 : radio;
    }

    public double getRadio() {
        return m_Radio;
    }

    @Override
    public void dibujar() {

    }

    @Override
    public double calcularArea() {
        return Math.pow(m_Radio, 2) * Math.PI; 
    }

    @Override
    public String toString() {
        return String.format("El radio del círculo es: %.3", m_Radio);
    }
}
