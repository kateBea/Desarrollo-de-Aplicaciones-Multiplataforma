package repaso_examen1.solucion_profe;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Singular;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded=true)
public class Persona {
	@EqualsAndHashCode.Include
	private String nif;
	private String nombre;
	private LocalDate fechaNacimiento;
	@Builder.Default
	private Optional<Vehiculo> vehiculo=Optional.empty();
	@Singular
	List<Contacto> contactos;
	
	

}
