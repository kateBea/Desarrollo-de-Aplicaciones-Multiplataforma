package ejemplos_de_uso.ejemplo_flapmap_para_aplanar;

public class AlumnoFP {

	private String nombre;
	private int edad;
	private float nota;
	
	public AlumnoFP ()
	{
		
	}
	
	public AlumnoFP(String nombre, int edad, float nota) {
	
		this.nombre = nombre;
		this.edad = edad;
		this.nota = nota;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "AlumnoFP [nombre=" + nombre + ", edad=" + edad + ", nota=" + nota + "]";
	}
	
	
	
	
}
