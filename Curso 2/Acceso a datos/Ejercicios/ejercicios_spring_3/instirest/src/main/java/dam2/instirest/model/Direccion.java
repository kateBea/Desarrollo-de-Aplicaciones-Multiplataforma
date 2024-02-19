package dam2.instirest.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Embeddable
public class Direccion {
	private String calle;
	private String poblacion;
	private String codigoPostal;
}
