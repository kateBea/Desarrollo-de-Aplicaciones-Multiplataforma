package ejercicios_json_1.ejercicio2;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class PruebaAdapter extends TypeAdapter<Prueba> {
    @Override
    public void write(JsonWriter jsonWriter, Prueba object) {

    }

    @Override
    public Prueba read(JsonReader jsonReader) {
        Prueba prueba = null;


        return prueba;
    }
}
