package ejercicio1;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlValue;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor

@XmlAccessorType(XmlAccessType.FIELD)
public class Notas {
    @XmlList
    @XmlValue
    List<Double> notas;

    public Notas() {
        notas = new ArrayList<>();
    }

    public boolean algunaSuspendida() {
        final double APROBADO = 5.0; 
        return notas.stream().anyMatch(nota -> nota < APROBADO);
    } 
}
