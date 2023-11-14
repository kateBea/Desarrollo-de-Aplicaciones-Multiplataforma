package pruebas.pruebas_de_nivel;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Prueba {
    @NonNull
    @EqualsAndHashCode.Include
    @SerializedName("$id")
    private String objectId;

    @SerializedName("MCER")
    private String mcer;

    @SerializedName("Nivel")
    private String nivel;

    @SerializedName("ID")
    private String idPrueba;

    @SerializedName("Titulo")
    private String titulo;

    @SerializedName("Horario")
    private String horario;

    @SerializedName("InicioImparticion")
    private LocalDateTime inicioImp;

    @SerializedName("FinImparticion")
    private LocalDateTime finImp;

    @SerializedName("Horas")
    private int horas;

    @SerializedName("URL")
    private String url;

    @SerializedName("TipoFormacion")
    @JsonAdapter(FormacionAdapter.class)
    private Formacion formacion;

    @SerializedName("ECTS")
    private Double ects;

    @SerializedName("Categoria")
    @JsonAdapter(CategoriaAdapter.class)
    private Categoria categoria;

    @SerializedName("Profesorado")
    private List<Profesor> profesorado;

    public Prueba() {
        profesorado = new ArrayList<>();
    }


}
