package org.dam2.ejer2;



import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class Profesor {
	@SerializedName("$id")
	private String id;
	@SerializedName("NombreCompleto")
	private String nombre;

}
