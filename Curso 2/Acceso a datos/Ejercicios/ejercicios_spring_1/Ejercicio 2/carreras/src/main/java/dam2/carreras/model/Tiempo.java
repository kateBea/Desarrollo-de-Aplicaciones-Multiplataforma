package dam2.carreras.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Tiempo requerido por un jugador para realizar una carrera
 * 
 * */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "TIEMPO")
public class Tiempo {
	@Id
	@Column
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	// Tiempo empleado para completar la carrera en segundos
	@Column(nullable = false)
	private float tiempo;
	
	// Tenemos un tiempo por jugador por cada carrera.
	// No podemos tener dos tiempos para un mismo jugador 
	// en una misma carrera.
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private Corredor corredor;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private Carrera carrera;
}
