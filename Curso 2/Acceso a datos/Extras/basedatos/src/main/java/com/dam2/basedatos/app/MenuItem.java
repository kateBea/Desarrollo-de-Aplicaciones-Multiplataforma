package com.dam2.basedatos.app;

import com.dam2.basedatos.Service;

public class MenuItem {
	private String mensaje;
	private int opcion;
	private Service action;
	
	public MenuItem ()
	{
		//this ("",0,null);
		this ("",0,()->{});
	}
	
	public MenuItem(String mensaje, int opcion, Service action) 
	{
		this.mensaje = mensaje;
		this.opcion = opcion;
		this.action = action;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public int getOpcion() {
		return opcion;
	}

	public void setOpcion(int opcion) {
		this.opcion = opcion;
	}

	public Service getAction() {
		return action;
	}

	public void setAction(Service action) {
		this.action = action;
	}

	@Override
	public String toString() {
		return "MenuItem [mensaje=" + mensaje + ", opcion=" + opcion + ", action=" + action.getClass().getSimpleName() + "]";
	}


	@Override
	public boolean equals(Object obj) {
		
		MenuItem menuItem = (MenuItem)obj;
		
		return menuItem.opcion == this.opcion;
	}
	
	
}
