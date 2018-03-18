package org.skiphackaton.services.order;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/order")
public class OrderService {
	
	@Inject
	private OrderDAO orderDAO;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Response create(Order order){
		System.out.println("creating order: " + order.getDeliveryAddress());
		order.setId(null);
		
		orderDAO.create(order);
		return Response.ok().build();
	}
	
	@GET
	@Path("/{orderId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Order searchById(@PathParam("orderId") Integer orderId){
		Order order = orderDAO.searchById(orderId);
		return order;
	}
	
}
