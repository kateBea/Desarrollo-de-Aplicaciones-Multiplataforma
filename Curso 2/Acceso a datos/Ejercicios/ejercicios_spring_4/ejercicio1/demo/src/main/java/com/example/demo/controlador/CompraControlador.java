package com.example.demo.controlador;

import com.example.demo.modelo.Cliente;
import com.example.demo.modelo.Compra;
import com.example.demo.modelo.Producto;
import com.example.demo.servicio.IClienteServicio;
import com.example.demo.servicio.ICompraServicio;
import com.example.demo.servicio.IProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tienda/compras")
public class CompraControlador {

    @Autowired
    @Qualifier("compraServiceImpl")
    ICompraServicio compraServicio;

    @Autowired
    @Qualifier("productoServiceImpl")
    IProductoServicio productoServicio;


    @Autowired
    @Qualifier("clienteServiceImpl")
    IClienteServicio clienteServicio;

    @GetMapping(value = "/consultar")
    ResponseEntity<List<Compra>> consultarTodas() {
        ResponseEntity<List<Compra>> respuesta;

        List<Compra> todas = compraServicio.buscarTodas().stream().toList();
        respuesta = new ResponseEntity<>(todas, HttpStatus.OK);

        return respuesta;
    }

    @GetMapping(value = "/consultar/{id}")
    ResponseEntity<Compra> consultarPorDni(@PathVariable Long id) {
        ResponseEntity<Compra> respuesta;
        Optional<Compra> cliente = compraServicio.buscarPorId(id);

        System.err.println("Client sent: " + id);

        respuesta = cliente.
                map(value -> new ResponseEntity<>(value, HttpStatus.OK)).
                orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));

        return respuesta;
    }

    @PostMapping("registrar")
    ResponseEntity<Long> registrar(
            @RequestParam(value = "dni", required = true) String dni,
            @RequestParam(value = "numRef", required = true) String numRef,
            @RequestParam(value = "cantidad", required = true) Integer cantidad
    ) {
        ResponseEntity<Long> respuesta = null;
        System.err.printf("User data: dni=[%s], numRef=[%s], cantidad=[%d]\n", dni, numRef, cantidad);

        Optional<Cliente> cliente = clienteServicio.buscarPorId(dni);
        Optional<Producto> producto = productoServicio.buscarPorId(numRef);

        if (cliente.isPresent() && producto.isPresent()) {
            Long id = -1L;

            try {
                Compra nueva = Compra.builder().
                        cliente(cliente.get()).
                        producto(producto.get()).
                        cantidad(cantidad).
                        build();

                compraServicio.insertar(nueva);
                id = nueva.getId();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

            respuesta = new ResponseEntity<>(id, HttpStatus.OK);
        } else {
            respuesta = new ResponseEntity<>(-1L, HttpStatus.NOT_FOUND);
        }

        return respuesta;
    }


}
