package org.example;

import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded=true)

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"hOffset","vOffset","alignment"})
public class Image {
	@XmlAttribute
	private String src;
	@EqualsAndHashCode.Include
	@XmlAttribute
	private String name;
	private int hOffset;
	private int vOffset;
	@XmlJavaTypeAdapter(AlignmentXMLAdapter.class)
	private Alignment alignment;
}
