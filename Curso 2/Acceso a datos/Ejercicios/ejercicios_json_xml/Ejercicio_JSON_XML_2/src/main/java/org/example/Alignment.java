package org.example;

import java.util.Arrays;

import com.google.gson.annotations.SerializedName;

public enum Alignment {
	@SerializedName("center")
	CENTER {public String toString(){return "center";}},
	@SerializedName("right")
	RIGHT {public String toString(){return "rigth";}},
	@SerializedName("left")
	LEFT {public String toString(){return "left";}},
	@SerializedName("justify")
	JUSTIFY {public String toString(){return "justify";}};
	
	public static Alignment crearAlignment (String valor)
	{
		return Arrays.stream(Alignment.values()).
				filter(a -> a.toString().equals(valor)).
				findFirst().
				orElse(Alignment.LEFT);
	}
}
