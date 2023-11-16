package pruebas.personas;

import lombok.*;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "nombre", "altura", "peso", "pasatiempos", "soltero", "direccion" })
public class Persona {
    private String nombre;
    private float altura;
    private float peso;

    @XmlElementWrapper
    @XmlElement(name = "pasatiempo")
    private List<String> pasatiempos;

    private boolean soltero;

    private Direccion direccion;

}
