package com.example.demo.controlador;

import com.example.demo.modelo.Cliente;
import com.example.demo.servicio.IClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/tienda/clientes")
public class ClienteControlador {

    @Autowired
    @Qualifier("clienteServiceImpl")
    IClienteServicio clienteServicio;

    @GetMapping(value = "/consultar")
    ResponseEntity<List<Cliente>> consultarTodos() {
        ResponseEntity<List<Cliente>> respuesta;

        List<Cliente> todos = clienteServicio.buscarTodos().stream().toList();
        respuesta = new ResponseEntity<>(todos, HttpStatus.OK);

        return respuesta;
    }

    @GetMapping(value = "/consultar/{dni}")
    ResponseEntity<Cliente> consultarPorDni(@PathVariable String dni) {
        ResponseEntity<Cliente> respuesta;
        Optional<Cliente> cliente = clienteServicio.buscarPorId(dni);

        respuesta = cliente.
                map(value -> new ResponseEntity<>(value, HttpStatus.OK)).
                orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

        return respuesta;
    }

    @PostMapping("registrar")
    ResponseEntity<Cliente> registrar(@RequestBody Cliente cliente) {
        ResponseEntity<Cliente> respuesta;

        Optional<Cliente> result = Optional.empty();

        try {
            result = clienteServicio.insertar(cliente);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        respuesta = result.
                map(value -> new ResponseEntity<>(value, HttpStatus.OK)).
                orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));

        return respuesta;
    }
}
