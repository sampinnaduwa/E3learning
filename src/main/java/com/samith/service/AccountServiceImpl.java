package com.samith.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.samith.dao.AccountDao;
import com.samith.model.Account;

/**
 * The Class AccountServiceImpl.
 */
@Service
public class AccountServiceImpl implements AccountService {

	/** The account dao. */
	@Autowired
	AccountDao accountDao;
	
	private static Logger log = Logger.getLogger(AccountServiceImpl.class);
	
	/* (non-Javadoc)
	 * @see com.samith.service.AccountService#createAccount(com.samith.model.Account)
	 */
	@Transactional (propagation=Propagation.REQUIRED,
			rollbackFor=Exception.class)
	public void createAccount(Account account) {
		accountDao.persist(account);
	}

	/* (non-Javadoc)
	 * @see com.samith.service.AccountService#getAccountsByName(java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional
	public List<Account> getAccountsByName(String firstName, String lastName) {
		List<Account> accountList = accountDao.getAccountsByName(firstName, lastName);
		for (Account account : accountList) {
			log.info("Account Course Objects "+account.getCourse());
			log.info("TITLE "+account.getCourse().getTitle());
		}
		return accountList;
	}

	/* (non-Javadoc)
	 * @see com.samith.service.AccountService#isAccountExists(java.lang.String)
	 */
	@Override
	public boolean isAccountExists(String email) {
		return accountDao.isEmailExists(email);
	}

}
