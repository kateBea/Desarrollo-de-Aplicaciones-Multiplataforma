package org.example;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@XmlType(propOrder= {"title", "glossDiv"})
public class Glossary {

	private String title;
	
	@SerializedName("GlossDiv") 
	@XmlElement(name="GlossDiv")
	private GlossDiv glossDiv;

}
