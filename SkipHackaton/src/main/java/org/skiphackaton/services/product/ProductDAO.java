package org.skiphackaton.services.product;

import java.util.List;

import javax.persistence.TypedQuery;

import org.skiphackaton.configuration.BasicDAO;

public class ProductDAO extends BasicDAO<Product> {
	
	public Product create(Product store){	
			getEntityManager().persist(store);
			return store;
	}

	public List<Product> searchAll() {
		String query = "FROM Store";
		TypedQuery<Product> qry = getEntityManager().createQuery(query, Product.class);
		return qry.getResultList();
	}

	public List<Product> searchByText(String searchText) {
		String query = "FROM Store s WHERE s.name LIKE :searchText";
		TypedQuery<Product> qry = getEntityManager().createQuery(query, Product.class);
		qry.setParameter("searchText", "%" + searchText + "%");
		return qry.getResultList();
	}

	public Product searchById(Integer storeId) {
		String query = "FROM Store s WHERE s.id = :storeId";
		TypedQuery<Product> qry = getEntityManager().createQuery(query, Product.class);
		qry.setParameter("storeId", storeId);
		return qry.getSingleResult();
	}

	public List<Product> searchByCuisine(Integer cuisineId) {
		String query = "FROM Store s WHERE s.cuisineId = :cuisineId";
		TypedQuery<Product> qry = getEntityManager().createQuery(query, Product.class);
		qry.setParameter("cuisineId", cuisineId);
		return qry.getResultList();
	}
}
