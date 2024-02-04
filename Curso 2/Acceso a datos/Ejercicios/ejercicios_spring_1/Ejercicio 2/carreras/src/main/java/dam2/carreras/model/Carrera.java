package dam2.carreras.model;

import java.time.LocalDateTime;
import java.util.Set;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name = "CARRERA")

/**
 * 
 * 
 * */
public class Carrera {
	@NonNull
	@EqualsAndHashCode.Include
	@Id
	@Column(nullable = false, length = 127)
	private String nombre;
	
	@Column(name = "max_corredores", nullable = false)
	private int maxCorredores;
	
	@Column(name = "fecha_celebracion",nullable = false)
	private LocalDateTime fechaCelebracion;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "punto_control")
	private Set<PuntoControl> puntosControl;
	
	// Un corredor puede estar en una o varias carreras a la vez
	// Si la hacemos OneToMany quiere decir de todas nuestras carreras,
	// un corredor sólo puede estar en una. En esta relación se considera 
	// el jugador como la entidad débil y carrera como entidad fuerte.
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinTable(
		name = "CORREDORE_ADSCRITO",
		joinColumns = { @JoinColumn(name = "nombre_carrera", nullable = false) },
		inverseJoinColumns = { @JoinColumn(name = "nombre_corredor", nullable = false) }
	)
	private Set<Corredor> corredores;
}
