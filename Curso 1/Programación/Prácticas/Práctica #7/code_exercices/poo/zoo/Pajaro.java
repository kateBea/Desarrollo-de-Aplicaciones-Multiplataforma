package poo.zoo;

public class Pajaro extends Animal {
    private String m_Color;

    public Pajaro(String nombre, String color, int edad) {
        super(nombre, edad);
        m_Color = color;
    }

    public Pajaro(String nombre, String color) {
        super(nombre);
        m_Color = color;
    }

    public Pajaro(Pajaro other) {
        super(other);
        m_Color = other.getColor();
    }
    
    public Pajaro() {
        super();
        m_Color = "Unknown";
    }

    public String getColor() {
        return m_Color;
    }

    public void setColor(String color) {
        if (color != null)
            m_Color = color;
    }
}
