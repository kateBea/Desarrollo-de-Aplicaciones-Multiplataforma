package ejercicios_gson_1.ejercicio1;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

// una dirección se identifica por todos sus atributos
@EqualsAndHashCode(onlyExplicitlyIncluded = false)
public class Address {
    @NonNull
    private String calle;
    @NonNull
    private String numero;
    @NonNull
    private String pais;
}
