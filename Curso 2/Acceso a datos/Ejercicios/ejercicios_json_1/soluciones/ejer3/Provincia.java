package org.dam2.ejer3;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded=true)

public class Provincia {
	private Nombre nombre;
	private Localidades localidades;
	@EqualsAndHashCode.Include
	@SerializedName("_id")
	private String id;
	
	
}
