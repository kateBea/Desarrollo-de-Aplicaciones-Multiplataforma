package ejercicio2;

import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class DificultadAdapterJSON extends TypeAdapter<Dificultad> {

    @Override
    public void write(JsonWriter out, Dificultad value) throws IOException {
        out.value(value.toString());
    }

    @Override
    public Dificultad read(JsonReader in) throws IOException {
        return Dificultad.from(in.nextString());
    }
    
}
