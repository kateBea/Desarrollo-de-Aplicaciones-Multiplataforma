package org.example;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class GlossList {

	@SerializedName("GlossEntry")
	@XmlElement(name="GlossEntry")
	private GlossEntry glossEntry;
	
	
}