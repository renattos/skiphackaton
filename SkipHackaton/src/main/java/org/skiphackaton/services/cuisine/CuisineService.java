package org.skiphackaton.services.cuisine;

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

import org.skiphackaton.services.store.Store;
import org.skiphackaton.services.store.StoreService;

@Path("/cuisine")
public class CuisineService {
	
	@Inject
	private StoreService storeService;
	
	@Inject
	private CuisineDAO cuisineDAO;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Response create(Cuisine cuisine){
		System.out.println("creating cuisine: " + cuisine.getName());
		cuisine.setId(null);
		cuisineDAO.create(cuisine);
		return Response.ok().build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cuisine> searchAll(){
		return cuisineDAO.searchAll();
	}
	
	@GET
	@Path("/search/{searchText}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cuisine> searchByText(@PathParam("searchText") String searchText){
		if(searchText == null || searchText.trim().isEmpty()){
			return searchAll();
		}
		
		return cuisineDAO.searchByText(searchText);
	}
	
	@GET
	@Path("/{cuisineId}/stores")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Store> searchCuisinesStores(@PathParam("cuisineId") Integer cuisineId){
		
		return storeService.searchByCuisine(cuisineId);
	}
}
