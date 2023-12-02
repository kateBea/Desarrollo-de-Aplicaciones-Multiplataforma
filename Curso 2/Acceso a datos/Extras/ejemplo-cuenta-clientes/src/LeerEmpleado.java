import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LeerEmpleado {
	
	public static void main (String args[])
	{
		DocumentBuilderFactory factory;
		
		factory = DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File("Empleados.xml"));
			
			document.getDocumentElement().normalize();
			
			// Elemento raiz
			
			System.out.println("Raiz: " + document.getDocumentElement().getNodeName());
			
			// Crear una lista con todos los nodos empleado
			NodeList empleados = document.getElementsByTagName("empleado");
			
			// Recorrer la ista
			for (int i = 0; i < empleados.getLength(); i++)
			{
				// Obtener un empleado de la lista
				Node emple = empleados.item(i);
				System.out.println("Tipo nodo " + emple.getNodeType());
				
				if (emple.getNodeType() == Node.ELEMENT_NODE)
				{
					Element elemento = (Element) emple;
					
					Empleado empleado = new Empleado ();
					
					empleado.setId(getNodo ("id", elemento));
					empleado.setNombre(getNodo ("nombre", elemento));
					empleado.setDept(getNodo ("dept", elemento));
					empleado.setSueldo(Float.parseFloat(getNodo ("sueldo", elemento)));
					
					
					System.out.println(empleado.toString());
				}
				
			}
			
			
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static String getNodo (String etiqueta, Element elemento)
	{
		NodeList nodo = elemento.getElementsByTagName(etiqueta).item(0).getChildNodes();
		
		Node valorNodo = nodo.item(0);
		
		return valorNodo.getNodeValue();
	}

}
