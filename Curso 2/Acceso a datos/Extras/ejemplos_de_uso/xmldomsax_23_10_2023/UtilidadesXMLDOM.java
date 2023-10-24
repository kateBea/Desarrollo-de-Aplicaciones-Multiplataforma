package ejemplos_de_uso.xmldomsax_23_10_2023;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class UtilidadesXMLDOM {
	
	public static String getNodo (String etiqueta, Element elemento)
	{
		NodeList nodo = elemento.getElementsByTagName(etiqueta).item(0).getChildNodes();
		
		Node valorNodo = nodo.item(0);
		
		return valorNodo.getNodeValue();
	}

	public static void crearElemento (String etiqueta, String valor, Element padre, Document document)
	{
		Element elem = document.createElement(etiqueta); // Crear hijo
		Text text = document.createTextNode(valor); // Dar valor
		
		padre.appendChild(elem); // Pegar elemento hijo al padre
		elem.appendChild(text); // Pegar valor al elemento hijo
		
	}
	
	public static Document crearDocumento (String fichero)
	{
		DocumentBuilderFactory factory;
		
		factory = DocumentBuilderFactory.newInstance();
		
		
		DocumentBuilder builder;
		Document document = null;
		
		try 
		{
			builder = factory.newDocumentBuilder();
			document = builder.parse(new File(fichero));
			document.getDocumentElement().normalize();
		} 
		catch (ParserConfigurationException | SAXException | IOException e) 
		{
			e.printStackTrace();
		}
		
			
		return document;
	}

}
