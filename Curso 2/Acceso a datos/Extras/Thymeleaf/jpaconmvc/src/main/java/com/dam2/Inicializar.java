package com.dam2;

import org.springframework.beans.factory.InitializingBean;

public class Inicializar implements InitializingBean{

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("aplicación inicializada....");
		
	}

}
