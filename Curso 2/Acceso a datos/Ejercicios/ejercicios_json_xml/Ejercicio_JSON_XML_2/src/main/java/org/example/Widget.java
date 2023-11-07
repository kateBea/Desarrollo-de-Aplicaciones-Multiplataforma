package org.example;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.Data;


@Data

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@XmlType(propOrder = {"debug","window","image","text"})

public class Widget {
	@XmlJavaTypeAdapter(BooleanXMLAdapter.class)
	private Boolean debug;
	private Window window;
	private Image image;
	private Text text;	
}
