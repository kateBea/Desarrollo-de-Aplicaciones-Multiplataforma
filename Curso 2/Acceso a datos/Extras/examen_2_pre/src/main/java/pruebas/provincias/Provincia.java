package pruebas.provincias;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import javax.xml.bind.annotation.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@XmlAccessorType(XmlAccessType.FIELD)
public class Provincia {
    @XmlElement(name = "nombre")
    private Nombre nombre;

    @XmlElement(name = "localidades")
    private Localidades localidades;

    @SerializedName("_id")
    @EqualsAndHashCode.Include
    @XmlElement(name = "id")
    private String id;
}
