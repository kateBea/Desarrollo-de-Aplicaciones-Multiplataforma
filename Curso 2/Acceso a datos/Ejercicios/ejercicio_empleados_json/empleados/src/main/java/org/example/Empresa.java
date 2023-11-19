package org.example;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor

@XmlType
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Empresa {
    @SerializedName("empresa")
    @XmlAttribute
    private String nombre;

    @XmlElementWrapper(name = "empleados")
    @XmlElement(name = "empleado")
    private List<Empleado> empleados;

    public Empresa() {
        empleados = new ArrayList<>();
    }
}
