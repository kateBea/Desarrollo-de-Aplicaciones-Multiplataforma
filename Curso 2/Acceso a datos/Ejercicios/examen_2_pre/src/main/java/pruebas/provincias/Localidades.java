package pruebas.provincias;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor

@XmlAccessorType(XmlAccessType.FIELD)
public class Localidades {
    @SerializedName("localidad")
    @XmlElement(name = "localidad")
    List<Localidad> localidades;

    public Localidades() {
        localidades = new ArrayList<>();
    }
}
