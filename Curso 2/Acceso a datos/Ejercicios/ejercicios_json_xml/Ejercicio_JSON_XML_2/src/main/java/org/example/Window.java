package org.example;



import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded=true)

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"name","width","height"})

public class Window {
	@EqualsAndHashCode.Include
	@XmlAttribute
	private String title;
	private String name;
	private int width;
	private int height;
	
		
}
