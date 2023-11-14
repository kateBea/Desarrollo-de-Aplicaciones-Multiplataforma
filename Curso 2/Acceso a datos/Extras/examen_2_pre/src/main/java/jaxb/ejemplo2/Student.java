package jaxb.ejemplo2;

import lombok.*;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

// Anotaciones XML

// Indica que podría o no ser un elemento raíz.
// Puede no serlo si es parte de una lista por ejemplo.
@XmlRootElement

// Orden en el xml, si no se pone, se ordena alfabéticamente.
@XmlType(propOrder = { "dni", "nombre", "curso", "media", "edad", "asignaturas" })

// Permite poner las anotaciones en los atributos.
// Imprescindible si usamos lombok, ya que lombok no pone las anotaciones JAXB.
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {
    @NonNull // No podemos tener entonces un no args constructor
    @EqualsAndHashCode.Exclude
    private String dni;

    private String nombre;
    private String curso;
    private double media;
    private int edad;


    @XmlElementWrapper(name = "materias")
    @XmlElement(name = "asignatura")
    private List<Asignatura> asignaturas;

    public static double calcularMedia(List<Asignatura> asignaturas) {
        double resultado = -1.0;

        if (!asignaturas.isEmpty()) {
            for (Asignatura asignatura : asignaturas) {
                resultado += asignatura.getNota();
            }

            resultado = resultado / asignaturas.size();
        }
        return resultado;
    }
}
