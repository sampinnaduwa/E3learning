package com.samith.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.samith.model.Account;

/**
 * The Class AccountDaoImpl.
 */
@Repository
public class AccountDaoImpl extends GenericDaoImpl<Integer, Account> implements AccountDao {

	/**
	 * Instantiates a new account dao impl.
	 */
	public AccountDaoImpl() {
		super(Account.class);
	}

	/* (non-Javadoc)
	 * @see com.samith.dao.AccountDao#saveAccount(com.samith.model.Account)
	 */
	@Transactional (propagation=Propagation.REQUIRED)
	public void saveAccount(Account account) {
		try{
			entityManager.detach(account.getCourse());
			entityManager.persist(account);
		} catch (PersistenceException e) {
			entityManager.merge(account);
		}
		
		
	}

	/* (non-Javadoc)
	 * @see com.samith.dao.AccountDao#getAccountsByName(java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Account> getAccountsByName(String firstName, String lastName) {
		Query query = entityManager.createQuery("SELECT a FROM Account a WHERE a.firstName = :firstName AND a.lastName = :lastName");
		query.setParameter("firstName", firstName);
		query.setParameter("lastName", lastName);
		return (List<Account>) query.getResultList();
	}

	/* (non-Javadoc)
	 * @see com.samith.dao.AccountDao#isEmailExists(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public boolean isEmailExists(String email) {
		List<Account> accountList = new ArrayList<Account>();
		Query query = entityManager.createQuery("from Account a where a.email = :email");
        query.setParameter("email", email);  
        accountList = query.getResultList();  
        if (accountList.size() > 0)  
            return true;  
        
		return false;
	}

}
