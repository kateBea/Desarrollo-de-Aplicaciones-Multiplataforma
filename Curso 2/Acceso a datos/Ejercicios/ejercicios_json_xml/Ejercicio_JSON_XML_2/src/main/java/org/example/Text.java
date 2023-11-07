package org.example;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded=true)

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"name","hOffset","vOffset","alignment","onMouseUp"})
public class Text {
	@XmlAttribute
	private String data;
	@XmlAttribute
	private int size;
	@XmlAttribute
	@XmlJavaTypeAdapter(StyleXmlAdapter.class)
	private Style style;
	@EqualsAndHashCode.Include
	private String name;
	private int hOffset;
	private int vOffset;
	@XmlJavaTypeAdapter(AlignmentXMLAdapter.class)
	private Alignment alignment;
	private String onMouseUp;
	
}
