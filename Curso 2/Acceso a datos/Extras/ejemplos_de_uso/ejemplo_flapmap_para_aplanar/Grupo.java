package ejemplos_de_uso.ejemplo_flapmap_para_aplanar;

import java.util.ArrayList;
import java.util.List;

public class Grupo {
	private String nombre;
	private List<AlumnoFP> alumnos;
	
	
	public Grupo ()
	{
		nombre = "";
		alumnos = new ArrayList <AlumnoFP>();
	}
	
	public Grupo (String nombre)
	{
		this.nombre = nombre;
		alumnos = new ArrayList <AlumnoFP>();
	}
	public Grupo(String nombre, List<AlumnoFP> alumnos) {
	
		this.nombre = nombre;
		this.alumnos = alumnos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<AlumnoFP> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<AlumnoFP> alumnos) {
		this.alumnos = alumnos;
	}

	public void addAlumno (AlumnoFP alumno)
	{
		alumnos.add(alumno);
	}
	
	@Override
	public String toString() {
		return "Grupo [nombre=" + nombre + ", alumnos=" + alumnos + "]";
	}
	
	

}
