package pruebas.pruebas_de_nivel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PruebasXMLWrapper {
    @XmlElement(name = "prueba")
    private List<Prueba> pruebas;

    public PruebasXMLWrapper() {
        pruebas = new ArrayList<>();
    }
}
