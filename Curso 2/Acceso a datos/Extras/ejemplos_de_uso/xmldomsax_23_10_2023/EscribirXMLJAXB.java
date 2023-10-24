package ejemplos_de_uso.xmldomsax_23_10_2023;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import daw.com.Teclado;

public class EscribirXMLJAXB {


	public static void main(String[] args) {
			
			JAXBContext context;
			Marshaller ms;
			
			Empleados empleados = new Empleados();	
			empleados.setNombreEmpresa("villablanca");


			String respuesta ;
			do
			{
				// Leer empleado
				Empleado empleado = new Empleado ();
				Controlador<Empleado> controlador = new ControladorEmpleadoConsola();
				controlador.leerDatos(empleado);
				
				respuesta = Teclado.leerString("Introducir otro (S/N)");
				
				empleados.addEmpleado(empleado);
				
			}while (respuesta.equals("S"));
		
			
		// Escribir XML
		try {
			
			// Crear contexto
			context = JAXBContext.newInstance(Empleados.class);
			// Crear marshaller, objeto que se encarga de escribir el XML
			ms = context.createMarshaller();
						
			ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			ms.marshal(empleados, System.out);
			ms.marshal(empleados, new FileWriter("Empleados1.xml"));
			
			
		} catch (JAXBException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
