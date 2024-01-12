package com.dam2.modelo;

import java.io.Serializable;

public class Mensaje implements Serializable{
	
	private int id;
	private String texto;
	
	public Mensaje ()
	{
		id = 0;
		texto = "";
	}
	
	public Mensaje(int id, String texto) {
		this.id = id;
		this.texto = texto;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	@Override
	public String toString() {
		return "Mensaje [id=" + id + ", texto=" + texto + "]";
	}
	
	

}
