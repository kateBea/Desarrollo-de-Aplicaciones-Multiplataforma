import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import daw.com.Teclado;

@XmlRootElement
@XmlType(propOrder={"dni", "nombre", "modulos"})
public class Alumno {
	String dni;
	String nombre;
	Modulos modulos;
	
	public Alumno() {
		dni = "";
		nombre = "";
		modulos = new Modulos ();
		
	}

	@XmlAttribute
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


	public Modulos getModulos() {
		return modulos;
	}

	public void setModulos(Modulos modulos) {
		this.modulos = modulos;
	}

	public void leerDatos()
	{
		String respuesta;
		
		dni = Teclado.leerString("DNI:");
		nombre = Teclado.leerString("Nombre Alumno: ");
		
		do
		{
			Modulo modulo = new Modulo ();
			modulo.leerDatos();
			modulos.getModulos().add(modulo);
			respuesta = Teclado.leerString("Otro Módulo");
		}while (respuesta.equalsIgnoreCase("s"));
		
	}
	
	@Override
	public String toString() {
		return "Alumno [dni=" + dni + ", nombre=" + nombre + ", modulos=" + modulos.toString() + "]";
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
		Alumno other = (Alumno) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}


	
	
	
	

}
