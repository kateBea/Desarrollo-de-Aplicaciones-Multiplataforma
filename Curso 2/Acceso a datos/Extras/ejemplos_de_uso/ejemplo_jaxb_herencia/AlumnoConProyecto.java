import javax.xml.bind.annotation.XmlRootElement;

import daw.com.Teclado;
@XmlRootElement
public class AlumnoConProyecto extends Alumno {
	private String proyecto ;
	
	public AlumnoConProyecto ()
	{
		super ();
		proyecto ="";
	}

	public String getProyecto() {
		return proyecto;
	}

	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}

	public void leerDatos ()
	{
		super.leerDatos();
		proyecto = Teclado.leerString("Proyecto :");
	}
	@Override
	public String toString() {
		return "AlumnoConProyecto [proyecto=" + proyecto + ", dni=" + dni + ", nombre=" + nombre + ", modulos="
				+ modulos.toString() + "]";
	}
	
	

}
