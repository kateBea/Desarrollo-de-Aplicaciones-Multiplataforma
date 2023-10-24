package ejemplos_de_uso.ejemplos_basicos_profe_ad;

import java.util.Comparator;

public class ComparadorPorNota implements Comparator<Alumno> {

	@Override
	public int compare(Alumno arg0, Alumno arg1) {
		// TODO Auto-generated method stub
		return Float.compare(arg0.getNota(), arg1.getNota());
	}

}
