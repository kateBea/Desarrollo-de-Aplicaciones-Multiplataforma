package pruebas.provincias;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ListaProvincias {
    @SerializedName("lista")
    private Provincias wrapperProvincias;
}
