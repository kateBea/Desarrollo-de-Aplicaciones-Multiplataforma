package pruebas.personas;


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
public class Personas {
    @XmlElement(name = "persona")
    List<Persona> personas;

    public Personas() {
        personas = new ArrayList<>();
    }
}
