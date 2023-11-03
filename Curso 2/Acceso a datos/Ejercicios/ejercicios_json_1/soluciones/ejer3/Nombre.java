package org.dam2.ejer3;

import java.time.LocalDateTime;
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

public class Nombre {
	
	@SerializedName("__cdata")
	private String data;

}
