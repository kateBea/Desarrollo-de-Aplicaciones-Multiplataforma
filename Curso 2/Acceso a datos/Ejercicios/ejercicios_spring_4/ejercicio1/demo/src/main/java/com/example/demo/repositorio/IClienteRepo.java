package com.example.demo.repositorio;

import com.example.demo.modelo.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepo extends CrudRepository<Cliente, String> {

}
