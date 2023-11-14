package pruebas.provincias;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class Localidades {
    @SerializedName("localidad")
    List<Localidad> localidades;

    public Localidades() {
        localidades = new ArrayList<>();
    }
}
