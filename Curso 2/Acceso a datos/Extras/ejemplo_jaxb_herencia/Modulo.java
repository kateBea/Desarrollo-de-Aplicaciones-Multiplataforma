import javax.xml.bind.annotation.XmlRootElement;

import daw.com.Teclado;


@XmlRootElement
public class Modulo {
	private String nombre;
	private int nota;
	
	public Modulo() {
		nombre = "";
		nota = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public void leerDatos ()
	{
		nombre = Teclado.leerString("Nombre Módulo:");
		nota = Teclado.leerInt("Nota Módulo:");
	}
	@Override
	public String toString() {
		return "Modulo [nombre=" + nombre + ", nota=" + nota + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Modulo other = (Modulo) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	
	
	

}
