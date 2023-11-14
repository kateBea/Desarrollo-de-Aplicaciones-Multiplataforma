package jaxb.ejemplo1;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

// Anotaciones XML

// Indica que podría o no ser un elemento raíz.
// Puede no serlo si es parte de una lista por ejemplo.
@XmlRootElement

// Orden en el xml, si no se pone, se ordena alfabéticamente.
@XmlType(propOrder = { "dni", "nombre", "curso", "media", "edad" })

// Permite poner las anotaciones en los atributos.
// Imprescindible si usamos lombok, ya que lombok no pone las anotaciones JAXB.
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {
    private String dni;
    private String nombre;
    private String curso;
    private double media;
    private int edad;
}
