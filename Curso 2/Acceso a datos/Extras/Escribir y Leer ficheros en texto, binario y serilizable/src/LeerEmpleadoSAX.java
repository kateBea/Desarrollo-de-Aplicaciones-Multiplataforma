import java.io.IOException;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class LeerEmpleadoSAX extends DefaultHandler {

	public LeerEmpleadoSAX ()
	{
		super();
	}
	
	public static void main(String[] args) throws SAXException, IOException {
		// TODO Auto-generated method stub
		
		XMLReader procesadorXML = XMLReaderFactory.createXMLReader();
		
		DefaultHandler gestor = new LeerEmpleadoSAX();
		
		procesadorXML.setContentHandler(gestor);
		
		InputSource ficheroXML = new InputSource ("Empleados.xml");
		
		procesadorXML.parse(ficheroXML);

	}
	
	public void startDocument()
	{
		System.out.println("Inicio documento");
	}
	
	public void endDocument()
	{
		System.out.println("Fin documento");
	}

	
	public void startElement (String uri, String localName, String qName, Attributes atts)  
	{
		
		System.out.println("\tInicio elemento " + uri + " " + localName + " " + qName);
		for (int i = 0; i < atts.getLength(); i++)
			System.out.println("\t\t" + atts.getLocalName(i) + ", " + atts.getValue(i));
	}
	
	public void endElement(String uri, String localName, String qName)
	{
		System.out.println("\tFin elemento " + localName );
	}
	
	public void characters(char[] ch, int start, int length) 
	{
		String contenido = new String (ch, start, length);
		
		contenido = contenido.replaceAll("[\t\n]", "");
		
		System.out.println("\tcontenido " + contenido );
		
	}
	
	
}
