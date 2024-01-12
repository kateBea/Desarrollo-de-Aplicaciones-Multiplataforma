package com.dam2;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class Weather {
	private int temperatura;
	private int lluvia;
	private int polucion;
	
	//@Autowired private IWeatherService service;
	private IWeatherService service;
	private String ciudad;
	
	public Weather ()
	{
		
	}
	public Weather (String ciudad,IWeatherService service)
	{
		this.ciudad = ciudad;
		this.service = service;
	}
	
	
	
	public Weather(String ciudad) {
		this.ciudad = ciudad;
	}



	public void setService(IWeatherService service) {
		this.service = service;
	}



	public int getTemperatura() {
		return temperatura;
	}



	public int getLluvia() {
		return lluvia;
	}



	public int getPolucion() {
		return polucion;
	}



	
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}



	public String getCiudad() {
		return ciudad;
	}



	public void update ()
	{
		Map<String, Integer> data;
		
		data = service.getDataFrom(ciudad);
		
		temperatura = data.get("temperatura");
		lluvia = data.get("lluvia");
		polucion = data.get("polucion");
	}

}
