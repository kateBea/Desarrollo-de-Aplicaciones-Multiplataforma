package poo;

public abstract class Animal {
    private String m_Nombre;

    public Animal(String nombre) {
        m_Nombre = nombre == null ? "Desconocido" : nombre;
    }

    public String getNombre() { return m_Nombre; }

    public void setNombre(String nombre) { m_Nombre = nombre == null ? "Desconocido" : nombre; }

    public abstract void greet();

    public void presentar() {
        greet();
        System.out.println(" Me llamo " + getNombre());
    }

}
