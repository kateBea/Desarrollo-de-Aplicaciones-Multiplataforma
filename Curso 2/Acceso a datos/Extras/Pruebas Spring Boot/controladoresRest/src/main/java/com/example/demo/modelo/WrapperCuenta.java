package com.example.demo.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WrapperCuenta {
	private Class tipo;
	private Cuenta cuenta;

}
