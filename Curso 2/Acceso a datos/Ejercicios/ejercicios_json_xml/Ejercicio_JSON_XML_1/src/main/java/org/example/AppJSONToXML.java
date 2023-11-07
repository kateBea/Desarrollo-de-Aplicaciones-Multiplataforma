package org.example;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Optional;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.google.gson.Gson;

public class AppJSONToXML {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		leerJSON().ifPresent(g -> escribirXML (g.getGlos()));

	}
	
	public static Optional <FicheroGlosario> leerJSON ()
	{
		
		Optional<FicheroGlosario> glossary = Optional.empty();
		
		try (Reader reader = new FileReader(new File("../fichero.json"));)
		{

			Gson json = new Gson();
			
			glossary= Optional.ofNullable(json.fromJson(reader, FicheroGlosario.class));
			
			//glossary.showData();
			System.out.println(glossary.map(FicheroGlosario::toString).
								orElse("No se han leido datos"));
			
			
			
		} 
		catch (Error | IOException e) {
			e.printStackTrace();
		}
		
		return glossary;
	}
	
	public static void escribirXML (Glossary glossary)
	{
		try {
			JAXBContext context = JAXBContext.newInstance(Glossary.class);
			Marshaller ms = context.createMarshaller();

			
			ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			ms.marshal(glossary, System.out);
			ms.marshal(glossary, new FileWriter("fichero.xml"));
			
			
		} catch (JAXBException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
