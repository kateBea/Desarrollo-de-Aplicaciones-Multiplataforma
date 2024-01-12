package com.example.demo.modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)


@Repository
public class Sucursal implements Serializable {
	@NonNull
	private String id;
	
	private List<Cliente> clientes;
	
	private List<Cuenta> cuentas;
	
}
