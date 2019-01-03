package com.dao;

import java.util.List;

import com.pojo.User;

/**
 * @author syd2018-8-2����4:50:03
 * @version ����ʱ�䣺2018-8-2 ����4:50:03
 * ��˵��
 */
/**        
 * �����ƣ�UserMapper   
 * ��������   
 * �����ˣ�syd   
 * ����ʱ�䣺2018-8-2 ����4:50:03      
 * @version    
 *    
 */
public interface UserMapper {
	void addUser(User user);
	List<User> selectAllUser();
	User selectUserById(String id);
	void updateUser(User user);
	void deleteUser(String id);
	User userLogin(User user);
	void updatePssword(User user);
	

}
