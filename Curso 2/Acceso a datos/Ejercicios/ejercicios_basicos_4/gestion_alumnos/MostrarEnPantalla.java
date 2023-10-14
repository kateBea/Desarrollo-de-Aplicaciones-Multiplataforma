package interfacesFuncionales;

import java.util.function.Consumer;

import daw.com.Pantalla;

public class MostrarEnPantalla implements Consumer<Alumno> {

	@Override
	public void accept(Alumno t) {
		// TODO Auto-generated method stub
		Pantalla.escribirString("\n" + t);

	}

}
