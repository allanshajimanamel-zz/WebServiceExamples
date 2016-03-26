package com.webservices.interfaces;

import java.util.List;

import javax.ejb.Local;

import com.webservices.exceptions.PersonNotExistException;
import com.webservices.to.PersonTO;

@Local
public interface PersonLocal {

	/**
	 * Adds a professor to DB.
	 *
	 * @param p
	 *            instance of {@link PersonTO} to save.
	 * @return true for success else fail.
	 */
	public boolean addPerson(PersonTO p);

	/**
	 * Deletes person in DB with given ID.
	 *
	 * @param id
	 *            Id of person to delete.
	 * @return true for success else fail.
	 * @throws PersonNotExistException
	 */
	public boolean deletePerson(Long id) throws PersonNotExistException;

	/**
	 * Gets person in DB with given ID.
	 *
	 * @param id
	 *            Id of person to get.
	 * @return instance of {@link PersonTO} to get.
	 * @throws PersonNotExistException
	 */
	public PersonTO getPerson(Long id) throws PersonNotExistException;

	/**
	 * Gets all person in DB.
	 *
	 * @return {@link List} of {@link PersonTO}
	 */
	public List<PersonTO> getAllPersons();
}
