package repaso_examen1.solucion_profe;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Vehiculo {
	@EqualsAndHashCode.Include
	@NonNull
	private String matricula;
	private String modelo;
	private String color;

}
