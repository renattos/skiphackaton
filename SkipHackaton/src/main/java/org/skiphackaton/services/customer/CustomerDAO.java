package org.skiphackaton.services.customer;

import org.skiphackaton.configuration.BasicDAO;

public class CustomerDAO extends BasicDAO<Customer> {
	
	public Customer create(Customer customer){	
			getEntityManager().persist(customer);
			return customer;
	}
}
