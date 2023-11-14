package com.dam2.basedatos.unidirecional1an;

import java.util.HashSet;
import java.util.Set;

public class Depart {

	private String deptNo;
	private String dname;
	private String loc;
	private Set<Empleado> empleados;

	
	public Depart()
	{
		this ("","","", new HashSet<>());
	}
	public Depart(String deptNo, String dname, String loc, Set<Empleado> empleados) {
		super();
		this.deptNo = deptNo;
		this.dname = dname;
		this.loc = loc;
		this.empleados = empleados;
	}
	public String getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}
	
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	public Set<Empleado> getEmpleados() {
		return empleados;
	}
	public void setEmpleados(Set<Empleado> empleados) {
		this.empleados = empleados;
	}
	@Override
	public String toString() {
		return "Depart [deptNo=" + deptNo + ", dname=" + dname + ", loc=" + loc + ", empleados=" + empleados + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deptNo == null) ? 0 : deptNo.hashCode());
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
		Depart other = (Depart) obj;
		if (deptNo == null) {
			if (other.deptNo != null)
				return false;
		} else if (!deptNo.equals(other.deptNo))
			return false;
		return true;
	}
	
	
	
	
	
	
}
