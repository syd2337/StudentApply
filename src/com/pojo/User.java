package com.pojo;
/**
 * @author syd2018-8-2下午3:55:55
 * @version 创建时间：2018-8-2 下午3:55:55
 * 类说明
 */
/**        
 * 类名称：User   
 * 类描述：   
 * 创建人：syd   
 * 创建时间：2018-8-2 下午3:55:55      
 * @version    
 *    
 */
public class User {
	/**
	 * 用户id
	 */
	private String id;
	/**
	 * 用户id
	 */
	private String name;
	/**
	 * 用户电话
	 */
	private String phoneNum;
	/**
	 * 用户账号
	 */
	private String userName;
	/**
	 * 用户密码
	 */
	private String password;
	/**
	 * 用户角色
	 */
	private String role;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

}
