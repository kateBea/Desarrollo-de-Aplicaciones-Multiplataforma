package interfacesFuncionales;

import java.util.function.Predicate;

public class Aprobado implements Predicate<Alumno> {

	@Override
	public boolean test(Alumno t) {
		// TODO Auto-generated method stub
		return t.estaAprobado();
	}

}
