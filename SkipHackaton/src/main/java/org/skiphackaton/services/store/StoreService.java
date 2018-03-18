package org.skiphackaton.services.store;

import java.util.ArrayList;
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

@Path("/store")
public class StoreService {
	
	@Inject
	private StoreDAO storeDAO;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Response create(Store store){
		System.out.println("creating store: " + store.getName());
		store.setId(null);
		storeDAO.create(store);
		return Response.ok().build();
	}
	
	@GET
	@Path("/{storeId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Store searchById(@PathParam("storeId") Integer storeId){
		
		return storeDAO.searchById(storeId);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Store> searchAll(){
		return storeDAO.searchAll();
	}
	
	@GET
	@Path("/search/{searchText}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Store> searchByText(@PathParam("searchText") String searchText){
		if(searchText == null || searchText.trim().isEmpty()){
			return searchAll();
		}
		
		return storeDAO.searchByText(searchText);
	}
	
	public List<Store> searchByCuisine(Integer cuisineId){
		if(cuisineId == null){
			return new ArrayList<>();
		}
		
		return storeDAO.searchByCuisine(cuisineId);
	}
	
}
