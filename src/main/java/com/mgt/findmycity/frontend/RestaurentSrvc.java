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

import com.mgt.findmycity.info.RestaurentInfo;
import com.mgt.findmycity.services.spring.RestaurentService;
import com.sun.jersey.spi.inject.Inject;

@Path("Restaurent")
public class RestaurentSrvc {

	@Inject
	RestaurentService restaurentService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/get/{id}")
	public RestaurentInfo getRestaurent(@PathParam("id") Integer Id) {
		RestaurentInfo restaurent = restaurentService.getRestaurent(Id);
		return restaurent;
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/delete/{id}")
	public void deleteRestaurent(@PathParam("id") Integer Id) {
		// Restaurent restaurent = restaurentService.getRestaurent(Id);
		// return getRestaurentInfo(restaurent);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAll")
	public Collection<RestaurentInfo> getRestaurents() {
		Collection<RestaurentInfo> restaurent = restaurentService
				.getRestaurents();
		return restaurent;
	}

	@PUT
	@Path("/Add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public RestaurentInfo createRestaurent(RestaurentInfo info) {
		restaurentService.save(info);
		return info;
	}
}
