package com.dam2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InyectarDependencias implements CommandLineRunner {

	@Autowired
	@Qualifier("Barcelona")
	private IWeatherService service;
	//@Autowired private Weather weather;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Voy a crear weather");
		Weather weather = new Weather();
		
		weather.setService(service);
		weather.setCiudad("Madrid");
		weather.update();
		
		System.out.println("ciudad: " + weather.getCiudad());
		System.out.println("Temperatura: " + weather.getTemperatura());
		System.out.println("Lluvia: " + weather.getLluvia());
		System.out.println("Polucion: " + weather.getPolucion());

		
		weather.setCiudad("Toledo");
		weather.update();
		
		System.out.println("ciudad: " + weather.getCiudad());
		System.out.println("Temperatura: " + weather.getTemperatura());
		System.out.println("Lluvia: " + weather.getLluvia());
		System.out.println("Polucion: " + weather.getPolucion());

	}



}
