package ejercicios_streams_2.solucion;

import java.util.HashSet;
import java.util.Set;

public class Depart {
	private String codigo;
	private String nombre;
	private String ciudad;
	private Set<Emple> empleados;

	public Depart(String codigo, String nombre, String ciudad) {

		this.codigo = codigo;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.empleados = new HashSet<Emple> ();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Set<Emple> getEmpleados() {
		return empleados;
	}
	
	public boolean addEmple (Emple empleado)
	{
		return empleados.add(empleado);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Depart other = (Depart) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Depart [codigo=" + codigo + ", nombre=" + nombre + ", ciudad=" + ciudad + ", empleados=" + empleados
				+ "]";
	}

	
}
