package pruebas.pruebas_de_nivel;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@XmlAccessorType(XmlAccessType.FIELD)
public class Profesor {
    @SerializedName("$id")
    @XmlElement(name = "id")
    private String objectId;

    @XmlElement(name = "nombre-completo")
    @SerializedName("NombreCompleto")
    private String nombreCompleto;
}
