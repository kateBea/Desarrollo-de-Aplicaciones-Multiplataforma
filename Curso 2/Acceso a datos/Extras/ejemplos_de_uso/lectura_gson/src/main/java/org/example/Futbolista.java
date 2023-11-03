package org.example;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Futbolista {
    @NonNull
    @EqualsAndHashCode.Include
    private String dorsal;
    @NonNull
    @EqualsAndHashCode.Include
    private String nombre;

    private String nombreEquipo;

    @Singular
    private List<String> posiciones;
}
