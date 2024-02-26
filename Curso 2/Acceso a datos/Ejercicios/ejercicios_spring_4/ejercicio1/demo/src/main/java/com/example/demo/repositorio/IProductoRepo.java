package com.example.demo.repositorio;

import com.example.demo.modelo.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepo extends CrudRepository<Producto, String> {

}
