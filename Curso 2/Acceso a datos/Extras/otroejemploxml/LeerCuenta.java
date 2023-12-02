package com.dam2.xml;


import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class LeerCuenta {
	
	public static void main (String args[]) 
	{
		
		// Crear DOM a partir del fichero xml
		Document document = UtilidadesXMLDOM.crearDocumento("Cuenta.xml");
			
		// Obtener el nodo raíz
		Node raiz = document.getDocumentElement();
		
		// Normalizar 
		raiz.normalize();
		
		// Crear un POJO a partir de un Nodo del DOM
		Cuenta  cuenta = CuentaXMLDOM.createCuenta(raiz);
		
		// Mostrar resultado.
		System.out.println(cuenta);
		
	}

}
