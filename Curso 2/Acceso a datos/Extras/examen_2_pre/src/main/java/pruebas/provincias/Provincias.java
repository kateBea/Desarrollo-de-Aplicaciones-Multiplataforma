package pruebas.provincias;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@XmlRootElement(name = "provincias")
@XmlAccessorType(XmlAccessType.FIELD)
public class Provincias {
    @SerializedName("provincia")
    @XmlElement(name = "provincia")
    List<Provincia> provincias;
}
