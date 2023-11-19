package ejercicio2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class Ingrediente {
    @XmlAttribute
    private String nombre;

    @XmlAttribute
    private String cantidad;
}
