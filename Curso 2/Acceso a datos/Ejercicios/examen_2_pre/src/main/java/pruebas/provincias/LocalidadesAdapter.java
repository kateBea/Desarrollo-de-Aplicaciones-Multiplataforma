package pruebas.provincias;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class LocalidadesAdapter extends TypeAdapter<Localidades> {

    @Override
    public void write(JsonWriter jsonWriter, Localidades localidades) throws IOException {
        Gson gson = new Gson ();

        // Empezar objeto localidades
        jsonWriter.beginObject();

        // escribir clave localidad
        jsonWriter.name("localidad");

        // escribimos como lista si hay más de un elemento
        if (localidades.getLocalidades().size() > 1)  {
            jsonWriter.beginArray();

            for (Localidad localidad : localidades.getLocalidades())  { jsonWriter.jsonValue(gson.toJson(localidad)); }

            jsonWriter.endArray();
        }
        else  {
            jsonWriter.jsonValue(gson.toJson(localidades.getLocalidades().get(0)));
        }

        // finalizamos objeto localidades
        jsonWriter.endObject();
    }

    @Override
    public Localidades read(JsonReader jsonReader) throws IOException {
        Gson gson = new Gson ();
        Localidades localidades = new Localidades ();

        // Consumir comienzo objeto
        jsonReader.beginObject();

        // Consumir nombre localidad
        jsonReader.nextName();

        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            // si llega un array
            // Type listaDeLocalidades = TypeToken.getParameterized(ArrayList.class, Localidad.class).getType();
            //localidades.setLocalidades(gson.fromJson(jsonReader, listaDeLocalidades));
            localidades.setLocalidades(List.of(gson.fromJson(jsonReader, Localidad[].class)));

        }

        else {
            //llega un elemento consumirlo
            localidades.getLocalidades().add(gson.fromJson(jsonReader, Localidad.class));
        }

        // Consumir final objeto
        jsonReader.endObject();

        return localidades;
    }
}
