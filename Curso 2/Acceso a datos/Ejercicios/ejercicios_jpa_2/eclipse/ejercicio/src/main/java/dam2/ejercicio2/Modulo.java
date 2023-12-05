package dam2.ejercicio2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Modulo {
	private String id;
	private String nombre;
	private Profesor profesor;
}
