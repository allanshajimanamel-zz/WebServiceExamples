package com.webservices.util;

import java.util.ArrayList;
import java.util.List;

import com.webservices.entity.Person;
import com.webservices.to.PersonTO;

/**
 * @author ALLAN
 *
 */
public class PersonConverter {

	/**
	 * Converts {@link PersonTO} to {@link Person}
	 *
	 * @param personTO
	 * @return {@link Person}
	 */
	public static Person convertPersonTOToPerson(PersonTO personTO) {
		Person person = new Person();
		person.setId(personTO.getId());
		person.setAge(personTO.getAge());
		person.setName(personTO.getName());
		return person;
	}

	/**
	 * Converts {@link PersonTO} to {@link Person}
	 *
	 * @param personTO
	 * @return {@link Person}
	 */
	public static PersonTO convertPersonToPersonTO(Person person) {
		PersonTO personTO = new PersonTO();
		personTO.setId(person.getId());
		personTO.setAge(person.getAge());
		personTO.setName(person.getName());
		return personTO;
	}

	/**
	 * Converts {@link List} of {@link Person} to {@link List} of {link
	 * PersonTO}
	 *
	 * @param persons
	 *            {@link List} of {@link Person} to convert.
	 * @return {@link List} of {link PersonTO}
	 */
	public static List<PersonTO> convertToPersonTOList(List<Person> persons) {
		List<PersonTO> personTOs = new ArrayList<>();
		for (Person person : persons) {
			PersonTO personTO = new PersonTO();
			personTO.setId(person.getId());
			personTO.setAge(person.getAge());
			personTO.setName(person.getName());
			personTOs.add(personTO);
		}
		return personTOs;
	}
}
