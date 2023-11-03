package org.dam2.ejer2;

import java.util.Arrays;


import com.google.gson.annotations.SerializedName;

public enum TipoFormacion {
	@SerializedName("Presencial")
	PRESENCIAL {public String toString(){return "Presencial";}},
	@SerializedName("SemiPresencial")
	SEMIPRESENCIAL {public String toString(){return "SemiPresencial";}},
	@SerializedName("NoPresencial")
	NOPRESENCIAL {public String toString(){return "NoPresencial";}};
	
	public static TipoFormacion crearTipoFormacion (String valor)
	{
		
		return Arrays.stream(TipoFormacion.values()).
				filter(a -> a.toString().equals(valor)).
				findFirst().
				orElse(TipoFormacion.PRESENCIAL);
	}
}
