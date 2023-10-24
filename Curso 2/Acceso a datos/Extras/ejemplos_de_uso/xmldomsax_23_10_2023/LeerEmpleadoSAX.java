package ejemplos_de_uso.xmldomsax_23_10_2023;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

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
	
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		// TODO Auto-generated method stub
		
		//XMLReader procesadorXML = XMLReaderFactory.createXMLReader(); Deprecated
		
		SAXParserFactory parserFactory = SAXParserFactory.newInstance();
		SAXParser parser = parserFactory.newSAXParser();
		XMLReader procesadorXML = parser.getXMLReader();
		
		
		DefaultHandler gestor = new GestorEventos();
		
		procesadorXML.setContentHandler(gestor);
		
		InputSource ficheroXML = new InputSource ("Empleados.xml");
		
		procesadorXML.parse(ficheroXML);

	}
	
	
	
	
}
