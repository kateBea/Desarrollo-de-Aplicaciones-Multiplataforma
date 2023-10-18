package dam2.examen_10_10_2023;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Corredor {
    @NonNull
    @EqualsAndHashCode.Include
    private String dni;

    private String nombre;
    private LocalDate birthday;
    private boolean profesional;
}
