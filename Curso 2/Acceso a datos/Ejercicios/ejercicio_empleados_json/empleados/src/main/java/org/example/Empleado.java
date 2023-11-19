package org.example;

import lombok.*;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@XmlAccessorType(XmlAccessType.FIELD)
public class Empleado {
    @NonNull
    @EqualsAndHashCode.Include
    private String id;
    private String nombre;
    private int edad;
    private String departamento;
    private int salario;

    @XmlElementWrapper
    @XmlElement(name = "proyecto")
    private List<Proyecto> proyectos;

    @XmlElementWrapper
    @XmlList
    private List<String> habilidades;

    public Empleado() {
        proyectos = new ArrayList<>();
        habilidades = new ArrayList<>();
    }
}
