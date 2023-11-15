package pruebas.personas;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Direccion {
    private String calle;
    private int numero;
    private String pais;
}
