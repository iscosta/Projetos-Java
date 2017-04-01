package br.com.fiap.singleton;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class EMFactorySingleton {
	
	private static EntityManager factory;
	
	private EMFactorySingleton() { }
	
	public static EntityManager getInstance(){
		if (factory == null){
			factory = 
		Persistence
		.createEntityManagerFactory("CLIENTE_ORACLE")
		.createEntityManager();
		}
		return factory;
	}
}






