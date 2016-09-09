package com.webservices.restservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * @author ALLAN
 *
 */
@Path("/test")
public class TestService {

	@GET
	@Path("/{param}")
	public Response getStudentList(@PathParam("param") String msg){
		return Response.status(200).entity("test Success" + msg).build();
	}

}
