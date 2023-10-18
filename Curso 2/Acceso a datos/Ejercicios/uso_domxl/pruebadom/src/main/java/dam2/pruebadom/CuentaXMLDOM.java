package dam2.pruebadom;

import java.util.Iterator;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class CuentaXMLDOM  {
	
	
	public static Cuenta createCuenta (Node nodo)
	{
		Element elemento = (Element) nodo;
		
		Cuenta cuenta = new Cuenta ();
		
		String ncc = elemento.getElementsByTagName("ncc").item(0).getTextContent();
		cuenta.setNcc(ncc);
		
		float saldo = Float.parseFloat(elemento.getElementsByTagName("saldo").item(0).getTextContent());
		cuenta.setSaldo(saldo);
		
		
		NodeList elementoCliente = elemento.getElementsByTagName("cliente");
		
		for (int i = 0; i < elementoCliente.getLength(); i++)
			cuenta.addCliente(ClienteXMLDOM.createCliente(elementoCliente.item(i)));
		
		/*
		IntStream streamEnteros = IntStream.range(0, elementoCliente.getLength());
		Stream <Node> nodoclientes =  streamEnteros.mapToObj(elementoCliente::item);
		Stream <Cliente> clientes = nodoclientes.map(ClienteXMLDOM::createCliente);
		clientes.forEach(cuenta::addCliente);
		*/

		/*
		IntStream.range(0, elementoCliente.getLength()). //crear stream de enteros (0, 1,.., tamaño nodelist)
					mapToObj(elementoCliente::item). // mapear de entero a Node
						map(ClienteXMLDOM::createCliente). // mapear de Node a Cliente
							forEach(cuenta::addCliente); // para cada Cliente añadir en cuenta
		*/
		
		/*
		IntStream.range(0, elementoCliente.getLength()). //crear stream de enteros (0, 1,.., tamaño nodelist)
				mapToObj(i -> ClienteXMLDOM.createCliente(elementoCliente.item(i))). // mapear de entero a Cliente
					forEach(cuenta::addCliente); // para cada Cliente añadir en cuenta
		*/
		
		return cuenta;
	}
	
	public static Element toXMLDOM (Document documento, Cuenta cuenta)
	{
		Element elementoCuenta = documento.createElement("cuenta");
		
		// Insertar datos empelados
		UtilidadesXMLDOM.crearElemento ("ncc", cuenta.getNcc(), elementoCuenta, documento);
		UtilidadesXMLDOM.crearElemento ("saldo", String.valueOf(cuenta.getSaldo()), elementoCuenta, documento);
		
		Iterator<Cliente>  clientes =  cuenta.getClientes().iterator();
		
		while (clientes.hasNext())
		{
			Cliente cliente =  clientes.next();
			elementoCuenta.appendChild(ClienteXMLDOM.toXMLDOM(documento,cliente));
		}
		
		
		/*
		cuenta.getClientes().forEach(c-> elementoCuenta.appendChild(ClienteXMLDOM.toXMLDOM(documento,c)));
		*/
		return elementoCuenta;
	}

}
