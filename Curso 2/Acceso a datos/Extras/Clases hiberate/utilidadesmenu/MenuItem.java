package org.dam2.utilidadesmenu;

public class MenuItem {
	private String mensaje;// Lo que ve el usuario en al opci�n de men�
	private int opcion; // Que tiene que elegir el usuario
	private MenuAction action; // La acci�n que se realiza
	
	public MenuItem ()
	{
		this ("",0,()->{});
	}
	
	public MenuItem(String mensaje, int opcion, MenuAction action) 
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

	public MenuAction getAction() {
		return action;
	}

	public void setAction(MenuAction action) {
		this.action = action;
	}

	@Override
	public String toString() {
		return "MenuItem [mensaje=" + mensaje + ", opcion=" + opcion + ", action=" + action.getClass().getSimpleName() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + opcion;
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
		MenuItem other = (MenuItem) obj;
		if (opcion != other.opcion)
			return false;
		return true;
	}
	
}
