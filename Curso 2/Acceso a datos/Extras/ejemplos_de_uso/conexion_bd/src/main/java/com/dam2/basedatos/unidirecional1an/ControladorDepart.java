package com.dam2.basedatos.unidirecional1an;

import java.time.LocalDate;

import daw.com.Teclado;

public class ControladorDepart {
	private Depart modelo;

	public ControladorDepart ()
	{
		modelo = new Depart();
	}
	
	public ControladorDepart(Depart modelo) {
		super();
		this.modelo = modelo;
	}

	public Depart getModelo() {
		return modelo;
	}

	public void setModelo(Depart modelo) {
		this.modelo = modelo;
	}
	
	public void leerModeloSinClave ()
	{
		ControladorEmpleado controladorEmple = new ControladorEmpleado(null);
		
		modelo.setDname(Teclado.leerString("Nombre Departamento"));
		modelo.setLoc(Teclado.leerString("Localización Departamento"));
		
		// Leer Empleados
		do
		{
			controladorEmple.setModelo(new Empleado ());
			controladorEmple.leerModelo();
			modelo.getEmpleados().add(controladorEmple.getModelo());
		}while (Teclado.leerString("Introducir otro Empleado(s/n)?").equalsIgnoreCase("s"));
		
	}
	
	public void leerClaveModelo ()
	{
		modelo.setDeptNo(Teclado.leerString("Nº Departamento"));
	}
	
	public void leerModelo ()
	{
		leerClaveModelo ();
		leerModeloSinClave ();
		
	}

}
