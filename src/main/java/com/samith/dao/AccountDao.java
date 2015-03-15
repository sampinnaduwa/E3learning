package com.samith.dao;

import java.util.List;

import com.samith.model.Account;

/**
 * The Interface AccountDao.
 */
public interface AccountDao extends GenericDao<Integer, Account> {
	
	/**
	 * Save account.
	 *
	 * @param account the account
	 */
	void saveAccount(Account account);

	/**
	 * Gets the accounts by name.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @return the accounts by name
	 */
	List<Account> getAccountsByName(String firstName, String lastName);

	/**
	 * Checks if is email exists.
	 *
	 * @param email the email
	 * @return true, if is email exists
	 */
	boolean isEmailExists(String email);

}
