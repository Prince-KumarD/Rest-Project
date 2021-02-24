package com.Question_Answer_Platform.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Question_Answer_Platform.user.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	
	public User findByUserName(String Name);
	public void deleteByUserName(String userName);
	public User findUserByUserId(Integer userId);
	public void deleteUserByUserId(Integer userId);
}
