package com.dam2.basedatos.unidirecional1an;

import java.time.LocalDate;

import daw.com.Teclado;

public class ControladorEmpleado {
	private Empleado modelo;

	public ControladorEmpleado ()
	{
		modelo = new Empleado ();
	}
	
	public ControladorEmpleado(Empleado modelo) {
		super();
		this.modelo = modelo;
	}

	public Empleado getModelo() {
		return modelo;
	}

	public void setModelo(Empleado modelo) {
		this.modelo = modelo;
	}
	
	public void leerModeloSinClave ()
	{
		String fecha;
		modelo.setApellido(Teclado.leerString("Apellido:"));
	
		fecha = Teclado.leerString("Fecha de Alta");
		modelo.setFechaAlta(LocalDate.parse(fecha));
		
		modelo.setSalario(Teclado.leerFloat("Salaario"));
		
	}
	
	public void leerClaveModelo ()
	{
		modelo.setEmpNo(Teclado.leerString("Nº Empleado"));
	}
	
	public void leerModelo ()
	{
		leerClaveModelo ();
		leerModeloSinClave ();
		
	}

	
}
