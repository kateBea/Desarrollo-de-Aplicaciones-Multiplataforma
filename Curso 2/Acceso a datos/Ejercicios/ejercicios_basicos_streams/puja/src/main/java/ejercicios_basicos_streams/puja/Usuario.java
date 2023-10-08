package ejercicios_basicos_streams.puja;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Definición de la clase Usuario de un sistema de subastas.
 * Todas las propiedades son consultables y se ofrecen operaciones
 * de incremento y decremento del crédito.
 * */
@Getter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario {
    @EqualsAndHashCode.Include
    private final String nombre;
    private double credito;

    private static final double CREDITO_INICIAL = 50.0;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.credito = CREDITO_INICIAL;
    }

    public Usuario(String nombre, double credito) {
        this.nombre = nombre;
        this.credito = credito;
    }

    public void incrementarCredito(double valor) {
        if (valor > 0.0) {
            this.credito += valor;
        }
    }

    public void decrementarCredito(double valor) {
        if (this.credito >= valor) {
            this.credito -= valor;
        }
    }
}
