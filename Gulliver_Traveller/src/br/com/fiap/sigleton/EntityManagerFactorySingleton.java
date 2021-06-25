package br.com.fiap.sigleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {
	private static EntityManagerFactory con;

	public static EntityManagerFactory getInstance() {
		if (con == null) {
			con = Persistence.createEntityManagerFactory("oracle");
		}
		return con;
	}

	private EntityManagerFactorySingleton() {
	}
}
