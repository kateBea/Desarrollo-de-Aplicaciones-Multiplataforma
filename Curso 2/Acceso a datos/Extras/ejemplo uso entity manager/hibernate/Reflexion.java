package org.dam2.hibernate;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Reflexion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Alumno a = Alumno.builder().id(1).firstName("miguel").fecha(LocalDate.now()).build();
		
		Object keyValue = getKey (a);
		System.out.println(keyValue);
		
	}
	
	public static Object getKey (Object object)  
	{
		
		String nameGet ;
		String atributo;
		Object valor = null;
		boolean key;
		
		Class<Alumno>  entityClass = Alumno.class;
		
		
		Predicate<Field> isKey = f -> Arrays.stream(f.getAnnotations()).anyMatch(a ->a.annotationType().getSimpleName().equals("Id"));
			
		Optional<Field> field = Arrays.stream(entityClass.getDeclaredFields()).filter(isKey).findFirst();
		
		if (field.isPresent())
		{
			Field f = field.get();
			nameGet = "get" + f.getName().substring(0, 1).toUpperCase()+ f.getName().substring(1);
			
			try {
				valor = entityClass.getDeclaredMethod(nameGet, null).invoke(object, null);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				valor = null;
			}
		}
		
		
				
		
		/*
		Field[] fields = entityClass.getDeclaredFields();

		
		for (Field f : fields)
		{
			nameGet = "get" + f.getName().substring(0, 1).toUpperCase()+ f.getName().substring(1);
			
			atributo =  f.getName();
			
			key = false;
			
			Annotation[] annotations = f.getAnnotations();
			
			for (Annotation annotation : annotations)
			{
				
				if (annotation.annotationType().getSimpleName().equals("Id"))
					key = true;
			}
			
			if (key)
				try {
					valor = entityClass.getDeclaredMethod(nameGet, null).invoke(object, null);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
						| NoSuchMethodException | SecurityException e) {
					// TODO Auto-generated catch block
					valor = null;
				}
			
			
		}
		
		*/
		return valor;
	}

}
