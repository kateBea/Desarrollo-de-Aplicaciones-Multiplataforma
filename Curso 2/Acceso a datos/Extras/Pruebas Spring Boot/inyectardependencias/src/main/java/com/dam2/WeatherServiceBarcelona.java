package com.dam2;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
//@Primary
@Qualifier("Barcelona")
public class WeatherServiceBarcelona implements IWeatherService {

	public WeatherServiceBarcelona ()
	{
		System.out.println("Construyendo Weather Service de Barcelona .....");
	}
	
	public Map<String,Integer> getDataFrom (String ciudad)
	{
		Map<String,Integer> data = new TreeMap<>();
		if (ciudad.equals("Barcelona"))
		{
			data.put("temperatura", 25);
			data.put("lluvia", 5);
			data.put("polucion", 40);
		}
		else
		{
			data.put("temperatura", 200);
			data.put("lluvia", 0);
			data.put("polucion", 100);
			
		}
		
		return data;
	}

}
