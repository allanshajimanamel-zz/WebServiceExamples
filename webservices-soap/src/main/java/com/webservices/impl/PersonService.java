package com.webservices.impl;

import java.util.List;

import javax.naming.NamingException;

import com.webservices.exceptions.PersonNotExistException;
import com.webservices.to.PersonTO;

/**
 * @author ALLAN
 *
 */
public interface PersonService {
	/**
	 * Adds a person to DB.
	 *
	 * @param p
	 *            instance of {@link PersonTO} to save.
	 * @return true for success else fail.
	 *
	 * @throws NamingException
	 */
	public boolean addPerson(PersonTO p) throws NamingException;

	/**
	 * Deletes person in DB with given ID.
	 *
	 * @param id
	 *            Id of person to delete.
	 * @return true for success else fail.
	 * @throws PersonNotExistException
	 * @throws NamingException
	 */
	public boolean deletePerson(Long id) throws PersonNotExistException,
	NamingException;

	/**
	 * Gets person in DB with given ID.
	 *
	 * @param id
	 *            Id of person to get.
	 * @return instance of {@link PersonTO} to get.
	 * @throws PersonNotExistException
	 * @throws NamingException
	 */
	public PersonTO getPerson(Long id) throws PersonNotExistException,
	NamingException;

	/**
	 * Gets all person in DB.
	 *
	 * @return {@link List} of {@link PersonTO}
	 * @throws NamingException
	 */
	public List<PersonTO> getAllPersons() throws NamingException;
}
