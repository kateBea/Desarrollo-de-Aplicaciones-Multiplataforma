package figuras;

/**
 * <h2>Representa un Cuadrado</h2>
 * 
 * Esta clase representa un Cuadrado
 * 
 * @author Hugo Pelayo
 * @version 1.0
 */

public final class Cuadrado extends Figura {
    // Representa el lado del cuadrado
    private double m_Lado;

    public Cuadrado(String nombre, ColorType color, double lado) {
        super(nombre, color);
        m_Lado = lado < 0.0 ? 0.0 : lado;
    }

    public Cuadrado(String nombre, ColorType color, double coordx, double coordy, double lado) {
        super(nombre, color, coordx, coordy);
        m_Lado = lado < 0.0 ? 0.0 : lado;
    }

    public Cuadrado(Cuadrado other) {
        super(other);

        m_Lado = other.getLado();
    }

    public void setLado(double lado) {
        m_Lado = lado < 0.0 ? 0.0 : lado;
    }

    public double getLado() {
        return m_Lado;
    }

    @Override
    public void dibujar() {
        // TODO: Implementar
    }

    @Override
    public double calcularArea() {
        return Math.pow(m_Lado, 2);
    }

    @Override
    public String toString() {
        return super.toString() + String.format("\n-> El lado del cuadrado es: %.3f", m_Lado);
    }
}
