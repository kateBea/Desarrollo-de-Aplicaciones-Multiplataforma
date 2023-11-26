package org.dam2.banco.acciones;

import org.dam2.banco.modelo.Cuenta;
import org.dam2.utilidadesmenu.MenuAction;

import daw.com.Teclado;

public class HacerTransferencia extends AccionBanco implements MenuAction {

	@Override
	public void doMenuAction() {
		// TODO Auto-generated method stub
		String nccOrigen, nccDestino;
		float cantidad;
		Cuenta cuentaOrigen, cuentaDestino;
		
		// Leer cuenta origen
		System.out.println("Cuenta origen");
		nccOrigen = UtilidadesBanco.leerNCC();
		
		// Leer cuenta destino
		System.out.println("Cuenta destino");
		nccDestino = UtilidadesBanco.leerNCC();
		
		// Leer cantidad
		do
		{
			cantidad = Teclado.leerFloat("cantidad: ");
		}while(cantidad <= 0);
		
		cuentaOrigen = cuentaDAO.findById(nccOrigen).get();
		cuentaDestino = cuentaDAO.findById(nccDestino).get();
		
		if (cuentaOrigen.transferir(cantidad))
		{	
			// ingresar la cantidad en la cuenta destino
			cuentaDestino.ingresar(cantidad);

			// actualizar cuentas en la BBDD
			cuentaDAO.update(cuentaOrigen);
			cuentaDAO.update(cuentaDestino);
			
			System.out.println("Transferencia realizada correctamente");
			
		}
		else
		{
			System.out.println("No se ha podido realizar la transferencia");
			System.out.println("Cantidad máxima a transferir :" + 
						(cuentaOrigen.getSaldo() - cuentaOrigen.maximoNegativo()));
		}

	}

}
