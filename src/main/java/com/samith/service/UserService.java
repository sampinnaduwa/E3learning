package com.samith.service;

import com.samith.model.User;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserService.
 */
public interface UserService {

	/**
	 * Gets the user.
	 *
	 * @param login the login
	 * @return the user
	 */
	public User getUser(String login);

	/**
	 * Save user.
	 *
	 * @param user the user
	 * @return the user
	 * @throws Exception the exception
	 */
	public User saveUser(User user) throws Exception; 
}
