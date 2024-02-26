package com.example.demo.servicio;

import com.example.demo.modelo.Producto;
import com.example.demo.repositorio.IProductoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductoServiceImpl implements IProductoServicio {

    @Autowired
    IProductoRepo productoRepo;

    @Override
    public Optional<Producto> buscarPorId(String numRef) {
        return productoRepo.findById(numRef);
    }

    @Override
    public boolean existePorId(String numRef) {
        return productoRepo.existsById(numRef);
    }

    @Override
    public Set<Producto> buscarTodos() {
        return StreamSupport.stream(productoRepo.findAll().spliterator(), false).
                collect(Collectors.toSet());
    }

    @Override
    public Optional<Producto> insertar(Producto nuevo) {
        return Optional.of(productoRepo.save(nuevo));
    }

    @Override
    public Optional<Producto> actualizar(Producto nuevo) {
        return Optional.of(productoRepo.save(nuevo));
    }

    @Override
    public boolean borrarPorId(String numRef) {
        productoRepo.deleteById(numRef);
        return existePorId(numRef);
    }
}
