package dam2.taller.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "ASIGNACION")
public class Asignacion {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private Estado estado;

    @Column(name = "horas_dedicadas", nullable = false)
    private float horasDedicadas;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    private Mecanico mecanico;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Trabajo trabajo;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "piezas_usadas")
    private Set<Material> materiales;
}
