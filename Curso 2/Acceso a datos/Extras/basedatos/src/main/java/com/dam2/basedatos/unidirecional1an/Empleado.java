package com.dam2.basedatos.unidirecional1an;

import java.time.LocalDate;

public class Empleado {
	private String empNo;
	private String apellido;
	private LocalDate fechaAlta;
	private float salario;
	

	public Empleado ()
	{
		this ("","",LocalDate.now(),0);
	}
	
	public Empleado(String empNo, String apellido, LocalDate fechaAlta, float salario) {

		this.empNo = empNo;
		this.apellido = apellido;
		this.fechaAlta = fechaAlta;
		this.salario = salario;
	}
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public LocalDate getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Empleado [empNo=" + empNo + ", apellido=" + apellido + ", fechaAlta=" + fechaAlta + ", salario="
				+ salario + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empNo == null) ? 0 : empNo.hashCode());
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
		Empleado other = (Empleado) obj;
		if (empNo == null) {
			if (other.empNo != null)
				return false;
		} else if (!empNo.equals(other.empNo))
			return false;
		return true;
	}
	
	
	

}
