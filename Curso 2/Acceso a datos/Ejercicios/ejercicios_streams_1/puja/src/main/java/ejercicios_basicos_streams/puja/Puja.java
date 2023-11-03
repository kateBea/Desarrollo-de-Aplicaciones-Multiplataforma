package ejercicios_basicos_streams.puja;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/***
 * Definición de la clase Puja. Todas las propiedades son 
 * consultables, pero no modificables. La clase no ofrece
 * constructores. Se crean los objetos mediante el método
 * estático builder.
 * */
@Getter
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = false)
@ToString(onlyExplicitlyIncluded = false)
public class Puja {
    @NonNull
    private Usuario usuario;
    private Subasta subasta;
    private double cantidad;
}
