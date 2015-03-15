package com.samith.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.samith.model.User;

/**
 * The Class UserDaoImpl.
 */
@Repository
public class UserDaoImpl implements UserDao {
	
	/** The entity manager. */
	@PersistenceContext(type=PersistenceContextType.TRANSACTION)
	protected EntityManager entityManager;
	
      
	/* (non-Javadoc)
	 * @see com.samith.dao.UserDao#getUser(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public User getUser(String login) {
		List<User> userList = new ArrayList<User>();  
		Query query = entityManager.createQuery("from User u where u.login = :login");
        query.setParameter("login", login);  
        userList = query.getResultList();  
        if (userList.size() > 0)  
            return userList.get(0);  
        else  
            return null;
	}


	/* (non-Javadoc)
	 * @see com.samith.dao.UserDao#saveUser(com.samith.model.User)
	 */
	public User saveUser(User user) throws Exception {
		entityManager.persist(user);
		throw new Exception();
	}

}
