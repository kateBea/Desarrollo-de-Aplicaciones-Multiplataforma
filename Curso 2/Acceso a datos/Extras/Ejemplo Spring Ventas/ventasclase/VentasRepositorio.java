package com.dam2.ventas.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dam2.ventas.modelo.Ventas;

@Repository
public interface VentasRepositorio extends CrudRepository<Ventas, Integer> {

}
