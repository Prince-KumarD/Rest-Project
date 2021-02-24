package com.Question_Answer_Platform.user.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Question_Answer_Platform.exception.UserNotFoundException;
import com.Question_Answer_Platform.user.dao.UserRepo;
import com.Question_Answer_Platform.user.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	@Override
	public User addUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public List<User> findAllUser() {
		return userRepo.findAll();
	}

	@Override
	public User updateUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public User findUserByName(String Name) {
		User user = null;
		user = userRepo.findByUserName(Name);
		if(user==null) {
			throw new UserNotFoundException("Company By Name "+Name+"was not found"); 
		}
		return user;
	}

	@Override
	public void deleteUserByName(String userName) {
		userRepo.deleteByUserName(userName);
	}

	@Override
	public User findUserByUserId(Integer userId) {
		return userRepo.findUserByUserId(userId);
	}

	@Override
	public void deleteUserByUserId(Integer userId) {
		userRepo.deleteUserByUserId(userId);
		
	}

	
}
