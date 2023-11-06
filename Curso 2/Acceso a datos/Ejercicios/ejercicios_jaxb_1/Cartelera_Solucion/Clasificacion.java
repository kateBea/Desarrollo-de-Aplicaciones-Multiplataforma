package ejercicios_jaxb_1.Cartelera_Solucion;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@NoArgsConstructor
@AllArgsConstructor
@Data

//usar los atributos de la clase en lugar de los gets
@XmlAccessorType(XmlAccessType.FIELD)
//Elemento xml
@XmlType
public class Clasificacion {
	
	@XmlJavaTypeAdapter(EnumEdadAdapterXML.class)
	@XmlAttribute
	private Edad edad;
	
	// tratar propiedad como texto, no crea etiqueta
	@XmlValue
	private String contenido;
	

}
