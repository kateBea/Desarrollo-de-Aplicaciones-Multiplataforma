package org.example;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder= {"para","glossSeeAlso"})
public class GlossDef {

	String para;
	
	@SerializedName("GlossSeeAlso")
	@XmlElement(name="GlossSeeAlso")
	List<String> glossSeeAlso;
}
