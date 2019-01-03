package com.dao;

import java.util.List;

import com.pojo.User;

/**
 * @author syd2018-8-2下午4:50:03
 * @version 创建时间：2018-8-2 下午4:50:03
 * 类说明
 */
/**        
 * 类名称：UserMapper   
 * 类描述：   
 * 创建人：syd   
 * 创建时间：2018-8-2 下午4:50:03      
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
