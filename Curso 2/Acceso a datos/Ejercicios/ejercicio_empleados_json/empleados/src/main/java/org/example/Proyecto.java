package org.example;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Proyecto {
    private String id;
    private String nombre;
}
