package ejercicios_basicos_2;

import java.util.Random;

public class Producto {
    private int referencia;
    private double precio;
    private boolean perecedero;

    private static Random rand = new Random();

    public Producto(double precio, boolean perecedero) {
        this.precio = precio;
        this.perecedero = perecedero;

        this.referencia = (int)(rand.nextDouble() * 10000);
    }

    public int getReferencia() {
        return referencia;
    }

    public void setReferencia(int referencia) {
        this.referencia = referencia;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio > 0)
            this.precio = precio;
    }

    public boolean isPerecedero() {
        return perecedero;
    }

    public void setPerecedero(boolean perecedero) {
        this.perecedero = perecedero;
    }

    @Override
    public String toString() {
        return String.format("Referencia: %d\nPrecio: %.3f\nPerecedero: %s", referencia, precio, perecedero ? "Sí" : "No");
    }
}
