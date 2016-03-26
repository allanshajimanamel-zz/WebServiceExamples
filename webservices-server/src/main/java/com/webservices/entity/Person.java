package com.webservices.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author ALLAN Person class.
 */
@Entity
@Table(name = "person", schema = "webservices")
public class Person implements Serializable {
	/**
	 * The generated serial version UID.
	 */
	private static final long serialVersionUID = 393002674830979414L;

	/**
	 * Person name.
	 */
	@Column(name = "name")
	@NotNull
	private String name;

	/**
	 * Person age.
	 */
	@Column(name = "age")
	@NotNull
	private int age;

	/**
	 * Person id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

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
