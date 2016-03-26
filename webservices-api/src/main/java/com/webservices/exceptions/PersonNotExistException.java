package com.webservices.exceptions;

/**
 * @author ALLAN
 *
 */
public class PersonNotExistException extends Exception {

	/**
	 * Generated serial version UID.
	 */
	private static final long serialVersionUID = -269719246413992102L;

	/**
	 * Constructor.
	 *
	 * @param id
	 *            Id of person who is not found.
	 */
	public PersonNotExistException(Long id) {
		super("Person with id: " + id + " does not exist");
	}

	/**
	 * Constructor.
	 */
	public PersonNotExistException() {
		super("Person does not exist");
	}

	/**
	 * Constructor.
	 *
	 * @param message
	 *            The exception message.
	 */
	public PersonNotExistException(String message) {
		super(message);
	}
}
