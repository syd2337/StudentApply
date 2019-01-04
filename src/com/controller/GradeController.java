package com.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.pojo.Grade;
import com.service.GradeServiceInterface;
import com.util.Access;

@Controller
public class GradeController {
	@Autowired
	private GradeServiceInterface gradeServiceInterface;
	
	@RequestMapping("/grade.html")
	public String grade(HttpServletRequest request, HttpServletResponse response){
		if(Access.getAccess(request)){
			return "home";
		}
		List<Grade> gradeList = gradeServiceInterface.selectAllGrade();
		request.setAttribute("gradeList", gradeList);
		return "grade";
		
	}
	@RequestMapping("/toAddGrade.html")
	/**
	 * ึ๗าณ
	 * @param request
	 * @param response
	 */
	public String toAddgrade(){			
		return "addGrade";		
	}
	@RequestMapping("/addGrade.html")
	public void addgrade(HttpServletRequest request, HttpServletResponse response){
		String gradeName=request.getParameter("gradeName");
		String code = request.getParameter("code");
		Grade grade = new  Grade();
		Grade checkGrade = new Grade();
		grade.setName(gradeName);
		grade.setCode(code);
		String message = "";
		PrintWriter out =null;
		try {
			checkGrade=gradeServiceInterface.selectGradeByName(gradeName);
			if(null!=checkGrade){
				message=JSON.toJSONString(checkGrade);
			}else{
				gradeServiceInterface.addGrade(grade);
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
	@RequestMapping("/toUpdateGrade.html")
	public String toUpdategrade(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		Grade grade = new  Grade();
		try {
			grade = gradeServiceInterface.selectGradeById(id);
			if(null!=grade){
				request.setAttribute("grade", grade);
				return "updateGrade";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "addGrade";						
	}
	@RequestMapping("/updateGrade.html")
	public void updategrade(HttpServletRequest request, HttpServletResponse response){
		Grade grade = new  Grade();
		String name = request.getParameter("newGradeName");
		String code = request.getParameter("code");
		String id = request.getParameter("id");
		grade.setId(id);
		grade.setName(name);
		grade.setCode(code);
		PrintWriter out =null;
		String message = JSON.toJSONString("success");
		try {
			out=response.getWriter();
			gradeServiceInterface.updateGrade(grade);
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
	@RequestMapping("/deleteGrade.html")
	public void deletegrade(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		PrintWriter out =null;
		String message = JSON.toJSONString("success");
		try {
			out=response.getWriter();
			gradeServiceInterface.deleteGrade(id);
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
	/*@RequestMapping("selectgradeLikeName.html")
	public void selectgradeLikeName(HttpServletRequest request, HttpServletResponse response){
		String likegradeName= request.getParameter("likegradeName");
		PrintWriter out = null;
		try {
		out = response.getWriter();
		List<grade> gradeList = gradeServiceInterface.selectgradeLikeName(likegradeName);
		if(null!=gradeList){
			String str = JSON.toJSONString(gradeList);
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
	@RequestMapping("selectGradeLikeName.html")
	public String selectgradeLikeName(HttpServletRequest request, HttpServletResponse response){
		try {
			String likeGradeName = new String(request.getParameter("likeGradeName").getBytes("iso-8859-1"), "utf-8");
			//System.out.println(likegradeName);
			List<Grade> gradeList = gradeServiceInterface.selectGradeLikeName(likeGradeName);
			//System.out.println(gradeList.get(0).getgradeName());
			request.setAttribute("gradeList", gradeList);
			request.setAttribute("likeGradeName", likeGradeName);
			return "grade";	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "grade";
	}
}
