package ejemplos_de_uso.xmldomsax_23_10_2023;

import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LeerCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NodeList nodos;
		Document document = UtilidadesXMLDOM.crearDocumento("clientes.xml");
		
		nodos = document.getElementsByTagName("cliente");
		
		IntStream.range(0, nodos.getLength()).
			mapToObj(i -> nodos.item(i)).
			map(ClienteXMLDOM::createCliente).
			filter(c -> c.getEdad()>65).
			sorted(Comparator.comparing(Cliente::getNombre)).
			forEach(System.out::println);
	}

}
