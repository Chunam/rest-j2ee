package org.phuong.resources;

import java.util.Date;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import org.phuong.model.RestResponse;
import org.phuong.model.SimpleObject;
import org.phuong.services.HeroesServiceMock;
import org.phuong.services.MyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Example resource class hosted at the URI path "/"
 */
@Path("/")
@Stateless
public class MyResource {

	private final static Logger log = LoggerFactory.getLogger(MyResource.class);

	@Inject
	MyService myService;

	@GET
	@Path("/heroes")
	@Produces(MediaType.APPLICATION_JSON)
	// @RolesAllowed({"admin", "user"})
	public List<SimpleObject> getHeroes(@Context SecurityContext sc) {
		log.info("Service says : " + myService.sayHello());
//		log.info("Getting heroes, principal : " + sc.getUserPrincipal().getName());
		return myService.getHeroes();
		// return HeroesServiceMock._instance.getHeroes();
	}

	@GET
	@Path("/hero/{id: [0-9]+}")
	@Produces(MediaType.APPLICATION_JSON)
	// @RolesAllowed({"admin", "user"})
	public SimpleObject getHero(@PathParam("id") int index, @Context SecurityContext sc) {
		log.info("Getting hero id = " + index);
		return myService.getHero(index);
	}

	@PUT
	@Path("/hero/{id: [0-9]+}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@RolesAllowed({ "admin" })
	public SimpleObject putHero(SimpleObject json, @PathParam("id") int index) {
		log.info("Saving hero id = " + index);
		return myService.saveHero(json);
	}

	@GET
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	@PermitAll
	public RestResponse verifyUser(@Context SecurityContext sc) {
		log.info("Verifying user = " + sc.getUserPrincipal().getName());
		RestResponse resp = new RestResponse();
		resp.setSuccess(true);
		resp.setPermissions(getPermissions(sc.getUserPrincipal().getName()));
		return resp;
	}

	// MOCK user permissions
	private String[] getPermissions(String name) {
		String[] permissions = null;

		switch (name) {
		case "user":
			permissions = new String[] { "VIEW_LIST", "VIEW_DASHBOARD" };
			break;
		case "admin":
			permissions = new String[] { "VIEW_LIST", "VIEW_DASHBOARD", "EDIT_MODEL" };
			break;
		}
		return permissions;
	}

}
