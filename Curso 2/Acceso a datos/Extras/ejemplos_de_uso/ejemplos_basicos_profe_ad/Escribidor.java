package ejemplos_de_uso.ejemplos_basicos_profe_ad;

import java.util.function.Consumer;

public class Escribidor implements Consumer<Alumno> {

	@Override
	public void accept(Alumno arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0);
		
	}

}
