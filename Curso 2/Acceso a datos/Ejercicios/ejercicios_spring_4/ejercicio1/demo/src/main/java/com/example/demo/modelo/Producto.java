package com.example.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "PRODUCTO")
public class Producto {

    @NonNull
    @EqualsAndHashCode.Include
    @Id
    @Column(name = "num_ref")
    private String numRef;
    private String nombre;
    private float precio;

    @Column(name = "nombre_proveedor")
    private String nombreProveedor;
}
