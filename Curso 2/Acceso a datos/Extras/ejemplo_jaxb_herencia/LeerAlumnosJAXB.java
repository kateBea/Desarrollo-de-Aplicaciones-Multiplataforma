import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class LeerAlumnosJAXB {

	public static void main (String args[])
	{
		try {
			JAXBContext context = JAXBContext.newInstance(Alumnos.class);
			Unmarshaller ums = context.createUnmarshaller();
			
			Alumnos alumnos = (Alumnos) ums.unmarshal(new File("Alumnos.xml"));
			for(Alumno a : alumnos.getAlumnos()) {
				System.out.println(a.toString());
			}
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}


}
