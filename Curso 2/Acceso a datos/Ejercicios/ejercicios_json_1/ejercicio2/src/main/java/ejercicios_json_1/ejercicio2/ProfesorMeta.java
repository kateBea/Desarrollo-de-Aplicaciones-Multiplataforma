package ejercicios_json_1.ejercicio2;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ProfesorMeta {
    private String objectId;
    private String nombreCompleto;
}
