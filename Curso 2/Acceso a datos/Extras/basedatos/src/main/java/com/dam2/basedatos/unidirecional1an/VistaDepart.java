package com.dam2.basedatos.unidirecional1an;

import daw.com.Pantalla;

public class VistaDepart {
	private Depart modelo;

	public VistaDepart (Depart modelo) {
		
		this.modelo = modelo;
	}

	public Depart getModelo() {
		return modelo;
	}

	public void setModelo(Depart modelo) {
		this.modelo = modelo;
	}
	
	public void mostrarModelo ()
	{
		Pantalla.escribirString("---------------------------------");
		Pantalla.escribirString("Nº departamento:", modelo.getDeptNo());
		Pantalla.escribirString("Nombre departamento:", modelo.getDname());
		Pantalla.escribirString("Localización departamento:", modelo.getLoc());
		
		modelo.getEmpleados().forEach( e-> new VistaEmpleado(e).mostrarModelo());
	}

}
