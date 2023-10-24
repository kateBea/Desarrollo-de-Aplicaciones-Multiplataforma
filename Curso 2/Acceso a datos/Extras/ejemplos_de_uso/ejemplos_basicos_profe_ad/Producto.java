package ejemplos_de_uso.ejemplos_basicos_profe_ad;

import java.util.Objects;

import daw.com.Teclado;

public class Producto {
	
	private String referencia;
	private float precio;
	private boolean perecedero;
	
	
	public Producto(String referencia, float precio, boolean perecedero) {

		this.referencia = referencia;
		this.precio = precio;
		this.perecedero = perecedero;
	}


	public String getReferencia() {
		return referencia;
	}


	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}


	public float getPrecio() {
		return precio;
	}


	public void setPrecio(float precio) {
		this.precio = precio;
	}


	public boolean isPerecedero() {
		return perecedero;
	}


	public void setPerecedero(boolean perecedero) {
		this.perecedero = perecedero;
	}


	@Override
	public int hashCode() {
		return Objects.hash(referencia);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(referencia, other.referencia);
	}


	@Override
	public String toString() {
		return "Producto [referencia=" + referencia + ", precio=" + precio + ", perecedero=" + perecedero + "]";
	}

	public void leerDatos ()
	{
		leerClave();
		leerResto();
	}


	public void leerResto() {
		// TODO Auto-generated method stub
		precio = Teclado.leerFloat("precio");
		perecedero = Teclado.leerString("perecedero?(s/n)").equalsIgnoreCase("s");
	}


	public void leerClave() {
		// TODO Auto-generated method stub
		referencia = Teclado.leerString("referencia");
	}
	
	
	

}
