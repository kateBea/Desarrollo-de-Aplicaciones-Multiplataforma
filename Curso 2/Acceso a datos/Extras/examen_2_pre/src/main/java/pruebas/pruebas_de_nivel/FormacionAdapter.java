package pruebas.pruebas_de_nivel;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class FormacionAdapter extends TypeAdapter<Formacion> {
    @Override
    public void write(JsonWriter jsonWriter, Formacion formacion) throws IOException {
        jsonWriter.value(formacion.toString());
    }

    @Override
    public Formacion read(JsonReader jsonReader) throws IOException {
        return Formacion.fromString(jsonReader.nextString());
    }
}
