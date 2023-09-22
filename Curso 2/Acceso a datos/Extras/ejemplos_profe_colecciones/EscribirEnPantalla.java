package ejemplos_profe_colecciones;

import java.util.function.Consumer;

public class EscribirEnPantalla implements Consumer<Alumno> {

	@Override
	public void accept(Alumno t) {
		// TODO Auto-generated method stub
		System.out.println(t);
	}

}
