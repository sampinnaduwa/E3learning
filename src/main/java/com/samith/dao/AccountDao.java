package com.samith.dao;

import com.samith.model.Account;

public interface AccountDao extends GenericDao<Integer, Account> {
	
	void saveAccount(Account account);

}
