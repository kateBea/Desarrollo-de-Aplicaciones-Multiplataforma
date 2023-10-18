package dam2.pruebadom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class ClienteXMLDOM  {
	
	public static Cliente createCliente (Node nodo)
	{
		Cliente cliente;
		
		Element elemento = (Element) nodo;
		
		cliente = new Cliente ();
		
		String dni = elemento.getElementsByTagName("dni").item(0).getChildNodes().item(0).getNodeValue();
		cliente.setDni(dni);
		
		String nombre = elemento.getElementsByTagName("nombre").item(0).getTextContent();
		cliente.setNombre(nombre);
		
		int edad = Integer.parseInt(elemento.getElementsByTagName("edad").item(0).getTextContent());
		cliente.setEdad(edad);
		
		
		
		return cliente;
	}
	
	public static Element toXMLDOM (Document documento, Cliente c)
	{
		Element elementoCliente = documento.createElement("cliente");
		
		// Insertar datos empelados
		UtilidadesXMLDOM.crearElemento ("dni", c.getDni(), elementoCliente, documento);
		UtilidadesXMLDOM.crearElemento ("nombre", c.getNombre(), elementoCliente, documento);
		UtilidadesXMLDOM.crearElemento ("edad", String.valueOf(c.getEdad()), elementoCliente, documento);
		
		
		return elementoCliente;
	}
	

}
