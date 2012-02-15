package com.mgt.findmycity.frontend;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mgt.findmycity.domain.Restaurent;
import com.mgt.findmycity.domain.RestaurentMenu;
import com.mgt.findmycity.services.spring.RestaurentService;
import com.sun.jersey.spi.inject.Inject;

@Path("Restaurent")
public class RestaurentSrvc {

	@Inject
	RestaurentService restaurentService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/get/{id}")
	public Restaurent getRestaurent(@PathParam("id") Integer Id) {
		Restaurent restaurent = restaurentService.getRestaurent(Id);
		return restaurent;
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/delete/{id}")
	public void deleteRestaurent(@PathParam("id") Integer Id) {
		Restaurent entity = new Restaurent();
		entity.setId(Id);
		restaurentService.delete(entity);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAll")
	public Collection<Restaurent> getRestaurents() {
		Collection<Restaurent> restaurent = restaurentService
				.getRestaurents();
		return restaurent;
	}

	@PUT
	@Path("/Add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Restaurent createRestaurent(Restaurent info) {
		restaurentService.save(info);
		return info;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/search/category/{name}")
	public Collection<Restaurent> getRestaurentsByCategory(@PathParam("name") String category) {
		Collection<Restaurent> restaurents = restaurentService.findByCategory(category);
		return restaurents;
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/menu/get/{id}")
	public Collection<RestaurentMenu> getRestaurentMenu(@PathParam("id") Integer restaurentId) {
		Collection<RestaurentMenu> restaurents = restaurentService.getRestaurentMenu(restaurentId);
		return restaurents;
	}
	
}
