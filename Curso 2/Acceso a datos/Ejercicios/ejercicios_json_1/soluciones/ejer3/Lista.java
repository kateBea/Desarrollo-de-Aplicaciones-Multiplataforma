package org.dam2.ejer3;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class Lista {
	private List<Provincia> provincia;

}
