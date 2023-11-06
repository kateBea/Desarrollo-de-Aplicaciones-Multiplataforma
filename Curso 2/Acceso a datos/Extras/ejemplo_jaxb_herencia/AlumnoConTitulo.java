import javax.xml.bind.annotation.XmlRootElement;

import daw.com.Teclado;


@XmlRootElement
public class AlumnoConTitulo extends Alumno {
	private float notaFinal;

	public AlumnoConTitulo() {
		super();
		this.notaFinal = 0;
	}

	public float getNotaFinal() {
		return notaFinal;
	}

	public void setNotaFinal(float notaFinal) {
		this.notaFinal = notaFinal;
	}

	public void leerDatos ()
	{
		super.leerDatos();
		notaFinal = Teclado.leerFloat("nota final: ");
	}
	@Override
	public String toString() {
		return "AlumnoConTitulo [notaFinal=" + notaFinal + ", dni=" + dni + ", nombre=" + nombre + ", modulos="
				+ modulos.toString() + "]";
	}
	
	
	

}
