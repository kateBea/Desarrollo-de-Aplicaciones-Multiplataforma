package ejercicio2;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor

@XmlRootElement(name = "recetas")
@XmlAccessorType(XmlAccessType.FIELD)
public class RecetasWrapper {
    @XmlElement(name = "receta")
    private List<Receta> recetas;

    public RecetasWrapper() {
        recetas = new ArrayList<>();
    }
}
