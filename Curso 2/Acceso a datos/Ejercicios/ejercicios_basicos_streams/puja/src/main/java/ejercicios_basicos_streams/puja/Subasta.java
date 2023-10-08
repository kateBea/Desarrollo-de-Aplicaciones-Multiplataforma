package ejercicios_basicos_streams.puja;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

/**
 * Define una subasta en un sistema de subastas. Todas las 
 * propiedades son consultables. La clase ofrece ciertas funcionalidades.
 * */
@Getter
@ToString(onlyExplicitlyIncluded = true)
public class Subasta {
    @ToString.Include
    private final String nombreProducto;

    private final Usuario propietario;
    @ToString.Include
    private boolean abierta;
    @Singular
    private List<Puja> pujas;
    private Optional<Puja> pujaMayor;   

    public Subasta(String nombreProducto, Usuario propietario) {
        this.nombreProducto = nombreProducto;
        this.propietario = propietario;

        // Una subasta recién construida está abierta y no tiene pujas
        this.abierta = true;
        this.pujas = new LinkedList<>();
        pujaMayor = Optional.empty();
    }

    /**
     * Retorna cierto si la puja del pujador ha sido aceptada,
     * retorna falso en cualquier otro caso.
     * */
    public boolean pujar(Usuario pujador) {
        return pujar(pujador, this.pujaMayor.map(puja -> puja.getCantidad() + 1.0).orElse(1.0));
    }

    /**
     * Retorna cierto si la puja del pujador ha sido aceptada,
     * retorna falso en cualquier otro caso.
     * */
    public boolean pujar(Usuario pujador, double cantidad) {
        if (!isAbierta()) {
            return false;
        }

        boolean aceptada = false;

        // propietario no es pujador
        aceptada = !this.propietario.equals(pujador) && pujador.getCredito() >= cantidad;

        // cantidad mayor que la de puja mayor
        if (this.pujaMayor.isPresent()) {
            aceptada = aceptada && this.pujaMayor.get().getCantidad() < cantidad;
        }
        else {
            // Cuando añadimos puja por primera vez
            this.pujaMayor = Optional.of(Puja.builder().usuario(pujador).subasta(this).cantidad(cantidad).build());
        }
        
        // actualizamos puja mayor y añadimos nueva puja
        if (aceptada) {
            this.pujaMayor = Optional.of(Puja.builder().usuario(pujador).subasta(this).cantidad(cantidad).build());
            this.pujas.add(pujaMayor.get());
        }

        return aceptada;
    }

    public boolean ejecutar() {
        if (this.pujaMayor.isEmpty() || !this.abierta) {
            return false;
        }

        this.propietario.incrementarCredito(pujaMayor.get().getCantidad());
        pujaMayor.get().getUsuario().decrementarCredito(pujaMayor.get().getCantidad());
        this.abierta = false;

        return true;
    }

}
