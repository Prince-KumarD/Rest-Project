package com.Question_Answer_Platform.user.service;


import java.util.List;

import com.Question_Answer_Platform.user.model.User;

public interface UserService {

	public User addUser(User user);
	public List<User> findAllUser();
	public User updateUser(User user);
	public User findUserByName(String Name);
	public void deleteUserByName(String userName);
	public void deleteUserByUserId(Integer userId);
	public User findUserByUserId(Integer userId);
}
