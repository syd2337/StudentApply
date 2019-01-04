package com.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.pojo.Campus;
import com.pojo.User;
import com.service.CampusServiceInterface;
import com.service.UserServiceInterface;

@Controller
public class UserController {
	@Autowired
	private UserServiceInterface userServiceInterface;
	@Autowired
	private CampusServiceInterface campusServiceInterface;
	@RequestMapping("/user.html")
	/**
	 * 学校管理
	 * @param request
	 * @param response
	 */
	public String user(HttpServletRequest request, HttpServletResponse response){
		List<User> userList = userServiceInterface.selectAllUser();
		request.setAttribute("userList", userList);
		return "user";		
	}
	@RequestMapping("/toAddUser.html")
	/**
	 * 主页
	 * @param request
	 * @param response
	 */
	public String toAdduser(HttpServletRequest request, HttpServletResponse response){
		List<Campus> listCampus = campusServiceInterface.selectAllCampus();
		request.setAttribute("listCampus", listCampus);
		return "addUser";		
	}
	@RequestMapping("/addUser.html")
	public void addUser(HttpServletRequest request, HttpServletResponse response){
		User user = new User();
		String userName=request.getParameter("userName");
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String password=request.getParameter("password");
		String role=request.getParameter("role");
		String campusName=request.getParameter("campusName");
		int access=0;
		if(role.equals("超级管理员")){
			access=1;
		}
		if(role.equals("校区管理员")){
			access=2;
		}
		if(role.equals("校区报名员")){
			access=3;
		}
		user.setUserName(userName);
		user.setAccess(access);
		user.setCampusName(campusName);
		user.setPassword(password);
		user.setPhoneNum(phone);
		user.setRole(role);
		user.setName(name);
		String message = "";
		PrintWriter out =null;
		try {						
			userServiceInterface.addUser(user);
			message = JSON.toJSONString("success");			
			out=response.getWriter();		
			out.print(message);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			if(out!=null){
				out.close();
			}
		}				
	}
	@RequestMapping("/toUpdateuser.html")
	public String toUpdateuser(HttpServletRequest request, HttpServletResponse response){
		User user = new User();
		String id = request.getParameter("id");
		try {
			 user = userServiceInterface.selectUserById(id);
			if(null!=user){
				request.setAttribute("user", user);
				return "updateuser";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "adduser";						
	}
	@RequestMapping("/updateuser.html")
	public void updateuser(HttpServletRequest request, HttpServletResponse response){
		User user = new User();
		String name = request.getParameter("newuserName");
		String id = request.getParameter("id");
		user.setId(id);
		user.setName(name);
		PrintWriter out =null;
		String message = JSON.toJSONString("success");
		try {
			out=response.getWriter();
			userServiceInterface.updateUser(user);
			out.print(message);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			if(out!=null){
				out.close();
			}
		}
	}
	@RequestMapping("/deleteuser.html")
	public void deleteuser(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		PrintWriter out =null;
		String message = JSON.toJSONString("success");
		try {
			out=response.getWriter();
			userServiceInterface.deleteUser(id);
			out.print(message);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			if(out!=null){
				out.close();
			}
		}
	}
	@RequestMapping("/changePassword.html")
	public String changePassword(){
		return "changePassword";
		
	}
	@RequestMapping("/updatePassword.html")
	public void updatePassword(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		String newPassword = request.getParameter("newPwd");
		User user = new User ();
		user.setId(id);
		user.setPassword(newPassword);
		PrintWriter out =null;
		String message = JSON.toJSONString("success");
		try {
			out=response.getWriter();
			userServiceInterface.updatePssword(user);
			out.print(message);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			if(out!=null){
				out.close();
			}
		}
	}

}
