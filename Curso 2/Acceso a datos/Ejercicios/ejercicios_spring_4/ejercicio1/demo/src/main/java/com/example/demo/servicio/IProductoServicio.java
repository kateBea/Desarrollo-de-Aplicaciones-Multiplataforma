package com.example.demo.servicio;

import com.example.demo.modelo.Producto;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public interface IProductoServicio {
    Optional<Producto> buscarPorId(String numRef);
    boolean existePorId(String numRef);
    Set<Producto> buscarTodos();

    Optional<Producto> insertar(Producto nuevo);
    Optional<Producto> actualizar(Producto nuevo);

    boolean borrarPorId(String numRef);
}
