package ejemplos_de_uso.ejemplos_basicos_profe_ad;

import java.util.function.Predicate;

public class Aprobado implements Predicate<Alumno> {

	@Override
	public boolean test(Alumno arg0) {
		// TODO Auto-generated method stub
		return arg0.getNota()>= 5;
	}

}
