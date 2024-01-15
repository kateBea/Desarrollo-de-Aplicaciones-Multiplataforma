package org.dam2.examenjpa;

import org.dam2.modelo.Cliente;
import org.dam2.modelo.NoPerecedero;
import org.dam2.modelo.Perecedero;
import org.dam2.modelo.Producto;
import org.dam2.modelo.Proveedor;
import org.dam2.modelo.Venta;
import org.dam2.utilidadeshibernate.GenericJPADAO;

public class Contexto {
	private static final String PERSISTANCE_UNIT_NAME = "examen";
	
	private static GenericJPADAO<Producto, String> daoProducto = null;
	private static GenericJPADAO<Perecedero, String> daoPerec = null;
	private static GenericJPADAO<NoPerecedero, String> daoNoPerec = null;
	private static GenericJPADAO<Proveedor, String> daoProveedor = null;
	private static GenericJPADAO<Venta, Integer> daoVenta = null;
	private static GenericJPADAO<Cliente, String> daoCliente = null;
	
	public static GenericJPADAO<Producto, String> getDaoProducto() {
		if (daoProducto == null) {
			daoProducto = 
				new GenericJPADAO<>(Producto.class, PERSISTANCE_UNIT_NAME);
		}
		
		return daoProducto;
	}
	
	public static GenericJPADAO<Perecedero, String> getDaoPerec() {
		if (daoPerec == null) {
			daoPerec = 
				new GenericJPADAO<>(Perecedero.class, PERSISTANCE_UNIT_NAME);
		}
		
		return daoPerec;
	}
	
	public static GenericJPADAO<NoPerecedero, String> getDaoNoPerec() {
		if (daoNoPerec == null) {
			daoNoPerec = 
				new GenericJPADAO<>(NoPerecedero.class, PERSISTANCE_UNIT_NAME);
		}
		
		return daoNoPerec;
	}
	
	public static GenericJPADAO<Proveedor, String> getDaoProveedor() {
		if (daoProveedor == null) {
			daoProveedor = 
				new GenericJPADAO<>(Proveedor.class, PERSISTANCE_UNIT_NAME);
		}
		
		return daoProveedor;
	}
	
	public static GenericJPADAO<Venta, Integer> getDaoVenta() {
		if (daoVenta == null) {
			daoVenta = 
				new GenericJPADAO<>(Venta.class, PERSISTANCE_UNIT_NAME);
		}
		
		return daoVenta;
	}
	
	public static GenericJPADAO<Cliente, String> getDaoCliente() {
		if (daoCliente == null) {
			daoCliente = 
				new GenericJPADAO<>(Cliente.class, PERSISTANCE_UNIT_NAME);
		}
		
		return daoCliente;
	}
}
