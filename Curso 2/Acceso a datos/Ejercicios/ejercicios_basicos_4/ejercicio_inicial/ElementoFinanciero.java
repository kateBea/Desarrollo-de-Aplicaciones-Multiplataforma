package com.dam2.pruebaMaven;

public class ElementoFinanciero {
	private String segmento;
	private String pais;
	private String tipoProducto;
	private String descuento;
	private float unidadesVendidas;
	private float precioFabricacion;
	private float pvp;

	
	
	
	public ElementoFinanciero() {
		
	}


	public ElementoFinanciero(String segmento, String pais, String tipoProducto, String descuento,
			float unidadesVendidas, float precioFabricacion, float pvp) {
	
		this.segmento = segmento;
		this.pais = pais;
		this.tipoProducto = tipoProducto;
		this.descuento = descuento;
		this.unidadesVendidas = unidadesVendidas;
		this.precioFabricacion = precioFabricacion;
		this.pvp = pvp;

	}

	
	public String getSegmento() {
		return segmento;
	}

	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public String getDescuento() {
		return descuento;
	}

	public void setDescuento(String descuento) {
		this.descuento = descuento;
	}

	public float getUnidadesVendidas() {
		return unidadesVendidas;
	}

	public void setUnidadesVendidas(float unidadesVendidas) {
		this.unidadesVendidas = unidadesVendidas;
	}

	public float getPrecioFabricacion() {
		return precioFabricacion;
	}

	public void setPrecioFabricacion(float precioFabricacion) {
		this.precioFabricacion = precioFabricacion;
	}

	public float getPvp() {
		return pvp;
	}

	public void setPvp(float pvp) {
		this.pvp = pvp;
	}


	
	
	public static ElementoFinanciero fromCSV (String linea)
	{
		ElementoFinanciero elemento =  new ElementoFinanciero ();
		
		String args[] = linea.split(";");
		elemento.segmento = args[0];
		elemento.pais = args[1] ;
		elemento.tipoProducto = args[2] ;
		elemento.descuento = args[3];
		elemento.unidadesVendidas = Float.parseFloat(args[4]);
		elemento.precioFabricacion =  Float.parseFloat(args[5]);
		elemento.pvp =  Float.parseFloat(args[6]);
		
		return elemento;
				
	}
	

}
