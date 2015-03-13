package com.samith.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.samith.dao.UserDao;
import com.samith.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired  
    private UserDao userDAO;  
  
    public User getUser(String login) {  
        return userDAO.getUser(login);  
    }

    @Transactional (isolation=Isolation.READ_UNCOMMITTED,
    propagation=Propagation.REQUIRED,
    rollbackFor=Exception.class)
	public User saveUser(User user) throws Exception {
		return userDAO.saveUser(user);
	}  

}
