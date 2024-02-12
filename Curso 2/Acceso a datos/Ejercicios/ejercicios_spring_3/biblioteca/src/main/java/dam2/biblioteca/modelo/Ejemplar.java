package dam2.biblioteca.modelo;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
@Table(name = "EJEMPLAR")
public class Ejemplar {
	@NonNull
	@EqualsAndHashCode.Include
	@Id
	@Column(name = "num_registro")
	private String numRegistro;
	
	@Column(name = "dias_prestamo", nullable = false)
	private int diasPrestamo;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Estado estado;
	
	
	// Podemos tener varios ejemplares de un mismo libro en nuestra biblioteca
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Libro libro;
}
