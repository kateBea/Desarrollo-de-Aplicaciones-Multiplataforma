package pruebas.provincias;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Provincia {
    private Nombre nombre;

    private Localidades localidades;

    @SerializedName("_id")
    @EqualsAndHashCode.Include
    private String id;
}
