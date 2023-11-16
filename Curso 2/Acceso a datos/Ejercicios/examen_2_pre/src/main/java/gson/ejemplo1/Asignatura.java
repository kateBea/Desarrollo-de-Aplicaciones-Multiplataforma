package gson.ejemplo1;

import com.google.gson.annotations.JsonAdapter;
import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

@XmlRootElement
@XmlType(propOrder = { "nombre", "nota" })
@XmlAccessorType(XmlAccessType.FIELD)

public class Asignatura {
    private String nombre;
    private double nota;
}
