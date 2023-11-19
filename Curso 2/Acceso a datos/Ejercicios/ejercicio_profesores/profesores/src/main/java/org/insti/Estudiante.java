package org.insti;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

@XmlType(propOrder = { "id", "nombre" })
@XmlAccessorType(XmlAccessType.FIELD)
public class Estudiante {
    private int id;
    private String nombre;
}
