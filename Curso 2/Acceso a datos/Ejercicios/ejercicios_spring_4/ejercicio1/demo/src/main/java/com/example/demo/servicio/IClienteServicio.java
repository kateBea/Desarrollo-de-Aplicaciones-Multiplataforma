package com.example.demo.servicio;

import com.example.demo.modelo.Cliente;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public interface IClienteServicio {
    Optional<Cliente> buscarPorId(String dni);
    boolean existePorId(String dni);
    Set<Cliente> buscarTodos();

    Optional<Cliente> insertar(Cliente nuevo);
    Optional<Cliente> actualizar(Cliente nuevo);

    boolean borrarPorId(String dni);
}
