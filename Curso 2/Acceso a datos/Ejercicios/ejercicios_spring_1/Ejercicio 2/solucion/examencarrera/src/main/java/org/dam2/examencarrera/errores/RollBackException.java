package org.dam2.examencarrera.errores;

public class RollBackException extends RuntimeException {
	private String mensaje;

	public RollBackException() {

		this.mensaje = "error realizando transacción...";
	}
	public RollBackException(String mensaje) {
		super();
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	

}
