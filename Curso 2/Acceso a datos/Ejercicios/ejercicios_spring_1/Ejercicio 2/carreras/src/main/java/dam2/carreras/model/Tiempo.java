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
 * Tiempo requerido por un jugador para realizar una carrera.
 * 
 * Esta entidad nace como consecuencia de una propiedad de la relación
 * entre Corredor y Carrera, ya que es necesario serializar el tiempo
 * del recorrido de un corredor en una carrera.
 * 
 * */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "TIEMPO_RECORRIDO")
public class Tiempo {
	@Id
	@Column
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	// Tiempo empleado para completar la carrera en segundos
	@Column(nullable = false)
	private float tiempo;
	
	// Un corredor puede tener varios tiempos.
	// Lo mismo aplica para las carreras ya que estos tiempos
	// se asigna al corredor por cada carrera.
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private Corredor corredor;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private Carrera carrera;
}
