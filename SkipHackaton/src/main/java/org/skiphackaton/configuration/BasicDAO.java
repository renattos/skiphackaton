package org.skiphackaton.configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class BasicDAO<T> {

	@PersistenceContext(unitName = "SkipDS")
	private EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
}
