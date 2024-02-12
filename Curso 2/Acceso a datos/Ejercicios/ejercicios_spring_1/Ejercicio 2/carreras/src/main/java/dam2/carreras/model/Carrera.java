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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Representa una carrera con todos sus corredores.
 * En este modelo se ha considerado la relación entre carreras 
 * y corredores donde corredor es la entidad débil y carrera
 * es una entidad fuerte. La relación se establece como muchos a
 * muchos ya que un corredor puede estar en varias carreras a la vez
 * y lo mismo para una carrera.
 * 
 * */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "CARRERA")

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
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "punto_control")
	private Set<PuntoControl> puntosControl;
}
