package org.skiphackaton.services.product;

import java.util.List;

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

@Path("/product")
public class ProductService {
	
	@Inject
	private ProductDAO productDAO;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Response create(Product product){
		System.out.println("creating product: " + product.getName());
		product.setId(null);
		productDAO.create(product);
		return Response.ok().build();
	}
	
	@GET
	@Path("/{productId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Product searchById(@PathParam("productId") Integer productId){
		
		return productDAO.searchById(productId);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> searchAll(){
		return productDAO.searchAll();
	}
	
	@GET
	@Path("/search/{searchText}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> searchByText(@PathParam("searchText") String searchText){
		if(searchText == null || searchText.trim().isEmpty()){
			return searchAll();
		}
		
		return productDAO.searchByText(searchText);
	}
	
}
