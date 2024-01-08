package org.app;

import java.util.ArrayList;
import java.util.List;

import org.utilidades.Input;

public class Application implements Runnable {
	private List<OpcionMenu> opciones;
	
	public Application() {
		// Inicializar el contexto
		Contexto.init("org.instituto");
		Contexto.debugRun();
		
		// Para poder leer de consola
		Input.init();
		
		opciones = new ArrayList<>();
		
		// Opciones de gestión
		opciones.add(Opcion1.builder().descripcion("Leer instituto").build());
		opciones.add(Opcion2.builder().descripcion("Eliminar profesor").build());
		opciones.add(Opcion3.builder().descripcion("Localizar persona").build());
		opciones.add(Opcion4.builder().descripcion("Convocar sesión de tutoría conjunta").build());
		opciones.add(Opcion5.builder().descripcion("Ejecutar queries").build());
		
		// Opción de salida
		opciones.add(OpcionSalir.builder().descripcion("Salir del programa").build());
	}

	@Override
	public void run() {
		int opcion = 0;
		final int SALIR = opciones.size() - 1;
		
		do {
			mostrarOpciones();
			
			opcion = leerOpcion();
			procesarOpcion(opcion);
		} while (opcion != SALIR);
	}

	private void procesarOpcion(int opcion) {
		if (opcion < 0 || opcion >= opciones.size()) {
			System.err.println("Índice no válido");
			return;
		}
		
		opciones.get(opcion).accion();
	}

	private int leerOpcion() {
		Integer resultado = Input.leerEntero("Introduce un índice por favor: ");
		
		return resultado == null ? -1 : resultado;
	}

	private void mostrarOpciones() {
		int contador = 0;
		for (OpcionMenu opcion : opciones) {
			System.out.println(contador + ". " + opcion.getDescripcion());
			
			++contador;
		}
		
		
		System.out.println();
	}
}
