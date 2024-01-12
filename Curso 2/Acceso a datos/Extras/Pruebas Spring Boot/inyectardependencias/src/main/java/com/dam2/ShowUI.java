package com.dam2;

public class ShowUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IWeatherService service = new WeatherService ();
		
		//Weather weather = new Weather("Madrid", service);
		
		Weather weather = new Weather("Madrid");
		weather.setService(service);
		
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
