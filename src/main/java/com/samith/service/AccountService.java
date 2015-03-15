package com.samith.service;

import java.util.List;

import com.samith.model.Account;

/**
 * The Interface AccountService.
 */
public interface AccountService {
	
	/**
	 * Creates the account.
	 *
	 * @param account the account
	 */
	void createAccount(Account account);
	
	/**
	 * Gets the accounts by name.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @return the accounts by name
	 */
	List<Account> getAccountsByName(String firstName, String lastName);

	/**
	 * Checks if is account exists.
	 *
	 * @param email the email
	 * @return true, if is account exists
	 */
	boolean isAccountExists(String email);

}
