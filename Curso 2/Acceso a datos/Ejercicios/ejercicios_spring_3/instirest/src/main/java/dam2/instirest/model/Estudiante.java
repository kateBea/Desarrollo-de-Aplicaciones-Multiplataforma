package dam2.instirest.model;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
public class Estudiante {
	
	@EqualsAndHashCode.Include
	@Id
	private String nif;
	private String nombre;
	private String poblacion;
	private String curso;
	private NivelEstudios grupo;
	private boolean delegado;
	private LocalDate fechaNacimiento;
	
	// Los emails son únicos por persona, no se comparten
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Email> emails;
}
