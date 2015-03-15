package com.samith.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.samith.dao.RoleDao;
import com.samith.model.Role;

/**
 * The Class RoleServiceImpl.
 */
public class RoleServiceImpl implements RoleService {

	/** The role dao. */
	@Autowired  
    private RoleDao roleDAO;  
  
    /* (non-Javadoc)
     * @see com.samith.service.RoleService#getRole(int)
     */
    public Role getRole(int id) {  
        return roleDAO.getRole(id);  
    }  

}
