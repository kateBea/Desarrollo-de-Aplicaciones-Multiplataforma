package com.dam2.xml;

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

import daw.com.Teclado;

public class EscribirCuenta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
DocumentBuilderFactory factory;
		
		factory = DocumentBuilderFactory.newInstance();
		
		try 
		{
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			// Crear documento vacio con raiz empleados
			DOMImplementation implementation  = builder.getDOMImplementation();
			Document document = implementation.createDocument(null, "cuenta", null);
			document.setXmlVersion("1.0");
			
			
			
			// Leer cuenta
			Cuenta cuenta = new Cuenta ("11111");
			cuenta.setSaldo(2550);
						
			Cliente c1 = new Cliente ("1111111A","miguel", 34);
			Cliente c2 = new Cliente ("2222222B","luis", 44);
			
			cuenta.addCliente(c1);
			cuenta.addCliente(c2);
			
			// Añadir nodo cuenta
			Element nodoCuenta = CuentaXMLDOM.toXMLDOM(document,cuenta);
				
			document.getDocumentElement().appendChild(nodoCuenta);
				
						
			
			// Escribir DOM en fichero XML
			Source source = new DOMSource(document);
			Result result = new StreamResult (new File ("CuentaBis.xml"));
			
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			
			transformer.transform(source, result);
			

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}


	}

}
