package ejemplos_de_uso.ejemplos_basicos_profe_ad;



import java.time.LocalDate;
import java.util.Objects;

import daw.com.Teclado;

public class Alumno implements Comparable <Alumno>{
	private String nia;
	private String nombre;
	private LocalDate fechaNacimiento;
	private float nota;
	

	
	public Alumno ()
	{
		this ("");
	}
	
	public Alumno(String nia, String nobmre, LocalDate fechaNacimiento, float nota) {

		this.nia = nia;
		this.nombre = nobmre;
		setFechaNacimiento(fechaNacimiento);
		setNota (nota);
	}
	
	public Alumno (String nia)
	{
		this (nia,"", LocalDate.now(),1);
		
	}



	public String getNia() {
		return nia;
	}

	public void setNia(String nia) {
		this.nia = nia;
	}

	public String getNobmre() {
		return nombre;
	}

	public void setNobmre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		
		if (fechaNacimiento.isAfter(LocalDate.now()))
			fechaNacimiento = LocalDate.now();
		
		this.fechaNacimiento = fechaNacimiento;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		if (nota < 1 || nota > 10)
			nota = 1;
		
		this.nota = nota;
	}





	@Override
	public int hashCode() {
		System.out.println("ejecutando hashCode...");
		return Objects.hash(nia);
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("ejecutando equals...");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(nia, other.nia);
	}

	@Override
	public int compareTo(Alumno o) {
		System.out.println("ejecutando compareTo... " + nia + "-" + o.nia);
		return nia.compareTo(o.nia);
	}
	
	public void leerDatos ()
	{
		leerClave ();
		leerOtrosDatos ();
	}

	public void leerOtrosDatos() {
		nombre = Teclado.leerString("nombre");
		do 
		{
			fechaNacimiento = LocalDate.parse(Teclado.leerString("aaaa-mm-dd"));
		}while (fechaNacimiento.isAfter(LocalDate.now()));
		
		do
		{
			nota = Teclado.leerFloat("nota");
			
		}while (nota < 1 || nota > 10);
	}

	public void leerClave() {
		nia = Teclado.leerString("nia");
		
	}

	@Override
	public String toString() {
		return "Alumno [nia=" + nia + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", nota=" + nota
				+ "]";
	}
	

}
