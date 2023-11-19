package ejercicio1;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

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
@XmlType(propOrder = { "dni", "nombre", "apellido1", "apellido2", "alta", "direccion" })
public class Tutor {
    @NonNull
    @EqualsAndHashCode.Include
    private String dni;

    private String nombre;
    private String apellido1;
    private String apellido2;

    @JsonAdapter(AltaAdapterJSON.class)
    @XmlJavaTypeAdapter(AltaAdapterXML.class)
    private LocalDate alta;
    
    private Direccion direccion;
    
}
