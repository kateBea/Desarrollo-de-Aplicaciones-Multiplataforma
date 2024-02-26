package com.example.demo.servicio;

import com.example.demo.modelo.Compra;
import com.example.demo.repositorio.IClienteRepo;
import com.example.demo.repositorio.ICompraRepo;
import com.example.demo.repositorio.IProductoRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CompraServiceImpl implements  ICompraServicio {

    @Autowired
    IClienteRepo clienteRepo;
    @Autowired
    ICompraRepo compraRepo;
    @Autowired
    IProductoRepo productoRepo;

    @Override
    public Optional<Compra> buscarPorId(Long id) {
        return compraRepo.findById(id);
    }

    @Override
    public boolean existePorId(Long id) {
        return compraRepo.existsById(id);
    }

    @Override
    public Set<Compra> buscarTodas() {
        return StreamSupport.stream(compraRepo.findAll().spliterator(), false).
                collect(Collectors.toSet());
    }

    @Override
    @Transactional
    public Optional<Compra> insertar(Compra nueva) {
        // Asumimos que la compra nueva no puede ser nula

        boolean nonNullClienteAndProducto = nueva.getProducto() != null && nueva.getCliente() != null;
        boolean existsClienteAndProducto = nonNullClienteAndProducto &&
                clienteRepo.existsById(nueva.getCliente().getDni()) &&
                productoRepo.existsById((nueva.getProducto().getNumRef()));

        if (!existsClienteAndProducto) {
            throw new RuntimeException("No existe el cliente o el producto introducidos");
        }

        nueva.setFecha(LocalDate.now());

        return Optional.of(compraRepo.save(nueva));
    }

    @Override
    public Optional<Compra> actualizar(Compra nueva) {
        return Optional.of(compraRepo.save(nueva));
    }

    @Override
    public boolean borrarPorId(Long id) {
        compraRepo.deleteById(id);
        return existePorId(id);
    }
}
