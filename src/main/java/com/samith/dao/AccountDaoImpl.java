package com.samith.dao;

import javax.persistence.PersistenceException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.samith.model.Account;

@Repository
public class AccountDaoImpl extends GenericDaoImpl<Integer, Account> implements AccountDao {

	public AccountDaoImpl() {
		super(Account.class);
	}

	@Transactional (propagation=Propagation.REQUIRED)
	public void saveAccount(Account account) {
		try{
			entityManager.detach(account.getCourse());
			entityManager.persist(account);
		} catch (PersistenceException e) {
			entityManager.merge(account);
		}
		
		
	}

}
