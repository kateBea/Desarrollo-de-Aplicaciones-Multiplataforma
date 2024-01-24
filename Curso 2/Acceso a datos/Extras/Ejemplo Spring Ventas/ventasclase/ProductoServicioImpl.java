package com.dam2.ventas.servicio;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dam2.ventas.modelo.Producto;
import com.dam2.ventas.repositorio.ProductoRepositorio;

@Service
public class ProductoServicioImpl implements ProductoServicio {

	@Autowired
	ProductoRepositorio productoDAO;
	@Override
	public Optional<Producto> insertar(Producto producto) {
		// TODO Auto-generated method stub
		Optional<Producto> p = Optional.empty();
		if (!productoDAO.existsById(producto.getReferencia()))
		{
			p = Optional.of(productoDAO.save(producto));
		}
		
		return p;
	}

	@Override
	public boolean eliminar(Producto producto) {
		// TODO Auto-generated method stub
		boolean exito = false;
		
		if (productoDAO.existsById(producto.getReferencia()))
		{
			productoDAO.delete(producto);
			exito = true;
		}
		return exito;
	}

	@Override
	public Stream<Producto> obtenerProductos() {
		// TODO Auto-generated method stub
		return ((List<Producto>) productoDAO.findAll()).stream();
	}

	@Override
	public Optional<Producto> obtenerProducto(String ref) {
		// TODO Auto-generated method stub
		return productoDAO.findById(ref);
	}

}
