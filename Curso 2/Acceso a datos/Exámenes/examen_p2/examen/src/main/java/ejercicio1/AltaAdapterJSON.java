package ejercicio1;

import java.io.IOException;
import java.time.LocalDate;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class AltaAdapterJSON extends TypeAdapter<LocalDate> {

    @Override
    public void write(JsonWriter out, LocalDate value) throws IOException {
        out.beginObject();

        // dia
        out.name("dia");
        out.value(value.getDayOfMonth());

        // mes
        out.name("mes");
        out.value(value.getMonthValue());

        // año
        out.name("año");
        out.value(value.getYear());

        out.endObject();
    }

    @Override
    public LocalDate read(JsonReader in) throws IOException {
        LocalDate result = null;
        in.beginObject();
        
        int day = 0;
        int month = 0;
        int year = 0;
        while (in.hasNext()) {
            switch (in.nextName()) {
                case "dia": day = in.nextInt(); break;
                case "mes": month = in.nextInt(); break;
                case "año": year = in.nextInt(); break;
            }
        }

        result = LocalDate.of(year, month, day);
        in.endObject();

        return result;
    }
    
}
