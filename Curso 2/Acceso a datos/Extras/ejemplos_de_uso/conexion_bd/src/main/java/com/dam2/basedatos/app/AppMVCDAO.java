package com.dam2.basedatos.app;

public class AppMVCDAO extends AppMenu {
	
	final MenuItem SALIR = new MenuItem ("Salir",0,()->{});
	
	public AppMVCDAO ()
	{
		super ();
	
		addOpcion (new MenuItem ("Insertar Departamento", 1, new Insertar()));
		addOpcion (new MenuItem ("Consultar un Departamento", 2, new Consultar()));
		addOpcion (new MenuItem ("Listar Departamentos", 3, new Listar()));
		addOpcion (SALIR);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AppMVCDAO app = new AppMVCDAO();
		
		app.run();
		
		
	}

}
