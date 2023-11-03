package org.dam2.ejer1;

import java.util.List;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class WrapperPersona {
	@Singular
	private List<Persona> personas;

}
