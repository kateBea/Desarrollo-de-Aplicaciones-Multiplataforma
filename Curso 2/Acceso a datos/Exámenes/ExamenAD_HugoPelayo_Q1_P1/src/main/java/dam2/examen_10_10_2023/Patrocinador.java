package dam2.examen_10_10_2023;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Patrocinador {
    @NonNull
    @EqualsAndHashCode.Include
    private String nombre;

    @NonNull
    @EqualsAndHashCode.Include
    private String nacionalidad;
    
    private double donacion;
}
