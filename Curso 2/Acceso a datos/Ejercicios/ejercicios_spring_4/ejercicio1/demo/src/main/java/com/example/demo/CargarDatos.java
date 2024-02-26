package com.example.demo;

import com.example.demo.modelo.Cliente;
import com.example.demo.modelo.Producto;
import com.example.demo.servicio.IClienteServicio;
import com.example.demo.servicio.IProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Set;

@Order(0)
@Component
public class CargarDatos implements CommandLineRunner {
    @Autowired
    @Qualifier("productoServiceImpl")
    IProductoServicio productoServicio;

    @Autowired
    @Qualifier("clienteServiceImpl")
    IClienteServicio clienteServicio;

    @Override
    public void run(String... args) throws Exception {
        Producto p1 = Producto.builder().numRef("123").nombre("pera").precio(12.22f).nombreProveedor("Mercadona").build();
        Producto p2 = Producto.builder().numRef("234").nombre("manzana").precio(13.21f).nombreProveedor("Bias").build();
        Producto p3 = Producto.builder().numRef("361").nombre("cereales").precio(10.27f).nombreProveedor("Stretch").build();
        Producto p4 = Producto.builder().numRef("281").nombre("tomate").precio(11.77f).nombreProveedor("M&M").build();

        Set.of(p1, p2, p3, p4).forEach(p -> productoServicio.insertar(p));

        Cliente c1 = Cliente.builder().dni("12345678T").nombre("client1").fechaAlta(LocalDate.now().minusDays(55)).build();
        Cliente c2 = Cliente.builder().dni("2658471G").nombre("client2").fechaAlta(LocalDate.now().minusYears(2)).build();

        Set.of(c1, c2).forEach(c -> clienteServicio.insertar(c));
    }
}
