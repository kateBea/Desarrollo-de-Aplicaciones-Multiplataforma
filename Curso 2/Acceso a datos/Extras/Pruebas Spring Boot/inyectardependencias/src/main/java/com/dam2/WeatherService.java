package com.dam2;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
//@Primary
@Qualifier("Madrid")
public class WeatherService implements IWeatherService {
	
	public WeatherService ()
	{
		System.out.println("Construyendo Weather Service de Madrid .....");
	}
	
	public Map<String,Integer> getDataFrom (String ciudad)
	{
		Map<String,Integer> data = new TreeMap<>();
		if (ciudad.equals("Madrid"))
		{
			data.put("temperatura", 25);
			data.put("lluvia", 5);
			data.put("polucion", 40);
		}
		else
		{
			data.put("temperatura", 20);
			data.put("lluvia", 0);
			data.put("polucion", 20);
			
		}
		
		return data;
	}

}
