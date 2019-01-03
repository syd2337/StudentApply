package com.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.pojo.User;
import com.service.CampusServiceInterface;
import com.service.CourseServiceInterface;
import com.service.SchoolServiceInterface;
import com.service.StudentServiceInterface;
import com.service.UserServiceInterface;

@Controller
public class LoginController {
	@Autowired
	private UserServiceInterface userServiceInterface;
	@Autowired
	private SchoolServiceInterface schoolServiceInterface;
	@Autowired
	private CampusServiceInterface campusServiceInterface;
	@Autowired
	private CourseServiceInterface  courseServiceInterface;
	@Autowired
	private StudentServiceInterface studentServiceInterface;
	@RequestMapping("/login.html")
	/**
	 * 登录
	 * @param request
	 * @param response
	 */
	public void login(HttpServletRequest request, HttpServletResponse response){
		User user = new User();
		String userName = request.getParameter("name");
		String password = request.getParameter("password");
		user.setUserName(userName);
		user.setPassword(password);
		PrintWriter out =null;
		
		try {
			out = response.getWriter();
			user =userServiceInterface.userLogin(user);
			String message = JSON.toJSONString(user);
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			if(null!= user){
				//System.out.println(message);
				out.print(message);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			if(out!=null){
				out.close();
			}
		}
		
	}
	@RequestMapping("/home.html")
	/**
	 * 主页
	 * @param request
	 * @param response
	 */
	public String home(HttpServletRequest request, HttpServletResponse response){
		int allSchoolNum = schoolServiceInterface.selectAllSchoolNum();
		int allCampusNum = campusServiceInterface.selectAllCampusNum();
		int allCourseNum = courseServiceInterface.selectAllCourseNum();
		int allStudentNum= studentServiceInterface.selectAllStudentNum();
		int studentNoPayNum = studentServiceInterface.selectAllStudentByPayCondition("未缴费");
		int studentPayNum = studentServiceInterface.selectAllStudentByPayCondition("已缴费");
		request.setAttribute("allSchoolNum", allSchoolNum);
		request.setAttribute("allCampusNum", allCampusNum);
		request.setAttribute("allCourseNum", allCourseNum);
		request.setAttribute("allStudentNum", allStudentNum);
		request.setAttribute("studentNoPayNum", studentNoPayNum);
		request.setAttribute("studentPayNum", studentPayNum);
		return "home";		
	}
	@RequestMapping("toLogin.html")
	public String toLogin(){
		return "login";
		
	}
	@RequestMapping("/apply.html")
	public String apply(){
		return "apply";
		
	}
	@RequestMapping("/myJsp.html")
	public String myJsp(){
		return "MyJsp";
		
	}
}
