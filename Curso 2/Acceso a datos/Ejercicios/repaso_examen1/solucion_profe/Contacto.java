package repaso_examen1.solucion_profe;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Contacto {
	private String empresa;
	private String numero;
	private String os;

}
