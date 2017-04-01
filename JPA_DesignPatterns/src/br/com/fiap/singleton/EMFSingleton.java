package br.com.fiap.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMFSingleton {

	private static EntityManagerFactory factory;

	// Construtor privado, ninguem vai instanciar o Singleton
	private EMFSingleton() {

	}

	public static EntityManagerFactory getInstance() {

		if (factory == null) {

			factory = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");

		}

		return factory;
	}

}
