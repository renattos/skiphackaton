package org.skiphackaton.services.order;

import javax.persistence.TypedQuery;

import org.skiphackaton.configuration.BasicDAO;

public class OrderDAO extends BasicDAO<Order> {
	
	public Order create(Order order){	
			getEntityManager().persist(order);
			return order;
	}

	public Order searchById(Integer orderId) {
		String query = "FROM Order o WHERE o.id = :orderId";
		TypedQuery<Order> qry = getEntityManager().createQuery(query, Order.class);
		qry.setParameter("orderId", orderId);
		return qry.getSingleResult();
	}

}
