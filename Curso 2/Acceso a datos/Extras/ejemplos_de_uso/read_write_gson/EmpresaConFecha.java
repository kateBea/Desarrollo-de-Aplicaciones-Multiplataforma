package org.dam2.json;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmpresaConFecha {
	private String nombre;
	private List<Empleado> empleados;
	private LocalDate fecha;

	

	public EmpresaConFecha() {
		
		this.nombre = "";
		this.empleados = new ArrayList<>();
		this.fecha = LocalDate.now();
	}
	
	public EmpresaConFecha(String nombre, List<Empleado> empleados, LocalDate fecha) {
		
		this.nombre = nombre;
		this.empleados = empleados;
		this.fecha = fecha;
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

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "EmpresaConFecha [nombre=" + nombre + ", empleados=" + empleados + ", fecha=" + fecha + "]";
	}
	
	


	
	

}
