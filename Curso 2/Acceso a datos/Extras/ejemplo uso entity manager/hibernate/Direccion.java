package org.dam2.hibernate;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Direccion implements Serializable {
	
	 @Id
	 //@GeneratedValue (strategy = GenerationType.TABLE)
	 @Column(name="Id")
	 private int id;
	 
	 @Column(name="calle")
	 private String calle;
	 
	 @Column(name="numero")
	 private int numero;
	 
	 @Column(name="poblacion")
	 private String poblacion;
	 
	 @Column(name="provincia")
	 private String provincia;

	 
	public Direccion ()
	{
		
	}
	 
	public Direccion(int id, String calle, int numero, String poblacion, String provincia) {

		this.id = id;
		this.calle = calle;
		this.numero = numero;
		this.poblacion = poblacion;
		this.provincia = provincia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	@Override
	public String toString() {
		return "Direccion [id=" + id + ", calle=" + calle + ", numero=" + numero + ", poblacion=" + poblacion
				+ ", provincia=" + provincia + "]";
	}
	

	 
}
