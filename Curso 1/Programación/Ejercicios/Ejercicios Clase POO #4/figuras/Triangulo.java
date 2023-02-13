package figuras;

/**
 * <h2>Representa un Triángulo</h2>
 * 
 * Esta clase representa un Triángulo
 * 
 * @author Hugo Pelayo
 * @version 1.0
 */

public final class Triangulo extends Figura {
    // Representa la longitud altura de este triángulo
    private double m_Altura;
    // Representa la longitud base de este triángulo
    private double m_Base;

    public Triangulo(String nombre, ColorType color, double altura, double base) {
        super(nombre, color);
        m_Altura = altura < 0.0 ? 0.0 : altura;
        m_Base = base < 0.0 ? 0.0 : base;
    }

    public Triangulo(String nombre, ColorType color, double coordx, double coordy, double altura, double base) {
        super(nombre, color, coordx, coordy);
        m_Altura = altura < 0.0 ? 0.0 : altura;
        m_Base = base < 0.0 ? 0.0 : base;
    }

    public Triangulo(Triangulo other)  {
        super(other);

        m_Altura = other.getAltura();
        m_Base = other.getBase();
    }

    public double getAltura() {
        return m_Altura;
    }

    public void setAltura(double altura) {
        m_Altura = altura < 0.0 ? m_Altura : altura;
    }

    public double getBase() {
        return m_Base;
    }

    public void setBase(double base) {
        m_Base = base < 0.0 ? 0.0 : base;
    }

    @Override
    public void dibujar() {
        // TODO: Implementar
    }

    @Override
    public double calcularArea() {
        return (m_Base * m_Altura) / 2.0;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("\n-> La altura vale %.3f y la base vale %.3f", m_Altura, m_Base);
    }
}
