package ejemplos_profe_colecciones;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.Objects;

import daw.com.Teclado;

public class Alumno implements Comparable<Alumno> 
{
	private String nia;
	private String nombre;
	private LocalDate fechaNacimiento;
	private float nota;
	private boolean repetidor;
	
	
	
	
	public Alumno() {
		this ("");
	}

	public Alumno(String nia) {

		this (nia,"", LocalDate.now(), 0, false);
	}

	public Alumno(String nia, String nombre, LocalDate fechaNacimiento, float nota, boolean repetidor) {
		this.nia = nia;
		this.nombre = nombre;
		setFechaNacimiento  (fechaNacimiento);
		setNota (nota);
		this.repetidor = repetidor;
	}
	
	public String getNia() {
		return nia;
	}
	public void setNia(String nia) {
		this.nia = nia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		
		if (fechaNacimiento == null || fechaNacimiento.isAfter(LocalDate.now()))
			fechaNacimiento = LocalDate.now();
		
		this.fechaNacimiento = fechaNacimiento;
	}
	public float getNota() {
		return nota;
	}
	
	public void setNota(float nota) throws IllegalArgumentException 
	{
		
		if (nota < 0 || nota > 10)
			throw new IllegalArgumentException("valor de nota no permimtido");
		
		this.nota = nota;
	}
	public boolean isRepetidor() {
		return repetidor;
	}
	public void setRepetidor(boolean repetidor) {
		this.repetidor = repetidor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(nia, other.nia);
	}

	public int getEdad ()
	{
		return Period.between(fechaNacimiento, LocalDate.now()).getYears();
	}
	
	@Override
	public String toString() {
		return "Alumno [nia=" + nia + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", nota=" + nota
				+ ", repetidor=" + repetidor + "]";
	}
	
	
	public void leerClave ()
	{
		nia = Teclado.leerString("NIA:");
	}
	
	public void leerOtrosDatos ()
	{
		boolean seguir;
		nombre = Teclado.leerString("Nombre: ");
		
		try
		{
			setFechaNacimiento (LocalDate.parse(Teclado.leerString("fecha  nacimiento")));
		}
		catch (DateTimeParseException e)
		{
			System.out.println("fecha en formato erróneo");
			fechaNacimiento = LocalDate.now();
		}
		
		do {
			try {
				setNota(Teclado.leerFloat("Nota"));
				seguir = true;
			}
			catch (IllegalArgumentException e)
			{
				System.out.println(e.getMessage());
				seguir = false;
			}
		}while (!seguir);
		
		
		setRepetidor (Teclado.leerString("Es repetidor (S/N)").equalsIgnoreCase("s"));
		
	}

	@Override
	public int compareTo(Alumno o) {
		// TODO Auto-generated method stub
		return nia.compareTo(o.nia);
	}
	
	
	

}
