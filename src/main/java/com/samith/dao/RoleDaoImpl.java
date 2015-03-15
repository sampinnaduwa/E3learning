package com.samith.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.samith.model.Role;

/**
 * The Class RoleDaoImpl.
 */
public class RoleDaoImpl implements RoleDao {

	/** The session factory. */
	@Autowired  
    private SessionFactory sessionFactory;  
	
	/** The entity manager. */
	@PersistenceContext
	protected EntityManager entityManager;
  
    /* (non-Javadoc)
     * @see com.samith.dao.RoleDao#getRole(int)
     */
    public Role getRole(int id) {  
    	Role role = entityManager.find(Role.class, id);
        return role;  
    }  
}
