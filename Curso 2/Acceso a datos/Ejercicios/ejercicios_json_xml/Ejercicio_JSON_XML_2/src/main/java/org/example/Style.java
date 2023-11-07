package org.example;

import java.util.Arrays;

import com.google.gson.annotations.SerializedName;

public enum Style {
	@SerializedName("bold")
	BOLD {public String toString(){return "bold";}},
	@SerializedName("italic")
	ITALIC {public String toString(){return "italic";}},
	@SerializedName("small-caps")
	SMALLCAPS {public String toString(){return "small-caps";}},
	@SerializedName("none")
	NONE {public String toString(){return "none";}};
	
	public static Style crearStyle (String v)
	{
		return Arrays.stream(Style.values()).
				filter(s -> s.toString().equals(v)).
				findFirst().
				orElse(Style.NONE);
	}
}
