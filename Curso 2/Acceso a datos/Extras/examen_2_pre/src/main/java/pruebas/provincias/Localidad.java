package pruebas.provincias;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Localidad {
    @SerializedName("_c")
    private String temp;

    @EqualsAndHashCode.Include
    @SerializedName("__cdata")
    private String cData;

}
