package ejercicios_gson_1.ejercicio1;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

// una dirección se identifica por todos sus atributos
@EqualsAndHashCode

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Address {
    @NonNull
    @XmlElement
    private String calle;
    @NonNull
    @XmlElement
    private String numero;
    @NonNull
    @XmlElement
    private String pais;
}
