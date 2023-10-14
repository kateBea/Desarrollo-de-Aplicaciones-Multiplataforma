package interfacesFuncionales;

import java.io.PrintWriter;
import java.util.function.Consumer;

public class EscribirEnFicheroCSV implements Consumer<Alumno> {
	
	private PrintWriter fichero;
	
	public EscribirEnFicheroCSV (PrintWriter fichero)
	{
		this.fichero = fichero;
	}

	@Override
	public void accept(Alumno t) {
		// TODO Auto-generated method stub
		fichero.print(t.toCSV());

	}

}
