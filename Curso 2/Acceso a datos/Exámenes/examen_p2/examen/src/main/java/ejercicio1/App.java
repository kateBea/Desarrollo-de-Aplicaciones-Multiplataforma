package ejercicio1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Entrada principal ejercicio 1
 *
 */
public class App 
{
    private static Gson gson;
    private static Marshaller marshaller;
    public static void main( String[] args )
    {
        final String INPUT_JSON_FILE = "ficheros/grupos.json";

        // Inicialización
        try {
            initContext();
        } catch (JAXBException e) {
            System.err.println("Error al inicializar: " + e.getMessage());
            return;
        }

        // procesar datos
        try (Reader reader = new FileReader(INPUT_JSON_FILE)) {
            GrupoWrapper grupoWrapper = GrupoWrapper.builder().
                grupos(List.of(gson.fromJson(reader, Grupo[].class))).
                build();

            serializar(grupoWrapper);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    private static void serializar(GrupoWrapper grupoWrapper) {
        final String OUTPUT_XML_FILE = "ficheros/grupos.xml";
        final Predicate<Grupo> FILTRO = grupo ->
            grupo.getAlumnos().stream().
            map(alumno -> alumno.getNotas()).
            anyMatch(Notas::algunaSuspendida);
            

        GrupoWrapper resultadoAXml = GrupoWrapper.builder().
            grupos(grupoWrapper.getGrupos().stream().
            collect(Collectors.filtering(FILTRO, Collectors.toList()))).
            build();
        
        try (Writer escritor = new FileWriter(OUTPUT_XML_FILE)) {
            marshaller.marshal(resultadoAXml, escritor);
            System.out.println("Fichero escrito correctamente");
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
        JAXBContext jaxbContext = JAXBContext.newInstance(GrupoWrapper.class);
        marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    }
}
