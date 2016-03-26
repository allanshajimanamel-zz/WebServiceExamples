package com.webservices.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.webservices.entity.Person;
import com.webservices.exceptions.PersonNotExistException;
import com.webservices.to.PersonTO;

/**
 * Session Bean implementation class PersonDAO
 */
@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class PersonDAO {

	@PersistenceContext(unitName = "persistenceUnit")
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public PersonDAO() {
	}

	/**
	 * Adds a professor to DB.
	 *
	 * @param p
	 *            instance of {@link Person} to save.
	 * @return true for success else fail.
	 */
	public boolean addPerson(PersonTO p) {
		Person person = new Person();
		person.setAge(p.getAge());
		person.setName(p.getName());
		em.persist(person);
		return true;
	}

	/**
	 * Deletes person in DB with given ID.
	 *
	 * @param id
	 *            Id of person to delete.
	 * @return true for success else fail.
	 * @throws PersonNotExistException
	 */
	public boolean deletePerson(Long id) throws PersonNotExistException {
		Person p = em.find(Person.class, id);
		if (p != null) {
			em.remove(p);
		} else {
			throw new PersonNotExistException(id);
		}
		return true;

	}

	/**
	 * Gets person in DB with given ID.
	 *
	 * @param id
	 *            Id of person to get.
	 * @return instance of {@link Person} to get.
	 * @throws PersonNotExistException
	 */
	public Person getPerson(Long id) throws PersonNotExistException {
		Person p = em.find(Person.class, id);
		if (p == null) {
			throw new PersonNotExistException(id);
		}
		return p;
	}

	/**
	 * Gets all person in DB.
	 *
	 * @return {@link List} of {@link Person}
	 */
	public List<Person> getAllPersons() {
		List persons = new ArrayList<Person>();
		persons = em.createQuery("SELECT o FROM Person o", Person.class)
				.getResultList();
		return persons;
	}

}
