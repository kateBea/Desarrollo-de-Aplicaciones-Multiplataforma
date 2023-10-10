package examen.respuestas;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Contacto {
	private String empresa;
	private String numero;
	private String os;
}

