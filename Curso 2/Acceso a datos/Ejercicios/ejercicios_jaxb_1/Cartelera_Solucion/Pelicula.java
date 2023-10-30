package dam2.org.cartelera;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded=true)


// usar los atributos de la clase en lugar de los gets
@XmlAccessorType(XmlAccessType.FIELD)
//Elemento xml
@XmlType(propOrder= {"titulo", "tituloOriginal", 
				"nacionalidad", "genero","clasificacion","sinopsis",
				"director", "actores", "web", "cartel"})
public class Pelicula {
	
	@EqualsAndHashCode.Include
	@NonNull
	@XmlAttribute
	private String codigo;
	
	@XmlAttribute
	private int duracion;
	
	@XmlAttribute
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	private LocalDate  fecha;
	
	private String titulo;
	
	@XmlElement(name="titulo_original")
	private String tituloOriginal;
	
	private String nacionalidad;
	
	@XmlJavaTypeAdapter(EnumGeneroDateAdapterXML.class)
	private Genero genero;
	
	private Clasificacion clasificacion;
	
	private String sinopsis;
	
	private String director;
	
	@Singular("actor")
	// Contendor
	@XmlElementWrapper(name="reparto")
	// Elementos del contenedor
	@XmlElement(name="actor")
	private List<String> actores;
	
	private String web;
	
	private String cartel;
	
}
