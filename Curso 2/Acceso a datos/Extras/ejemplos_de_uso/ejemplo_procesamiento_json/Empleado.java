package ejemplos_de_uso.ejemplo_procesamiento_json;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder


public class Empleado {
	private String id;
	private String nombre;
	private String dept;
	private float sueldo;

}
