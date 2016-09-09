package com.webservices.to;

import java.io.Serializable;

/**
 * Person Transport Object class.
 *
 * @author ALLAN
 */
public class PersonTO implements Serializable {

	/**
	 * The generated serial version UID.
	 */
	private static final long serialVersionUID = 6611234071012922966L;

	/**
	 * Person name.
	 */
	private String name;

	/**
	 * Person age.
	 */
	private int age;

	/**
	 * Person id.
	 */
	private Long id;

	/**
	 * @param name
	 * @param age
	 * @param id
	 */
	public PersonTO(String name, int age, Long id) {
		super();
		this.name = name;
		this.age = age;
		this.id = id;
	}

	/**
	 * Constructor
	 */
	public PersonTO() {
		super();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return id + "::" + name + "::" + age;
	}

}
