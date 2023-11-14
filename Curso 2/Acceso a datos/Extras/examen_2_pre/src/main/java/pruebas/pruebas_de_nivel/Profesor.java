package pruebas.pruebas_de_nivel;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Profesor {
    @SerializedName("$id")
    private String objectId;

    @SerializedName("NombreCompleto")
    private String nombreCompleto;
}
