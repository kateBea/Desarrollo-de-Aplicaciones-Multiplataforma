package com.dam2.basedatos.unidirecional1an;

import daw.com.Pantalla;

public class VistaEmpleado {
	private Empleado modelo;

	public VistaEmpleado(Empleado modelo) {
		this.modelo = modelo;
	}

	public Empleado getModelo() {
		return modelo;
	}

	public void setModelo(Empleado modelo) {
		this.modelo = modelo;
	}
	
	public void mostrarModelo ()
	{
		Pantalla.escribirString("Nº Empleado:", modelo.getEmpNo());
		Pantalla.escribirString("Apellidos:", modelo.getApellido());
		Pantalla.escribirString("Fecha de Alta:", modelo.getFechaAlta().toString());
		Pantalla.escribirFloat("Salario:", modelo.getSalario());
		
	}
	
	

}
