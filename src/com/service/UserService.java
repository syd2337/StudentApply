package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.UserMapper;
import com.pojo.User;

@Service
public class UserService implements UserServiceInterface {
	@Resource
	private UserMapper userMapper;

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userMapper.addUser(user);
	}

	@Override
	public List<User> selectAllUser() {
		// TODO Auto-generated method stub
		return userMapper.selectAllUser();
	}

	@Override
	public User selectUserById(String id) {
		// TODO Auto-generated method stub
		return userMapper.selectUserById(id);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userMapper.updateUser(user);
	}

	@Override
	public void deleteUser(String id) {
		// TODO Auto-generated method stub
		userMapper.deleteUser(id);
	}

	@Override
	public User userLogin(User user) {
		// TODO Auto-generated method stub
		return userMapper.userLogin(user);
	}

	@Override
	public void updatePssword(User user) {
		userMapper.updatePssword(user);
		// TODO Auto-generated method stub
		
	}
}
