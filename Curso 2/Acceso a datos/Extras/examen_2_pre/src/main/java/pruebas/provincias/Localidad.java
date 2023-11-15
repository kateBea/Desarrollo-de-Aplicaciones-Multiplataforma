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
public class Localidad {
    @SerializedName("_c")
    @XmlElement(name = "c")
    private String temp;

    @EqualsAndHashCode.Include
    @SerializedName("__cdata")
    @XmlElement(name = "c-data")
    private String cData;

}
