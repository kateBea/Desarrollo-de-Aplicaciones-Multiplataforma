package ejercicios_json_1.ejercicio2;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PruebasWrapper {
    private List<Prueba> pruebas;
}
