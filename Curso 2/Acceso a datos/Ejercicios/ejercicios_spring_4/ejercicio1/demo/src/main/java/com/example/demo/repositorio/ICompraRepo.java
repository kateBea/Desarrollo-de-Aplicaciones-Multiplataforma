package com.example.demo.repositorio;

import com.example.demo.modelo.Compra;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompraRepo extends CrudRepository<Compra, Long> {

}
