package pruebas.pruebas_de_nivel;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class CategoriaAdapter extends TypeAdapter<Categoria> {
    @Override
    public void write(JsonWriter jsonWriter, Categoria categoria) throws IOException {
        jsonWriter.value(categoria.toString());
    }

    @Override
    public Categoria read(JsonReader jsonReader) throws IOException {
        // consumir valor
        return Categoria.fromString(jsonReader.nextString());
    }
}
