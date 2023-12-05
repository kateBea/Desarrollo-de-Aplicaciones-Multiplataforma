package dam2.ejercicio2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Grupo {
	private String nombre;
	private String ubicacion;
	private Profesor tutor;
}
