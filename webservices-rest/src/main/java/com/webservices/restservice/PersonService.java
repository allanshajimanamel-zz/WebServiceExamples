package com.webservices.restservice;

import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.webservices.exceptions.PersonNotExistException;
import com.webservices.interfaces.PersonLocal;
import com.webservices.to.PersonTO;

/**
 * @author ALLAN
 *
 */
@Path("/person")
public class PersonService {

	@GET
	@Path("/getallpersons")
	@Produces("application/json")
	public List<PersonTO> getAllPersons() throws NamingException {
		return getPersonLocalInterface().getAllPersons();
	}

	@POST
	@Path("/addperson")
	@Consumes("application/json")
	@Produces("application/json")
	public boolean addPerson(PersonTO person)
			throws NamingException {
		return getPersonLocalInterface().addPerson(person);
	}

	@GET
	@Path("/deleteperson/{id}")
	@Produces("application/json")
	public boolean deletePerson(@PathParam("id") Long id)
			throws NamingException, PersonNotExistException {
		return getPersonLocalInterface().deletePerson(id);
	}

	@GET
	@Path("/getperson/{id}")
	@Produces("application/json")
	public PersonTO getPerson(@PathParam("id") Long id) throws NamingException,
	PersonNotExistException {
		return getPersonLocalInterface().getPerson(id);
	}

	private PersonLocal getPersonLocalInterface() throws NamingException {
		Properties prop = new Properties();
		prop.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		Context context = new InitialContext(prop);
		PersonLocal personLocal = (PersonLocal) context
				.lookup("java:app/webservices-server-0.0.1-SNAPSHOT/PersonBCF!com.webservices.interfaces.PersonLocal");
		return personLocal;
	}
}
