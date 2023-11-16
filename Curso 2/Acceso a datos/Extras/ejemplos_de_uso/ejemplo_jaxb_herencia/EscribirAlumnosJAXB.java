import java.io.FileWriter;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import daw.com.Teclado;

public class EscribirAlumnosJAXB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try 
		{
			JAXBContext context = JAXBContext.newInstance(Alumnos.class);
			Marshaller ms = context.createMarshaller();

			Alumnos alumnos = new Alumnos();		
			Alumno alumno;	

			String respuesta ;
			int tipo;
			
			do
			{
				
				// Leer alumno
				
				tipo = Teclado.leerInt("1. Con Proyecto - 2. Con Título");
				
				if (tipo == 1)
					alumno = new AlumnoConProyecto ();
				else
					alumno = new AlumnoConTitulo ();
				
				alumno.leerDatos();

				respuesta = Teclado.leerString("Introducir otro (S/N)");

				alumnos.getAlumnos().add(alumno);

			}while (respuesta.equals("S"));
			
			for (Alumno a: alumnos.getAlumnos())
				System.out.println(a.toString());


			ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			ms.marshal(alumnos, System.out);
			ms.marshal(alumnos, new FileWriter("Alumnos.xml"));


		} catch (JAXBException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
