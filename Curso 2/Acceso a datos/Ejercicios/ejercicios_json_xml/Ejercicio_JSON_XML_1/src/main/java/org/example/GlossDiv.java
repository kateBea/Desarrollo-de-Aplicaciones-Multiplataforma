package org.example;



import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder= {"title","glossList"})
public class GlossDiv {

	private String title;
	
	@SerializedName("GlossList")
	@XmlElement(name="GlossList")
	private GlossList glossList;
	
}
