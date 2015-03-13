package com.samith.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.samith.dao.AccountDao;
import com.samith.model.Account;

@Repository
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountDao accountDao;
	
	@Transactional (propagation=Propagation.REQUIRED,
			rollbackFor=Exception.class)
	public void createAccount(Account account) {
		accountDao.persist(account);
	}

	@Transactional (propagation=Propagation.REQUIRED)
	public void saveAccount(Account account) {
		accountDao.saveAccount(account);
		
	}

}
