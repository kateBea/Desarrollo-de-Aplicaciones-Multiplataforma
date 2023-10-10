package repaso_examen1.solucion_profe;

import java.util.Set;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Singular;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded=true)
@Builder
public class Instituto {
	@NonNull
	@EqualsAndHashCode.Include
	private String codigo;
	
	private String nombre;
	private String telefono;
	private float presupuesto;
	
	@Singular
	private Set<Persona> personas;

}
