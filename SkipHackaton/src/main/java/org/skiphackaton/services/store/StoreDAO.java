package org.skiphackaton.services.store;

import java.util.List;

import javax.persistence.TypedQuery;

import org.skiphackaton.configuration.BasicDAO;

public class StoreDAO extends BasicDAO<Store> {
	
	public Store create(Store store){	
			getEntityManager().persist(store);
			return store;
	}

	public List<Store> searchAll() {
		String query = "FROM Store";
		TypedQuery<Store> qry = getEntityManager().createQuery(query, Store.class);
		return qry.getResultList();
	}

	public List<Store> searchByText(String searchText) {
		String query = "FROM Store s WHERE s.name LIKE :searchText";
		TypedQuery<Store> qry = getEntityManager().createQuery(query, Store.class);
		qry.setParameter("searchText", "%" + searchText + "%");
		return qry.getResultList();
	}

	public Store searchById(Integer storeId) {
		String query = "FROM Store s WHERE s.id = :storeId";
		TypedQuery<Store> qry = getEntityManager().createQuery(query, Store.class);
		qry.setParameter("storeId", storeId);
		return qry.getSingleResult();
	}

	public List<Store> searchByCuisine(Integer cuisineId) {
		String query = "FROM Store s WHERE s.cuisineId = :cuisineId";
		TypedQuery<Store> qry = getEntityManager().createQuery(query, Store.class);
		qry.setParameter("cuisineId", cuisineId);
		return qry.getResultList();
	}
}
