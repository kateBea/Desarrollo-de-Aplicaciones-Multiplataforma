package dam2.org.xmldomysax;

import java.io.IOException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class LeerClientesAtributosSAX extends DefaultHandler {
	private Set<Cliente> clientes;
	private String elementoActual;
	private Cliente clienteActual;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SAXParserFactory parserFactory = SAXParserFactory.newInstance();
		SAXParser parser;
		try {
			parser = parserFactory.newSAXParser();
			XMLReader procesadorXML = parser.getXMLReader();
			
			LeerClientesAtributosSAX app = new LeerClientesAtributosSAX();
			procesadorXML.setContentHandler(app);
			
			InputSource ficheroXML = new InputSource ("clientesAtributo.xml");
			procesadorXML.parse(ficheroXML);
			
			app.clientes.stream().
					filter(c -> c.getEdad()< 67).
					sorted(Comparator.comparing(Cliente::getEdad)).
					forEach(System.out::println);
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			System.out.println("error parseando xml....");
		}
	
	}
	
	
	public void startDocument()
	{
		clientes = new HashSet<> (); 
	}
	
	
	public void startElement (String uri, String localName, String qName, Attributes atts)  
	{
			
		elementoActual = qName;
		
		if (elementoActual.equals("cliente"))
		{
				clienteActual = new Cliente ();
				//System.out.println(atts);
				//System.out.println(atts.getValue("dni"));
				clienteActual.setDni(atts.getValue("dni"));
		}
	
	}
	
	public void endElement(String uri, String localName, String qName)
	{
		
		if (qName.equals("cliente"))
			clientes.add(clienteActual);
		
		elementoActual = "";
	}
	
	public void characters(char[] ch, int start, int length) 
	{
		String contenido = new String (ch, start, length);
		
		contenido = contenido.replaceAll("[\t\n]", "");
		
		switch (elementoActual)
		{
			case "nombre":
				clienteActual.setNombre(contenido);
				break;
			case "edad":
				clienteActual.setEdad(Integer.valueOf(contenido));
				break;
		}
		
	}
	

}
