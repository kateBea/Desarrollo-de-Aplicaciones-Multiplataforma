package org.dam2.modelo;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

import org.dam2.utilidadeshibernate.GenericJPADAO;

public class ProductoListener {
	@PostLoad
	@PostPersist
	@PostUpdate
	public void solicitar(Producto producto) {
		if (producto.getStock() < producto.getStockMinimo()) {
			producto.setStock(producto.getStock() + producto.getUnidadesPorPedido());
			System.out.println("Mandar correo a " + producto.getProveedor() + " por stock bajo de " + producto.getNombre());
		
			GenericJPADAO<Producto, String> dao = 
					new GenericJPADAO<Producto, String>(Producto.class, "examen");
				
			dao.save(producto);
		}
	}
}
