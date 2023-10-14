package interfacesFuncionales;

import java.util.Comparator;

public class ComparadorPorNombre implements Comparator<Alumno> {

	@Override
	public int compare(Alumno o1, Alumno o2) {
		// TODO Auto-generated method stub
		return o1.getNombre().compareToIgnoreCase(o2.getNombre());
	}

}
