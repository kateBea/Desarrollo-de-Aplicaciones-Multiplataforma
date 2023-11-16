package org.dam2.xml;

import java.util.HashSet;
import java.util.Set;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class GestorEventos extends DefaultHandler {
	private Set<Empleado> empleados;
	private Empleado porDondeVoy;
	private String elementoActual;
	
	public GestorEventos ()
	{
		
	}
	
	
	public void startDocument()
	{
		empleados = new HashSet<> (); 
		//System.out.println("Inicio documento");
	}
	
	public void endDocument()
	{
		//System.out.println("Fin documento");
		empleados.forEach(System.out::println);
	}

	
	public void startElement (String uri, String localName, String qName, Attributes atts)  
	{
		
		//System.out.println("\tInicio elemento " + uri + " " + localName + " " + qName);
		/*
		for (int i = 0; i < atts.getLength(); i++)
			System.out.println("\t\t" + atts.getLocalName(i) + ", " + atts.getValue(i));
		*/
		
		elementoActual = qName;
		

		if (elementoActual.equals("empleado"))
				porDondeVoy = new Empleado ();

		
	}
	
	public void endElement(String uri, String localName, String qName)
	{
		//System.out.println("\tFin elemento " + localName + qName );
		if (qName.equals("empleado"))
			empleados.add(porDondeVoy);
		
		elementoActual = "";
	}
	
	public void characters(char[] ch, int start, int length) 
	{
		String contenido = new String (ch, start, length);
		
		contenido = contenido.replaceAll("[\t\n]", "");
		
		switch (elementoActual)
		{
			case "id":
				porDondeVoy.setId(contenido);
				break;
			case "nombre":
				porDondeVoy.setNombre(contenido);
				break;
			case "dept":
				porDondeVoy.setDept(contenido);
				break;
			case "sueldo":
				porDondeVoy.setSueldo(Float.valueOf(contenido));
				break;
		}
		
	}

}
