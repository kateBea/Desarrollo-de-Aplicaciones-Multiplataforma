package ejercicios_gson_1.ejercicio1;


import lombok.*;

import java.util.List;

// Anotaciones Lombok
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Persona {
    @NonNull
    @EqualsAndHashCode.Include
    private String nombre;

    private double altura;
    private double peso;
    private boolean soltero;
    private List<String> pasatiempos;

    @NonNull
    @EqualsAndHashCode.Include
    private Address address;
}
