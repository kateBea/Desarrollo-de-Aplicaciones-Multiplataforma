package ejercicio2;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.google.gson.annotations.JsonAdapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)

public class Receta {
	@XmlElement
    private Tipo tipo;

    @XmlJavaTypeAdapter(DificultadAdapterXML.class)
    @JsonAdapter(DificultadAdapterJSON.class)
    @XmlElement
    private Dificultad dificultad;

    @XmlElement
    private String nombre;

    @XmlElementWrapper(name = "ingredientes")
    @XmlElement(name = "ingrediente")
	private List<Ingrediente> ingredientes;


    @XmlElement
    private int calorias;

    @XmlElementWrapper
    @XmlElement(name = "paso")
    private List<Paso> pasos;

    @XmlElement
    private Tiempo tiempo;

    public Receta() {
        pasos = new ArrayList<>();
        ingredientes = new ArrayList<>();
    }   
}
