package com.samith.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.samith.model.Role;

public class RoleDaoImpl implements RoleDao {

	@Autowired  
    private SessionFactory sessionFactory;  
	
	@PersistenceContext
	protected EntityManager entityManager;
      
    /*private Session getCurrentSession() {  
        return sessionFactory.getCurrentSession();  
    } */ 
  
    public Role getRole(int id) {  
    	Role role = entityManager.find(Role.class, id);
        //Role role = (Role) getCurrentSession().load(Role.class, id);  
        return role;  
    }  
}
