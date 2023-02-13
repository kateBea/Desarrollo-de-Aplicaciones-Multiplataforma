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

        m_Radio = other.getRadio();
    }

    public void setRadio(double radio) {
        m_Radio = radio < 0.0 ? 0.0 : radio;
    }

    public double getRadio() {
        return m_Radio;
    }

    @Override
    public void dibujar() {
        // TODO: Implementar
    }

    @Override
    public double calcularArea() {
        return Math.pow(m_Radio, 2) * Math.PI; 
    }

    @Override
    public String toString() {
        return super.toString() + String.format("\n-> El radio del círculo es: %.3f", m_Radio);
    }
}
