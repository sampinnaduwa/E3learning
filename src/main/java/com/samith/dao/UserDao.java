package com.samith.dao;

import com.samith.model.User;

/**
 * The Interface UserDao.
 */
public interface UserDao {

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
