package com.example.demo.controlador;

import com.example.demo.modelo.Producto;
import com.example.demo.servicio.IProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/tienda/productos")
public class ProductoControlador {

    @Autowired
    @Qualifier("productoServiceImpl") //inecesario
    IProductoServicio productoServicio;

    @GetMapping(value = "/consultar")
    ResponseEntity<List<Producto>> consultarTodos() {
        ResponseEntity<List<Producto>> respuesta;

        List<Producto> todos = productoServicio.buscarTodos().stream().toList();
        respuesta = new ResponseEntity<>(todos, HttpStatus.OK);

        return respuesta;
    }

    @GetMapping(value = "/consultar/{numRef}")
    ResponseEntity<Producto> consultarPorNumRef(@PathVariable String numRef) {
        ResponseEntity<Producto> respuesta;
        Optional<Producto> producto = productoServicio.buscarPorId(numRef);
        respuesta = new ResponseEntity<>(producto.orElse(null), HttpStatus.OK);

        return respuesta;
    }
}
