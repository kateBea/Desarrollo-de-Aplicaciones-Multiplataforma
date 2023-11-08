package movies;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.dam2.ejerJSONXML1.Glossary;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class AppMovies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//List<Movie> movies, moviesFiltradas ;
		
		// leer JSON
		//movies = leerJSON();
		
		// filtrar movies
		//moviesFiltradas = filtrarMovies (movies);
		
		// Escribir xml
		//escribirXML (moviesFiltradas);

		leerJSON().ifPresent( m -> escribirXML(filtrarMovies(m)));
	}

	private static List<Movie> filtrarMovies(List<Movie> movies) {
		// TODO Auto-generated method stub
		List<Movie> moviesFiltradas;

				
		Predicate<Movie> noventas = m -> 
						Integer.valueOf(m.getYear()) >= 1990 && 
						Integer.valueOf(m.getYear()) <= 1999;

		Predicate<Movie> rattingAprobado = m -> 
						m.getRatings().stream().
						mapToInt(Integer::intValue).
						average().orElse(0) > 5;

		moviesFiltradas = movies.stream().
						filter(noventas).
						filter(rattingAprobado).
						collect(Collectors.toList());
		
		return moviesFiltradas;
	}

	private static Optional <List<Movie>> leerJSON() {
		// TODO Auto-generated method stub
		
		List<Movie> movies = null;
		
		Type  listaDeMovies;
		
		GsonBuilder creadorGson = new GsonBuilder();			
		
		// poner adaptador de genres
		creadorGson.registerTypeAdapter(Genres.class, new GenresAdapter());
		// poner adaptador de fecha
		creadorGson.registerTypeAdapter(LocalDate.class, new LocalDateAdapter());
		
		Gson gson = creadorGson.create();
		
		listaDeMovies = TypeToken.getParameterized(List.class, Movie.class).getType();
		
						
		Reader reader;
		try {
			reader = new FileReader (new File ("movies.json"));
			movies = gson.fromJson(reader, listaDeMovies);
			
			reader.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
						

		return Optional.ofNullable(movies);
		
	}

	private static void escribirXML(List<Movie> moviesFiltradas) {
		// TODO Auto-generated method stub
		MovieWrapper wrapper = new MovieWrapper();
		wrapper.setMovies(moviesFiltradas);
		
		try {
			JAXBContext context = JAXBContext.newInstance(MovieWrapper.class);
			Marshaller ms = context.createMarshaller();

			
			ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			ms.marshal(wrapper, System.out);
			ms.marshal(wrapper, new FileWriter("movies.xml"));
			
			
		} catch (JAXBException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
