package dam2.instirest.model;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
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
public class Profesor {
	@EqualsAndHashCode.Include
	@Id
	private String nif;
	private String nombre;
	private String despacho;
	private String poblacion;
	private String departamento;
	private LocalDate fechaNacimiento;
	
	// Los emails son únicos por persona, no se comparten
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Email> emails;
	
	@Transient
	private static final int MAX_ESTUDIANTES = 10;
	
	@OneToMany(fetch = FetchType.EAGER)
	private Set<Estudiante> estudiantes;
	
	public static int getMaxEstudiantesPorProfe() {
		return MAX_ESTUDIANTES;
	}
}
