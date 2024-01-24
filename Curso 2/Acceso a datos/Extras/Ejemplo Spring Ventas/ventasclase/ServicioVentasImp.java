package com.dam2.ventas.servicio;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;

import com.dam2.ventas.modelo.Usuario;
import com.dam2.ventas.modelo.Ventas;
import com.dam2.ventas.repositorio.ProductoRepositorio;
import com.dam2.ventas.repositorio.VentasRepositorio;

public class ServicioVentasImp implements ServicioVentas {
	@Autowired
	VentasRepositorio ventasDAO;
	@Autowired
	ProductoRepositorio productoDAO;
	
	@Override
	public Optional<Ventas> insertar(Ventas venta) {
		
		
		// TODO Auto-generated method stub
		if (venta.getProducto().getStock() > venta.getUnidades()&&
				venta.getUsuario().getSaldo() > venta.getProducto().getPvp() * venta.getUnidades())
					return Optional.of(ventasDAO.save(venta));
		else 
			return Optional.empty();
	}

	@Override
	public boolean eliminar(Usuario usuario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Stream<Ventas> obtenerVentas() {
		// TODO Auto-generated method stub
		return ((List<Ventas>) ventasDAO.findAll()).stream();
	}

}
