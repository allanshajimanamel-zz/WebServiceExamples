package com.webservices.impl;

import java.util.List;
import java.util.Properties;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.webservices.exceptions.PersonNotExistException;
import com.webservices.interfaces.PersonLocal;
import com.webservices.to.PersonTO;

@WebService
public class PersonServiceImpl implements PersonService {

	/**
	 * Adds a person to DB.
	 *
	 * @param p
	 *            instance of {@link PersonTO} to save.
	 * @return true for success else fail.
	 */
	@Override
	@WebMethod
	public boolean addPerson(PersonTO p) throws NamingException {
		boolean result = getPersonLocalInterface().addPerson(p);
		return result;
	}

	/**
	 * Deletes person in DB with given ID.
	 *
	 * @param id
	 *            Id of person to delete.
	 * @return true for success else fail.
	 * @throws PersonNotExistException
	 * @throws NamingException
	 */
	@Override
	@WebMethod
	public boolean deletePerson(Long id) throws PersonNotExistException,
	NamingException {
		boolean result = getPersonLocalInterface().deletePerson(id);
		return result;
	}

	/**
	 * Gets person in DB with given ID.
	 *
	 * @param id
	 *            Id of person to get.
	 * @return instance of {@link PersonTO} to get.
	 * @throws PersonNotExistException
	 * @throws NamingException
	 */
	@Override
	@WebMethod
	public PersonTO getPerson(Long id) throws PersonNotExistException,
	NamingException {
		return getPersonLocalInterface().getPerson(id);
	}

	/**
	 * Gets all person in DB.
	 *
	 * @return {@link List} of {@link PersonTO}
	 * @throws NamingException
	 */
	@Override
	@WebMethod
	public List<PersonTO> getAllPersons() throws NamingException {
		return getPersonLocalInterface().getAllPersons();
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
