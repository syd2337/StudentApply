package com.service;

import java.util.List;

import com.pojo.User;

public interface UserServiceInterface {
	void addUser(User user);
	List<User> selectAllUser();
	User selectUserById(String id);
	void updateUser(User user);
	void deleteUser(String id);
	User userLogin(User user);
	void updatePssword(User user);
	
}
