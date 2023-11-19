package org.insti;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "instituto", "profesores" })
public class Instituto {
    private String instituto;

    @XmlElementWrapper
    @XmlElement(name = "profesor")
    private List<Profesor> profesores;

    public Instituto() {
        profesores = new ArrayList<>();
    }
}
