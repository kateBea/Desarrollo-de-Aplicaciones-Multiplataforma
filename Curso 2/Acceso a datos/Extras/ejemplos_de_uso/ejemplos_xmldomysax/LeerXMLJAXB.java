package dam2.org.xmldomysax;
import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class LeerXMLJAXB {
	
	public static void main(String[] args) {
		try {
			JAXBContext context = JAXBContext.newInstance(Empleados.class);
			Unmarshaller ums = context.createUnmarshaller();
			Empleados empleados = (Empleados) ums.unmarshal(new File("Empleados1.xml"));
			System.out.println(empleados);
			for(Empleado emp : empleados.getLista()) {
				System.out.println(emp.toString());
			}
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

}
