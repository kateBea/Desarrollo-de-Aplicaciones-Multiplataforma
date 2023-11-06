import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Alumnos {
	
	
	private ArrayList <Alumno> alumnos;

	public Alumnos() {
		alumnos = new ArrayList<>();
	}
	
	//@XmlElement(name="alumno")
	@XmlElements({
	    @XmlElement(name = "alumnoConProyecto", type = AlumnoConProyecto.class),
	    @XmlElement(name = "alumnoConTitulo", type = AlumnoConTitulo.class)})
	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	
}
