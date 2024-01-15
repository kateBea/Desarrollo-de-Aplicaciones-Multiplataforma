package ejercicio1;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import com.google.gson.annotations.JsonAdapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@XmlAccessorType(XmlAccessType.FIELD)
public class Alumno {
    @NonNull
    @EqualsAndHashCode.Include
    private String dni;

    private String nombre;
    private String apellido1;
    private String apellido2;
    private int edad;
    private String repetidor;

    @JsonAdapter(NotasAdapterJSON.class)
    private Notas notas;
}
