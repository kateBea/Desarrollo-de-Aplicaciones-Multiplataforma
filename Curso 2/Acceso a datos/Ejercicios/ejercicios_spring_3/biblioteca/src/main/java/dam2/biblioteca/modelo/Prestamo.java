package dam2.biblioteca.modelo;

import java.time.LocalDate;

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
 * Un usuario sólo puede tener un ejemplar en préstamo.
 * 
 * */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "PRESTAMO")
public class Prestamo {
	@EqualsAndHashCode.Include
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	
	@Column(nullable = false)
	private LocalDate fecha;
	
	@Column(nullable = false)
	private boolean devuelto;
	
	// Un usuario sólo puede tener un ejemplar en préstamo
	// Sin embargo, puede tener registrados varios préstamos
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Usuario usuario;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Ejemplar ejemplar;
}
