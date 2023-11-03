package org.dam2.ejer3;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Localidades {
	
	private List<Localidad> localidad;
	
	public Localidades ()
	{
		localidad = new ArrayList<>();
	}

}
