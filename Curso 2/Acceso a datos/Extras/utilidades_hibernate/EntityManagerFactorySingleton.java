package org.dam2.utilidadeshibernate;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {
	
	private EntityManagerFactory emf;
		
	public static EntityManagerFactorySingleton singleton = null;
	
	private EntityManagerFactorySingleton (String persintenceUnitName)
	{
		emf = Persistence.createEntityManagerFactory(persintenceUnitName);
	}
	
	public static EntityManagerFactorySingleton getInstance (String persintenceUnitName)
	{
		if (singleton == null)
			singleton = new EntityManagerFactorySingleton (persintenceUnitName);
		
		return singleton;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	
}
