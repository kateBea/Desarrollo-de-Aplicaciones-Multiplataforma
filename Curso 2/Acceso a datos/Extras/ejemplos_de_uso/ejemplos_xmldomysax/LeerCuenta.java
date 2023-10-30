package dam2.org.xmldomysax;


import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class LeerCuenta {
	
	public static void main (String args[]) 
	{
		
		// Crear DOM a partir del fichero xml
		Document document = UtilidadesXMLDOM.crearDocumento("cuenta.xml");
			
		// Obtener el nodo raíz
		Node raiz = document.getDocumentElement();
		

		
		// Crear un POJO a partir de un Nodo del DOM
		Cuenta  cuenta = CuentaXMLDOM.createCuenta(raiz);
		
		// Mostrar resultado.
		System.out.println(cuenta);
		
	}

}
