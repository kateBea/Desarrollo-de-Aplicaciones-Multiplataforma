package org.example;

import com.google.gson.GsonBuilder;
import lombok.val;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.*;
import java.util.Optional;



public class AppEjer2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		leerXML ().ifPresent( w-> escribirJSON(w));
		
		leerJSON().ifPresent(System.out::println);
	}
	
	public static Optional <Widget> leerXML ()
	{
		Optional <Widget> widget = Optional.empty();
		
		try {
			val context = JAXBContext.newInstance(Widget.class); // contexto
			val unMarshaller = context.createUnmarshaller(); // convesor xml -> objeto
			
			
			widget = Optional.ofNullable((Widget)unMarshaller.unmarshal(new File ("widget.xml")));
			
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return widget;
	}

	public static void escribirJSON(Widget w)
	{
		
		val wrapper = new WidgetWrapper(w);
		
		var builder = new GsonBuilder();
		
		// poner bonito json
		builder.setPrettyPrinting();
		
		// poner adaptadores
		// No es necesario el Adaptador de Alignment
		//builder.registerTypeAdapter(Alignment.class, new AlignmentJSONAdapter());
		builder.registerTypeAdapter(Boolean.class, new BooleanJSONAdapter());
		// No es necesario el Adaptador de Style
		//builder.registerTypeAdapter(Style.class, new StyleJSONAdapter());
		
		val gson = builder.create();
		
		
		try (val fichero = new PrintWriter (new File("widget.json"));)
		{
			gson.toJson(wrapper,fichero); // Escribir objeto a fichero json
			gson.toJson(wrapper,System.out); // Escribir objeto a pantalla
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Optional<Widget> leerJSON ()
	{
		Optional <Widget> widget = Optional.empty();
		Optional <WidgetWrapper> wrapper;

		
		
		var builder = new GsonBuilder();
		
		
		// poner adaptadores
		builder.registerTypeAdapter(Boolean.class, new BooleanJSONAdapter());

		
		val gson = builder.create();
		
		
		try (val reader = new FileReader(new File("widget.json"));)
		{
			wrapper = Optional.ofNullable((WidgetWrapper) gson.fromJson(reader,WidgetWrapper.class));
			
			widget = Optional.ofNullable(wrapper.orElse(new WidgetWrapper()).getWidget());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return widget;
	}
}
