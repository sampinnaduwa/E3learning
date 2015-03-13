package com.samith.service;

import com.samith.model.User;

public interface UserService {

	public User getUser(String login);

	public User saveUser(User user) throws Exception; 
}
