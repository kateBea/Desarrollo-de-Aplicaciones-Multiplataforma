package dam2.carreras.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Por simplicidad los puntos de control son únicos por carrera.
 * Todos gaurdan quien es el corredor que ha llegado por primera vez
 * y sólo habrá uno por carrera. El jugador debe existir.
 * 
 * NOTA: Probablemente no sea necesario serializar
 * a la base de datos y marcar este objeto como un 
 * Embeddable para carrera.
 * */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "PUNTO_DE_CONTROL")

public class PuntoControl {
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "punto_kilometrico", nullable = false)
	private float puntoKilometrico;
	
	@Column(name = "nombre_juez", nullable = false, length = 127)
	private String nombreJuez;
	
	// Tiempo requerido por el corredor para 
	// llegar a este punto de control
	@Column(name = "tiempo_llegada", nullable = false)
	private float tiempoLlegada;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "primer_corredor")
	private Corredor primerCorredor;
}
