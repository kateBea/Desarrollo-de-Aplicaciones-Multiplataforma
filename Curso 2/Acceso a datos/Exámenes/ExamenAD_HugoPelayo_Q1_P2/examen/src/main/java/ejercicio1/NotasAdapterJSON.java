package ejercicio1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

public class NotasAdapterJSON extends TypeAdapter<Notas> {

    @Override
    public void write(JsonWriter out, Notas value) throws IOException {
        
    }

    @Override
    public Notas read(JsonReader in) throws IOException {
        Notas notas = null;
        if (in.peek() != JsonToken.BEGIN_ARRAY) {
            // una sola nota
            notas = Notas.builder().notas(List.of(in.nextDouble())).build();
        }
        else {
            in.beginArray();
            List<Double> notasRecogidas = new ArrayList<>();
            while (in.hasNext()) {
                notasRecogidas.add(in.nextDouble());
            }
            
            notas = Notas.builder().notas(notasRecogidas).build();
            in.endArray();
        }

        return notas;
    }
    
}
