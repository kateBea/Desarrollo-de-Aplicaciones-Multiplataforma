import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import daw.com.Teclado;

public class EscribirEmpleado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DocumentBuilderFactory factory;
		
		factory = DocumentBuilderFactory.newInstance();
		
		try 
		{
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			// Crear documento vacio con raiz empleados
			DOMImplementation implementation  = builder.getDOMImplementation();
			Document document = implementation.createDocument(null, "empleados", null);
			document.setXmlVersion("1.0");
			
			
			String respuesta ;
			do
			{
				// Leer empleado
				Empleado empleado = new Empleado ();
				empleado.leerEmpleado();
				
				// Añadir nodo empleado
				Element nodoEmpleado = document.createElement("empleado");
				document.getDocumentElement().appendChild(nodoEmpleado);
				
				// Insertar datos empelados
				crearElemento ("id", empleado.getId(), nodoEmpleado, document);
				crearElemento ("nombre", empleado.getNombre(), nodoEmpleado, document);
				crearElemento ("dept", empleado.getDept(), nodoEmpleado, document);
				crearElemento ("sueldo", Float.toString(empleado.getSueldo()), nodoEmpleado, document);
				
				respuesta = Teclado.leerString("Introducir otro (S/N)");
				
			}while (respuesta.equals("S"));
			
			
			// Escribir DOM en fichero XML
			Source source = new DOMSource(document);
			Result result = new StreamResult (new File ("Empleados.xml"));
			
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			
			transformer.transform(source, result);
			

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}
	
	public static void crearElemento (String etiqueta, String valor, Element padre, Document document)
	{
		Element elem = document.createElement(etiqueta); // Crear hijo
		Text text = document.createTextNode(valor); // Dar valor
		
		padre.appendChild(elem); // Pegar elemento hijo al padre
		elem.appendChild(text); // Pegar valor al elemento hijo
		
	}
}
