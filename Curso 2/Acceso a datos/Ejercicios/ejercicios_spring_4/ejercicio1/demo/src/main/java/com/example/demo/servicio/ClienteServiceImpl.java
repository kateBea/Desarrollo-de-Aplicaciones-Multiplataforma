package com.example.demo.servicio;

import com.example.demo.modelo.Cliente;
import com.example.demo.repositorio.IClienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ClienteServiceImpl implements IClienteServicio {

    @Autowired
    IClienteRepo clienteRepo;

    @Override
    public Optional<Cliente> buscarPorId(String dni) {
        return clienteRepo.findById(dni);
    }

    @Override
    public boolean existePorId(String dni) {
        return clienteRepo.existsById(dni);
    }

    @Override
    public Set<Cliente> buscarTodos() {
        return StreamSupport.stream(clienteRepo.findAll().spliterator(), false).
                collect(Collectors.toSet());
    }

    @Override
    public Optional<Cliente> insertar(Cliente nuevo) {
        nuevo.setFechaAlta(LocalDate.now());

        if (existePorId(nuevo.getDni())) {
            throw new RuntimeException("El cliente con DNI " + nuevo.getDni() + " ya existe.");
        }

        return Optional.of(clienteRepo.save(nuevo));
    }

    @Override
    public Optional<Cliente> actualizar(Cliente nuevo) {
        return Optional.of(clienteRepo.save(nuevo));
    }

    @Override
    public boolean borrarPorId(String dni) {
        clienteRepo.deleteById(dni);
        return existePorId(dni);
    }
}
