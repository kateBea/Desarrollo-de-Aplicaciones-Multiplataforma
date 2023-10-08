package examen.respuestas;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class Instituto {
	private String nombre;
	
	@NonNull
	@EqualsAndHashCode.Include
	private String codigo;
	
	private String telefono;
	private double presupuesto;
	
	@Singular
	private List<Persona> personas;
}
