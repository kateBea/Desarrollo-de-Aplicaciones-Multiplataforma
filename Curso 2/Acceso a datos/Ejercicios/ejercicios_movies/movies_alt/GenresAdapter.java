package movies;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;


import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

public class GenresAdapter extends TypeAdapter<Genres> 
{

	@Override
	public void write(JsonWriter out, Genres value) throws IOException {
		// TODO Auto-generated method stub
		

		// Comporbar cuantos elementos hay en el array
		if (value.getValores().size() == 1)
			// Escribir el valor
			out.jsonValue(value.getValores().get(0));
		else
		{
			// Escribir el array
			out.beginArray();
			
			for (String v : value.getValores())
				out.jsonValue(v);
			out.endArray();
		}
		
		
	}

	@Override
	public Genres read(JsonReader in) throws IOException {
		// TODO Auto-generated method stub
		Genres genres = new Genres();
		
		
		Gson gson = new Gson ();
		
		if (in.peek() == JsonToken.BEGIN_ARRAY) // si llega un array
		{
			Type  listaDeGenres = TypeToken.getParameterized(ArrayList.class, String.class).getType();
			genres.setValores(gson.fromJson(in, listaDeGenres));
		}
		else
		{
			genres.setValores(new ArrayList<>());
			genres.getValores().add(in.nextString());
		}
		
		return genres;
	}

}
