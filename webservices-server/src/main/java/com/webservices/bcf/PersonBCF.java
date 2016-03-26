package com.webservices.bcf;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.webservices.dao.PersonDAO;
import com.webservices.entity.Person;
import com.webservices.exceptions.PersonNotExistException;
import com.webservices.interfaces.PersonLocal;
import com.webservices.to.PersonTO;
import com.webservices.util.PersonConverter;

/**
 * Session Bean implementation class PersonBCF
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class PersonBCF implements PersonLocal {

	@EJB
	private PersonDAO personDAO;

	/**
	 * Default constructor.
	 */
	public PersonBCF() {
	}

	@Override
	public boolean addPerson(PersonTO p) {
		//Person person = PersonConverter.convertPersonTOToPerson(p);
		boolean result = personDAO.addPerson(p);
		return result;
	}

	@Override
	public boolean deletePerson(Long id) throws PersonNotExistException {
		boolean result = personDAO.deletePerson(id);
		return result;
	}

	@Override
	public PersonTO getPerson(Long id) throws PersonNotExistException {
		Person person = personDAO.getPerson(id);
		PersonTO personTO = PersonConverter.convertPersonToPersonTO(person);
		return personTO;
	}

	@Override
	public List<PersonTO> getAllPersons() {
		List<Person> persons = personDAO.getAllPersons();
		List<PersonTO> personTOs = PersonConverter.convertToPersonTOList(persons);
		return personTOs;
	}

}
