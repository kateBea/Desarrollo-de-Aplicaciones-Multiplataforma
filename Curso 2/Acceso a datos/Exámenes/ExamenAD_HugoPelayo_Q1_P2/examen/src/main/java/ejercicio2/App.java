package ejercicio2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Entrada principal ejercicio 2
 *
 */
public class App 
{
    private static Gson gson;
    private static Unmarshaller unmarshaller;
    public static void main( String[] args )
    {
        final String INPUT_XML_FILE = "ficheros/recetas.xml";

        // inicializar contexto
        try {
            initContext();
        } catch (JAXBException e) {
            System.err.println("Error al inicializar: " + e.getMessage());
            return;
        }

        // procesar datos
        try (Reader reader = new FileReader(INPUT_XML_FILE)) {
            RecetasWrapper recetas = (RecetasWrapper) unmarshaller.unmarshal(reader);
            
            // depuración
            System.out.println(recetas);

            serializar(recetas);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    private static void serializar(RecetasWrapper recetas) {
        final String OUTPUT_JSON_FILE = "ficheros/recetas.json";

        final Predicate<Receta> TIENE_CAFE = receta ->
            receta.getIngredientes().stream().anyMatch(ingrediente -> ingrediente.getNombre().equalsIgnoreCase("café"));

        final Predicate<Receta> REQUIERE_MENOS_DE_55_MIN = receta ->
            receta.getTiempo().getValor() < 55;

        RecetasWrapper aSerializar = RecetasWrapper.builder().
            recetas(recetas.getRecetas().stream().collect(Collectors.filtering(TIENE_CAFE.negate().and(REQUIERE_MENOS_DE_55_MIN), Collectors.toList()))).
            build();

        try (Writer escritor = new FileWriter(OUTPUT_JSON_FILE)) {
            System.out.println(aSerializar.getRecetas());
            gson.toJson(aSerializar.getRecetas(), escritor);
            
        } catch (Exception e) {
            System.err.println("Error al serializar: " + e.getMessage());
        }
    }

    public static void initContext() throws JAXBException {
        // GSON
        gson = new GsonBuilder().
            serializeNulls().
            setPrettyPrinting().
            create();

        // JAXB
        JAXBContext jaxbContext = JAXBContext.newInstance(RecetasWrapper.class);
        unmarshaller = jaxbContext.createUnmarshaller();
    }
}
