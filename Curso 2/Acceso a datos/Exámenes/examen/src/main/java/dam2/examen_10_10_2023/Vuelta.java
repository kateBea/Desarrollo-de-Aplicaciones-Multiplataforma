package dam2.examen_10_10_2023;

import java.util.List;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Vuelta {
    @NonNull
    @EqualsAndHashCode.Include
    private String nombre;

    private double premio;
    private String director;
    private int etapas;

    @EqualsAndHashCode.Include
    private int anio;

    private List<Equipo> equipos;
}
