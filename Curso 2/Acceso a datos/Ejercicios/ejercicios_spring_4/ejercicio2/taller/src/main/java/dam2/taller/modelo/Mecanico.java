package dam2.taller.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)


@Entity
@Table(name = "MECANICO")
public class Mecanico {
    @NonNull
    @EqualsAndHashCode.Include
    @Id
    private String nickname;

    @Column(nullable = false)
    private String contrasena;

    @Column(name = "fecha_alta", nullable = false)
    private LocalDate fechaAlta;
}
