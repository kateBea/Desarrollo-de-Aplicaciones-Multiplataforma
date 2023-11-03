package org.dam2.json;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
	private String nombre;
	private List<Empleado> empleados ;
	
	
	
	
	public Empresa() {
		nombre = "";
		empleados = new ArrayList<>();
	}

	public Empresa(String nombre, List<Empleado> empleados) {
		
		this.nombre = nombre;
		this.empleados = empleados;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	@Override
	public String toString() {
		return "Empresa [nombre=" + nombre + ", empleados=" + empleados + "]";
	}
	
	

}


