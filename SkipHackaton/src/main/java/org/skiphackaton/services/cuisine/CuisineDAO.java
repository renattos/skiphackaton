package org.skiphackaton.services.cuisine;

import java.util.List;

import javax.persistence.TypedQuery;

import org.skiphackaton.configuration.BasicDAO;

public class CuisineDAO extends BasicDAO<Cuisine> {
	
	public Cuisine create(Cuisine cuisine){	
			getEntityManager().persist(cuisine);
			return cuisine;
	}

	public List<Cuisine> searchAll() {
		String query = "FROM Cuisine";
		TypedQuery<Cuisine> qry = getEntityManager().createQuery(query, Cuisine.class);
		return qry.getResultList();
	}

	public List<Cuisine> searchByText(String searchText) {
		String query = "FROM Cuisine c WHERE c.name LIKE :searchText";
		TypedQuery<Cuisine> qry = getEntityManager().createQuery(query, Cuisine.class);
		qry.setParameter("searchText", "%" + searchText + "%");
		return qry.getResultList();
	}
}
