package dam2.biblioteca.modelo;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "SANCION")
public class Sancion {
	@EqualsAndHashCode.Include
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	
	@Column(nullable = false)
	private LocalDate fechaAlta;
	
	@Column(nullable = false)
	private int dias;
	
	public static int diasPorSancionesAnuales(long sancionesAnuales, int diasSancion) {
		return switch ((int) sancionesAnuales) {
			case 1 -> diasSancion;
			case 2 -> diasSancion * 2;
			default -> diasSancion * 3;
		};
	}
}
