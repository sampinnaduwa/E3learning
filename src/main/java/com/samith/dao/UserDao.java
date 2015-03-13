package com.samith.dao;

import com.samith.model.User;

public interface UserDao {

	public User getUser(String login);

	public User saveUser(User user) throws Exception;
}
