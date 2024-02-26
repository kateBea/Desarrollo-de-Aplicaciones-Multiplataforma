package dam2.taller.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "PIEZA")
public class Pieza {
    @NonNull
    @EqualsAndHashCode.Include
    @Id
    @Column(name = "num_ref")
    private String numRef;

    @Column(nullable = false)
    private String nombre;

    @Column(name = "precio_unidad", nullable = false)
    private float precioUnidad;
}