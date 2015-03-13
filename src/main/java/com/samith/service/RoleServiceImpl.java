package com.samith.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.samith.dao.RoleDao;
import com.samith.model.Role;

public class RoleServiceImpl implements RoleService {

	@Autowired  
    private RoleDao roleDAO;  
  
    public Role getRole(int id) {  
        return roleDAO.getRole(id);  
    }  

}
