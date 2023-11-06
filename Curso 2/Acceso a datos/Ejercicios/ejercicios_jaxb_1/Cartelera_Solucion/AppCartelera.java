package ejercicios_jaxb_1.Cartelera_Solucion;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class AppCartelera {
	
	public static void main(String[] args) {
		
			Cartelera  cartelera = leerCartelera ();
			System.out.println("Listado de pelis en cartelera");
			cartelera.getPeliculas().forEach(System.out::println);
			
			System.out.println("Listado de actores que hayan actuado en pelis posteriores al 2003");
			cartelera.getPeliculas().stream().
				filter(p -> p.getFecha().isAfter(LocalDate.of(2003, 12, 31))). // pelis posteriores al 2003
				flatMap(p -> p.getActores().stream()). // Actores de todas las pelis
				distinct(). // eliminar repetidos
				forEach(System.out::println); // mostrar
		
			// Escribir Cartelera en fichero bis
			escribirCartelera (cartelera);

	}
	
	public static Cartelera leerCartelera ()
	{
		Cartelera cartelera = new Cartelera ();
		try {
			JAXBContext context = JAXBContext.newInstance(Cartelera.class);
			Unmarshaller ums = context.createUnmarshaller();
			cartelera = (Cartelera) ums.unmarshal(new File("cartelera.xml"));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		return cartelera;
	}
	
	public static void escribirCartelera (Cartelera cartelera)
	{
		
		try {
			JAXBContext context = JAXBContext.newInstance(Cartelera.class);
			Marshaller ms = context.createMarshaller();

									
			ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			ms.marshal(cartelera, System.out);
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
