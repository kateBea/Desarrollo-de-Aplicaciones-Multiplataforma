package ejercicios_json_1.ejercicio2;

import lombok.*;

import java.time.LocalDateTime;

// Lombok
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Prueba {
    @NonNull
    @EqualsAndHashCode.Include
    private String objectId;

    @NonNull
    @EqualsAndHashCode.Include
    private String idPrueba;

    private String nivel;
    private String titulo;

    private String MCER;

    private String horario;

    private LocalDateTime inicioImport;
    private LocalDateTime finImport;
    private int horas;
    private String url;
    private double ECTS;
    private TipoFormacion tipoFormacion;
    private Categoria categoria;
}
