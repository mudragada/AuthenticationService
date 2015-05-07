package com.ws.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;


@Path("/hello")
public class HelloWorldWS {
	@GET
	@Path("/{name}")
	public Response getMsg(@PathParam("name") String msg) { 
		String output = "Jersey say : " + msg;
		return Response.status(200).entity(output).build();
	}
}
