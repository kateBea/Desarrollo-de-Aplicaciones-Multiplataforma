package com.example.demo.servicio;

import com.example.demo.modelo.Compra;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public interface ICompraServicio {
    Optional<Compra> buscarPorId(Long id);
    boolean existePorId(Long id);
    Set<Compra> buscarTodas();

    Optional<Compra> insertar(Compra nueva);
    Optional<Compra> actualizar(Compra nueva);

    boolean borrarPorId(Long id);
}
