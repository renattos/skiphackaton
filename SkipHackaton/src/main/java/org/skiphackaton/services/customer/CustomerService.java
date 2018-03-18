package org.skiphackaton.services.customer;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.skiphackaton.services.auth.AuthenticationService;

@Path("/customer")
public class CustomerService {
	
	@Inject
	private AuthenticationService authService;
	
	@Inject
	private CustomerDAO customerDAO;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Response create(Customer customer){
		System.out.println("customer mail: " + customer.getEmail());
		customer.setId(null);
		customerDAO.create(customer);
		return Response.ok().build();
	}
	
	@GET
	@Path("/auth")
	public Response auth(@QueryParam("email") String email, @QueryParam("password") String password, @Context HttpServletResponse resp){
		return authService.auth(email, password, resp);
	}
}
