package ejercicios_gson_1.ejercicio1;


import lombok.*;

import javax.xml.bind.annotation.*;
import java.util.List;

// Anotaciones Lombok
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Persona {
    @NonNull
    @EqualsAndHashCode.Include
    @XmlElement
    private String nombre;

    @XmlElement
    private double altura;

    @XmlElement
    private double peso;

    @XmlElement
    private boolean soltero;

    @XmlElementWrapper(name = "pasatiempos")
    @XmlElement(name = "pasatiempo")
    private List<String> pasatiempos;

    @NonNull
    @EqualsAndHashCode.Include
    @XmlElement
    private Address address;
}
