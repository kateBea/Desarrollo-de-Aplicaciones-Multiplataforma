package org.dam2.modelo;

public enum FormatoProducto {
	LATA,
	BRICK,
	BOLSA,
	DESCONOCIDO;
	
	public static FormatoProducto fromStr(String str) {
		switch (str) {
			case "lata":  return LATA;
			case "brick":  return BRICK;
			case "bolsa":  return BOLSA;
			default: return  DESCONOCIDO;
		}
	}
}
