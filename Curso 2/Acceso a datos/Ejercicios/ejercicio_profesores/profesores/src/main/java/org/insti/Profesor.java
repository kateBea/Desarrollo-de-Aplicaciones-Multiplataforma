package org.insti;

import lombok.*;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@XmlType(propOrder = { "id", "nombre", "edad", "materia", "cursos" })
@XmlAccessorType(XmlAccessType.FIELD)
public class Profesor {
    @NonNull
    @EqualsAndHashCode.Include
    @XmlAttribute
    private int id;

    private String nombre;
    private int edad;
    private String materia;

    @XmlElementWrapper(name = "cursos")
    @XmlElement(name = "curso")
    private List<Curso> cursos;

    public Profesor() {
        cursos = new ArrayList<>();
    }
}
