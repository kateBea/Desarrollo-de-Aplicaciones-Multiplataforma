package ejercicio1;
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

@XmlRootElement(name = "grupos")
@XmlAccessorType(XmlAccessType.FIELD)
public class GrupoWrapper {
	@XmlElement(name = "grupo")
    List<Grupo> grupos;

    public GrupoWrapper() {
        grupos = new ArrayList<>();
    }
    
}
