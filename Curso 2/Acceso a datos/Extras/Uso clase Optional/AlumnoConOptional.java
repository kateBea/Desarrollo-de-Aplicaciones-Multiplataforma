

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Optional;

import daw.com.Pantalla;
import daw.com.Teclado;

public class AlumnoConOptional {
	private static final LocalDate FECHATOPE = LocalDate.now().minusYears(17);
	
	// atributos
	private String nia;
	private String nombre;
	private Optional<LocalDate> fecha;
	private float nota;
	private boolean repetidor;
	private String curso;
	
	
	// Constructores
	public AlumnoConOptional ()
	{
		this ("", "",Optional.empty(), 1,false,"");
	}
	
	public AlumnoConOptional (String nia)
	{
		this (nia, "", Optional.empty(), 1, false,"");
	}

	public AlumnoConOptional(String nia, String nombre, Optional<LocalDate> fecha, float nota, boolean repetidor,String curso) {
		
		this.nia = nia;
		this.nombre = nombre;
		//this.fecha = fecha;
		setFecha (fecha);
		
		//this.nota = nota;
		setNota (nota);
		this.repetidor = repetidor;
		
		this.curso = curso;
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

	public Optional<LocalDate> getFecha() {
		return fecha;
	}

	public void setFecha(Optional<LocalDate> fecha) throws IllegalArgumentException 
	{
				
		if (fecha.isPresent() && fecha.get().isAfter(FECHATOPE))
			throw new IllegalArgumentException ("fecha incorrecta");
		
		this.fecha = fecha;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		if (nota < 1)
			nota = 1;
		else if (nota > 10)
			nota = 10;
			
		this.nota = nota;
	}

	public boolean isRepetidor() {
		return repetidor;
	}

	public void setRepetidor(boolean repetidor) {
		this.repetidor = repetidor;
	}

	
	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	

	@Override
	public String toString() {
		return "Alumno [nia=" + nia + ", nombre=" + nombre + 
				", fecha=" + (fecha.map(LocalDate::toString).orElse("SIN DATOS")) +
				", nota=" + nota + 
				", repetidor=" + repetidor + 
				", curso=" + curso + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nia == null) ? 0 : nia.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlumnoConOptional other = (AlumnoConOptional) obj;
		if (nia == null) {
			if (other.nia != null)
				return false;
		} else if (!nia.equals(other.nia))
			return false;
		return true;
	}
	
	public void leerDatos ()
	{
		leerClave ();
		leerOtrosDatos ();
	}
	
	public void leerClave ()
	{
		nia = Teclado.leerString("nia");
	}
	
	public void leerOtrosDatos ()
	{
		
		boolean fechaCorrecta;
		nombre = Teclado.leerString("nombre");
		
		
		do
		{
			fechaCorrecta = true;
			try
			{
				fecha = Optional.of(LocalDate.parse(Teclado.leerString("fecha")));
				setFecha (fecha);
			}
			catch (DateTimeParseException | IllegalArgumentException ex)
			{
				Pantalla.escribirString("\nError en la fecha");
				fechaCorrecta = false;
			}
		}while (!fechaCorrecta);
		
		
		setNota (Teclado.leerFloat("nota"));
		
		repetidor = Teclado.leerString("Repetidor(S/N)").equalsIgnoreCase("S");
		
		curso = Teclado.leerString("curso");
		
	}
	
	public boolean estaAprobado ()
	{
		return nota >= 5;
	}
	
	public String toCSV ()
	{
		return nia + ";" + 
				nombre + ";" 
				+ (fecha.map(LocalDate::toString).orElse("SIN DATOS")) + ";" 
				+ nota + ";"
				+ repetidor + ";" 
				+ curso + "\n";
		
	}
	
	public static AlumnoConOptional fromCSV (String lineaCSV)
	{
		AlumnoConOptional alumno = new AlumnoConOptional ();
		String[] campos = lineaCSV.split(";");
		alumno.nia = campos[0];
		alumno.nombre = campos[1];
		
		try
		{
			alumno.setFecha (Optional.of(LocalDate.parse(campos[2])));
		}
		catch (DateTimeParseException | IllegalArgumentException ex)
		{
			alumno.setFecha(Optional.empty());
		}
		
			
		alumno.setNota(Float.parseFloat(campos[3]));
		
		alumno.repetidor = Boolean.parseBoolean(campos[4]);
		
		alumno.setCurso(campos[5]);
		
		return alumno;
	}
	
}