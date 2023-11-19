package org.example;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@XmlAccessorType(XmlAccessType.FIELD)
public class Pais {
    @EqualsAndHashCode.Include
    private String nombre;

    @EqualsAndHashCode.Include
    private String continente;

    private String capital;

    @XmlElement(name = "")
    private String textoCapital;

    @XmlElementWrapper(name = "ciudades-importantes")
    @XmlElement(name = "ciudad")
    private List<String> ciudadImportante;

    public Pais() {
        ciudadImportante = new ArrayList<>();
    }
}
