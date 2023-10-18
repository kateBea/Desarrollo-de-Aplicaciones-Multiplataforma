package dam2.examen_10_10_2023;

import java.util.List;
import java.util.Optional;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Equipo {
    @NonNull
    @EqualsAndHashCode.Include
    private String nombre;

    private List<Corredor> corredores;

    private Optional<Patrocinador> patrocinador;
}
