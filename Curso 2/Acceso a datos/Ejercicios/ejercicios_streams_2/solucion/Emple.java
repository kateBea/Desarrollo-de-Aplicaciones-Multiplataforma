package ejercicios_streams_2.solucion;

import java.time.LocalDate;
import java.util.Optional;

public class Emple {
	private String dni;
	private String nombre;
	private boolean mujer;
	private LocalDate fechaNacimiento;
	private LocalDate fechaIncorporacion;
	private float salario,comision;
	private String cargo;
	private Optional<Emple> jefe;
	
	public Emple(String dni, String nombre, boolean mujer, LocalDate fechaNacimiento, LocalDate fechaIncorporacion,
			float salario, float comision, String cargo, Emple jefe) {
		
		this.dni = dni;
		this.nombre = nombre;
		this.mujer = mujer;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaIncorporacion = fechaIncorporacion;
		this.salario = salario;
		this.comision = comision;
		this.cargo = cargo;
		this.jefe = Optional.ofNullable(jefe);
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isMujer() {
		return mujer;
	}

	public void setMujer(boolean mujer) {
		this.mujer = mujer;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public LocalDate getFechaIncorporacion() {
		return fechaIncorporacion;
	}

	public void setFechaIncorporacion(LocalDate fechaIncorporacion) {
		this.fechaIncorporacion = fechaIncorporacion;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public float getComision() {
		return comision;
	}

	public void setComision(float comision) {
		this.comision = comision;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Optional<Emple> getJefe() {
		return jefe;
	}

	public void setJefe(Emple jefe) {
		this.jefe = Optional.ofNullable(jefe);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
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
		Emple other = (Emple) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Emple [dni=" + dni + ", nombre=" + nombre + ", sexo=" + (mujer?"Mujer":"Hombre") + ", fechaNacimiento=" + fechaNacimiento
				+ ", fechaIncorporacion=" + fechaIncorporacion + ", salario=" + salario + ", comision=" + comision
				+ ", cargo=" + cargo + ", jefe=" + jefe.map(Emple::getNombre).orElse("sin jefe") + "]";
	}
	
	

}
