package examen.respuestas;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;

@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
	@ToString.Include
	private String nombre;
	
	@NonNull
	@ToString.Include
	@EqualsAndHashCode.Include
	private String nif;
	
	@ToString.Include
	private LocalDate fechaNacimiento;
	
	private Contacto contacto;
	private Optional<Vehiculo> vehiculo;
}
