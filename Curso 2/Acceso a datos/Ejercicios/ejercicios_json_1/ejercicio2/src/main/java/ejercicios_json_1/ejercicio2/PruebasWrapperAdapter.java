package ejercicios_json_1.ejercicio2;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.List;

public class PruebasWrapperAdapter extends TypeAdapter<PruebasWrapper> {
    @Override
    public void write(JsonWriter jsonWriter, PruebasWrapper pruebasWrapper) {

    }

    @Override
    public PruebasWrapper read(JsonReader jsonReader) {
        List<Prueba> pruebas = null;

        try {
            if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
                jsonReader.beginArray();

                while (jsonReader.hasNext()) {
                    String tokenName = jsonReader.nextName();
                }

                jsonReader.endArray();
            }
        }
        catch (IOException e) {
            System.err.println("¡Error al leer datos!");
        }

        return PruebasWrapper.builder().pruebas(pruebas).build();
    }
}
