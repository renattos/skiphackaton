package org.skiphackaton.services.test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("test2")
public class TestService2 {
	
	@PersistenceContext(unitName = "SkipDS")
	private EntityManager em;
	
	@GET
	public String test(){
		TesteEntity entity = em.find(TesteEntity.class, 1);
		return "{id: " + entity.getId() + ", name: " + entity.getDescription() + "}";
	}

}
