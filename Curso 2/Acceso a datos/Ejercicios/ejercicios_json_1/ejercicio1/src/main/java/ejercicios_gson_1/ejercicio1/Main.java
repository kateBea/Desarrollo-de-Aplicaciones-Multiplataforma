package ejercicios_gson_1.ejercicio1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;

/**
 * Proyecto maven de lectura sin adaptadores de datos de JSON con librería GSON.
 * Proyecto Maven. Abrir con IntelliJ IDEA. Los ficheros tienen la ruta relativa,
 * que en el momento de creación del proyecto es relativa a la carpeta raíz de este.
 *
 * @author Hugo Pelayo
 * */
public class Main {
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader lector = new BufferedReader(input);

    /*
     * Escribe el contenido de "contents" al fichero indicado
     * Se asume que el fichero ya existe. Sobreescribe el contenido
     * @param fichero ruta salida
     * @param contents contenido a escribir
     * */
    public static void writeToFile(File fichero, Object... contents) {
        try {
            BufferedWriter escritor = new BufferedWriter(new FileWriter(fichero,false));
            for (Object item : contents) {
                try {
                    escritor.write(item.toString());
                }
                catch (IOException e) {
                    System.err.println("Excepción al escribir al fichero: " + e.getCause());
                }
            }

            escritor.close();
        }
        catch (IOException e) {
            System.err.println("Excepción al abrir al fichero: " + e.getCause());
        }
    }

    /**
     * Serializa una lista de personas a un fichero XML
     * @param personas listado a serializar
     * */
    public static void xmlDump(ListaPersonas personas) {
        if (personas == null) {
            return;
        }

        try {
            JAXBContext context = JAXBContext.newInstance(ListaPersonas.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            StringWriter stringWriter = new StringWriter();
            marshaller.marshal(personas, stringWriter);

            String contents = stringWriter.toString();

            // para depuración
            System.out.println(contents);

            final String nombreFichero = leerCadena("Introduce el nombre del fichero XML: ");
            File fichero = new File(nombreFichero + ".xml");

            if (!fichero.exists() && fichero.createNewFile()) {
                System.out.println("Fichero creado");
            }

            writeToFile(fichero, contents);
        }
        catch (JAXBException e) {
            System.err.println("Excepción JAXB: " + e.getCause());
        }
        catch (IOException e) {
            System.err.println("Excepción al crear fichero: " + e.getCause());
        }
    }

    public static void main(String[] args) {
        // [Generamos manipuladores GSON]
        GsonBuilder gsonBuilder = new GsonBuilder().setPrettyPrinting();
        Gson gson = gsonBuilder.create();

        // Contenedor del listado de personas del GSON o nulo si
        // el fichero está vacío o no existe
        ListaPersonas personas = null;

        final String directorioFichero = "../personas.json";

        // [Abrimos el archivo]
        try {
            Reader lector = new FileReader(directorioFichero);
            personas = gson.fromJson(lector, ListaPersonas.class);
            lector.close();
        }
        catch (FileNotFoundException e) {
            System.err.println("¡Fichero no encontrado!");
        }
        catch (IOException e) {
            System.err.println("¡Error de uso de Reader!");
        }

        // [Mostramos por consola para depuración]
        if (personas != null) {
            System.out.println("Listado de personas:\n");
            personas.getPersonas().forEach(System.out::println);

            System.out.println("\nListado de personas formato JSON:\n");
            System.out.println(gson.toJson(personas));
        }

        // [Serializamos a XML]
        xmlDump(personas);
    }

    /**
     * Lee una línea de la entrada por defecto de datos mostrando
     * primero el prompt que se pasa como parámetro. Si se falla la lectura devuelve null
     * @param prompt mensaje a mostrar antes de la lectura
     * @return string con la línea leída
     * */
    public static String leerCadena(String prompt) {
        if (prompt != null)
            System.out.print(prompt);

        String resultado = null;

        try {
            resultado = lector.readLine();
        }
        catch (IOException exception) {
            System.out.println("Excepción leer cadena: " + exception.getCause());
        }

        return resultado;
    }
}