package com.webservices.restservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * @author ALLAN
 *
 */
@Path("/test")
public class TestService {

	@GET
	@Path("students")
	@Produces("application/json")
	public String getStudentList(){
		return "Test success";
	}

}
