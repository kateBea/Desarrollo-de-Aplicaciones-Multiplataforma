package dam2.carreras.model;

import java.util.Set;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "CORREDOR")
public class Corredor {
	@NonNull
	@EqualsAndHashCode.Include
	@Id
	@Column(length = 9)
	private String dni;
	
	@Column(nullable = false)
	private Integer dorsal;
	
	@Column(nullable = false, length = 127)
	private String nombre;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	
	@ManyToMany(mappedBy = "corredores", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private Set<Carrera> carreras;
}
