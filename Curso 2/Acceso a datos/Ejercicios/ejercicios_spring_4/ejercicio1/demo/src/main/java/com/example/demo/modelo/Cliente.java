package com.example.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "CLIENTE")
public class Cliente {

    @NonNull
    @EqualsAndHashCode.Include
    @Id
    @Column(length = 9)
    private String dni;
    private String nombre;

    @Column(name = "fecha_alta")
    private LocalDate fechaAlta;
}
