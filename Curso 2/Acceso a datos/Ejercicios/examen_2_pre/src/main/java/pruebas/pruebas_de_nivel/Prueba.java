package pruebas.pruebas_de_nivel;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import lombok.*;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@XmlType(propOrder = { "objectId", "mcer", "nivel", "idPrueba", "titulo", "horario", "inicioImp",
        "finImp", "horas", "url", "formacion", "ects", "categoria", "profesorado" })
@XmlAccessorType(XmlAccessType.FIELD)
public class Prueba {
    @NonNull
    @EqualsAndHashCode.Include
    @SerializedName("$id")
    @XmlElement(name = "object-id")
    private String objectId;

    @SerializedName("MCER")
    @XmlElement(name = "mcer")
    private String mcer;

    @SerializedName("Nivel")
    @XmlElement(name = "nivel")
    private String nivel;

    @SerializedName("ID")
    @XmlElement(name = "id")
    private String idPrueba;

    @SerializedName("Titulo")
    @XmlElement(name = "titulo")
    private String titulo;

    @SerializedName("Horario")
    @XmlElement(name = "horario")
    private String horario;

    @SerializedName("InicioImparticion")
    @XmlElement(name = "ini-imp")
    @XmlJavaTypeAdapter(LocalDateTimeXMLAdapter.class)
    private LocalDateTime inicioImp;

    @SerializedName("FinImparticion")
    @XmlElement(name = "fin-imp")
    @XmlJavaTypeAdapter(LocalDateTimeXMLAdapter.class)
    private LocalDateTime finImp;

    @SerializedName("Horas")
    @XmlElement(name = "horas")
    private int horas;

    @SerializedName("URL")
    @XmlElement(name = "url")
    private String url;

    @SerializedName("TipoFormacion")
    @XmlElement(name = "tipo-formacion")
    @JsonAdapter(FormacionAdapter.class)
    @XmlJavaTypeAdapter(FormacionXMLAdapter.class)
    private Formacion formacion;

    @SerializedName("ECTS")
    @XmlElement(name = "ects")
    private Double ects;

    @SerializedName("Categoria")
    @XmlElement(name = "categoria")
    @JsonAdapter(CategoriaAdapter.class)
    @XmlJavaTypeAdapter(CategoriaXMLAdapter.class)
    private Categoria categoria;

    @SerializedName("Profesorado")
    @XmlElementWrapper(name = "profesorado")
    @XmlElement(name = "profesor")
    private List<Profesor> profesorado;

    public Prueba() {
        profesorado = new ArrayList<>();
    }


}
