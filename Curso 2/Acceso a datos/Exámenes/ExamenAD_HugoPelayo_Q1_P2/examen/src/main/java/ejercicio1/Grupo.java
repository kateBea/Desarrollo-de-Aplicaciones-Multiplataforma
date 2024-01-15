package ejercicio1;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class Grupo {
    @NonNull
    @EqualsAndHashCode.Include
    private String id;

    private String nombre;
    private String curso;
    private String itinerario;
    private Tutor tutor;

    @XmlElementWrapper
    @XmlElement(name = "alumno")
    private List<Alumno> alumnos;
    
    public Grupo() {
        alumnos = new ArrayList<>();
    }
}
