package dam2.carreras.model;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Representa un corredor.
 * 
 * NOTA: Ver cabecera de clase Carrera para detalles sobre la relación
 * entre esta entidad y las carreras.
 * */

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
}
