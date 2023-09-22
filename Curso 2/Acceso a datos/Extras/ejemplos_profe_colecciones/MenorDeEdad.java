package ejemplos_profe_colecciones;

import java.util.function.Predicate;

public class MenorDeEdad implements Predicate<Alumno> {

	@Override
	public boolean test(Alumno t) {
		// TODO Auto-generated method stub
		return t.getEdad() < 18;
	}

}
