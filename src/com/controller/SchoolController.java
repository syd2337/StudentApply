package com.controller;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.alibaba.fastjson.JSON;
import com.pojo.School;
import com.service.SchoolServiceInterface;
import com.util.Access;

@Controller
public class SchoolController {
	@Autowired
	private SchoolServiceInterface schoolServiceInterface;
	
	@RequestMapping("/school.html")
	/**
	 * 学校管理
	 * @param request
	 * @param response
	 */
	public String school(HttpServletRequest request, HttpServletResponse response){
		if(Access.getAccess(request)){
			return "home";
		}
		List<School> schoolList = schoolServiceInterface.selectAllSchool();
		request.setAttribute("schoolList", schoolList);
		return "school";		
	}
	@RequestMapping("/toAddSchool.html")
	/**
	 * 主页
	 * @param request
	 * @param response
	 */
	public String toAddSchool(){			
		return "addSchool";		
	}
	@RequestMapping("/addSchool.html")
	public void addSchool(HttpServletRequest request, HttpServletResponse response){
		School school = new School();
		School checkSchool = new School();
		String schoolName=request.getParameter("schoolName");
		//String code =request.getParameter("schoolCode");
		school.setName(schoolName);
		//school.setCode(code);
		String message = "";
		PrintWriter out =null;
		try {
			checkSchool=schoolServiceInterface.selectSchoolByName(schoolName);
			if(null!=checkSchool){
				message = JSON.toJSONString(checkSchool);
			}else{
				schoolServiceInterface.addSchool(school);
				message = JSON.toJSONString("success");
			}
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
	@RequestMapping("/toUpdateSchool.html")
	public String toUpdateSchool(HttpServletRequest request, HttpServletResponse response){
		School school = new School();
		String id = request.getParameter("id");
		try {
			 school = schoolServiceInterface.selectSchoolById(id);
			if(null!=school){
				request.setAttribute("school", school);
				return "updateSchool";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "addSchool";						
	}
	@RequestMapping("/updateSchool.html")
	public void updateSchool(HttpServletRequest request, HttpServletResponse response){
		School school = new School();
		String name = request.getParameter("newSchoolName");
		String id = request.getParameter("id");
		String code = request.getParameter("schoolCode");
		school.setId(id);
		school.setName(name);
		school.setCode(code);
		PrintWriter out =null;
		String message = JSON.toJSONString("success");
		try {
			out=response.getWriter();
			schoolServiceInterface.updateSchool(school);
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
	@RequestMapping("/deleteSchool.html")
	public void deleteSchool(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		PrintWriter out =null;
		String message = JSON.toJSONString("success");
		try {
			out=response.getWriter();
			schoolServiceInterface.deleteSchool(id);
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
	/*@RequestMapping("selectSchoolLikeName.html")
	public void selectSchoolLikeName(HttpServletRequest request, HttpServletResponse response){
		String likeSchoolName= request.getParameter("likeSchoolName");
		PrintWriter out = null;
		try {
		out = response.getWriter();
		List<School> schoolList = schoolServiceInterface.selectSchoolLikeName(likeSchoolName);
		if(null!=schoolList){
			String str = JSON.toJSONString(schoolList);
			out.print(str);
		}
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			if(out!=null){
				out.close();
			}
		}            
	}*/
	@RequestMapping("selectSchoolLikeName.html")
	public String selectSchoolLikeName(HttpServletRequest request, HttpServletResponse response){
		try {
			String likeSchoolName = new String(request.getParameter("likeSchoolName").getBytes("iso-8859-1"), "utf-8");
			List<School> schoolList = schoolServiceInterface.selectSchoolLikeName(likeSchoolName);
			request.setAttribute("schoolList", schoolList);
			request.setAttribute("likeSchoolName", likeSchoolName);
			return "school";	
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "school";
	}
}
