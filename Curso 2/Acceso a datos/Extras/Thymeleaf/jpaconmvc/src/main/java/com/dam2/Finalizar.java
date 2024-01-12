package com.dam2;

import org.springframework.beans.factory.DisposableBean;

public class Finalizar implements DisposableBean {

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Aplicación finalizada, cerrando conexiones abiertas");
	}

}
