package org.insti;

import lombok.*;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@XmlType(propOrder = { "id", "nombre", "estudiantes" })
@XmlAccessorType(XmlAccessType.FIELD)
public class Curso {
    @NonNull
    @EqualsAndHashCode.Include
    @XmlAttribute
    private int id;

    @NonNull
    @EqualsAndHashCode.Include
    @XmlAttribute
    private String nombre;

    @XmlElementWrapper(name = "estudiantes")
    @XmlElement(name = "estudiante")
    private List<Estudiante> estudiantes;

    public Curso() {
        estudiantes = new ArrayList<>();
    }
}
