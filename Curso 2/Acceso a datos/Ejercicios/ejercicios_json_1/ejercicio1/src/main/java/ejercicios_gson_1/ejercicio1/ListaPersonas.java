package ejercicios_gson_1.ejercicio1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.List;

// Lombok
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

// JAXB
@XmlRootElement(name = "personas")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListaPersonas {
    @XmlElement(name = "persona")
    List<Persona> personas;
}
