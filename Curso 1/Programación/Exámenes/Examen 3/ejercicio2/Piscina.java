package ejercicio2;

import java.io.Serializable;

public class Piscina implements Serializable {
    private static final int MIN = 25000;
    private static final int MAX = 50000;
    private int NIVEL_MAXIMO;
    private int nivel;

    public Piscina(int maxLitros) {
        if (maxLitros > getMax())
            throw new NivelPiscinaException("Valor supera lo máximo posible");

        if (maxLitros < 0)
            throw new NivelPiscinaException("No se puede introducir una cantidad negativa");
            
        NIVEL_MAXIMO = maxLitros;
        nivel = 0;
    }

    public int getNivelActual() {
        return this.nivel;
    }

    public int getMaxNivel() {
        return NIVEL_MAXIMO;
    }

    public static int getMax() {
        return MAX;
    }

    public static int getMin() {
        return MIN;
    }

    public void cambiarNivelActual(int nivel) {
        this.nivel = nivel;
    }

    public void vaciar(int cantidad) {
        if (cantidad < 0)
            throw new NivelPiscinaException("No se puede introducir una cantidad negativa");

        if (cantidad > getNivelActual())
            throw new NivelPiscinaException("Error: No hay agua suficiente");

        cambiarNivelActual(getNivelActual() - cantidad);

    }

    public void rellenar(int cantidad) {
        if (cantidad < 0)
            throw new NivelPiscinaException("Error: No se puede rellenar la piscina con números negativos");

        if (cantidad > getMaxNivel())
            throw new NivelPiscinaException("No se puede rellenar porque el agua se desborda");

        cambiarNivelActual(getNivelActual() + cantidad);
    }

    @Override
    public String toString() {
        return String.format("Piscina [nivel=%d, NIVEL_MAXIMO=%d, MIN=%d, MAX=%d]",
                getNivelActual(), getMaxNivel(), getMin(), getMax());
    }

}
