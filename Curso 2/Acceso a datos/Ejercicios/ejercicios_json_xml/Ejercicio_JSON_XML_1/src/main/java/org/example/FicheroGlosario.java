package org.example;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data

public class FicheroGlosario {
	
	@SerializedName("glossary") 
	private Glossary glos;
	
}
