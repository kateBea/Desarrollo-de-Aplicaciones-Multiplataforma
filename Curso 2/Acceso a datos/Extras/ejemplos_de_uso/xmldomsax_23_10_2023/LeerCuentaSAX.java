package ejemplos_de_uso.xmldomsax_23_10_2023;

import java.io.IOException;
import java.util.Comparator;
import java.util.HashSet;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class LeerCuentaSAX extends DefaultHandler {
	private Cuenta cuenta;
	private String elementoActual;
	private Cliente clienteActual;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SAXParserFactory parserFactory = SAXParserFactory.newInstance();
		SAXParser parser;
		try {
			parser = parserFactory.newSAXParser();
			XMLReader procesadorXML = parser.getXMLReader();
			
			LeerCuentaSAX app = new LeerCuentaSAX();
			procesadorXML.setContentHandler(app);
			
			InputSource ficheroXML = new InputSource ("cuenta.xml");
			procesadorXML.parse(ficheroXML);
			
			System.out.println(app.cuenta.getNcc());
			System.out.println(app.cuenta.getSaldo());
			app.cuenta.getClientes().forEach(System.out::println);
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			System.out.println("error parseando xml....");
		}

	}
	
	public void startDocument()
	{
		cuenta = new Cuenta (); 
	}
	
	public void startElement (String uri, String localName, String qName, Attributes atts)  
	{
			
		elementoActual = qName;
		
		if (elementoActual.equals("cliente"))
		{
				clienteActual = new Cliente ();
		}
	
	}
	
	public void endElement(String uri, String localName, String qName)
	{
		if (qName.equals("cliente"))
			cuenta.addCliente(clienteActual);
		
		elementoActual = "";
	}
	
	public void characters(char[] ch, int start, int length) 
	{
		String contenido = new String (ch, start, length);
		
		contenido = contenido.replaceAll("[\t\n]", "");
		
		switch (elementoActual)
		{
			case "dni":
				clienteActual.setDni(contenido);
				break;
			case "nombre":
				clienteActual.setNombre(contenido);
				break;
			case "edad":
				clienteActual.setEdad(Integer.valueOf(contenido));
				break;
			case "ncc":
				cuenta.setNcc(contenido);
				break;
			case "saldo":
				cuenta.setSaldo(Float.valueOf(contenido));
				break;
		}
		
	}
	

}
