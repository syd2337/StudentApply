package com.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.pojo.Subject;
import com.service.SubjectServiceInterface;
import com.util.Access;

/**
 * @author syd2018-8-14下午2:45:53
 * @version 创建时间：2018-8-14 下午2:45:53
 * 类说明
 */
/**        
 * 类名称：SubjectController   
 * 类描述：   
 * 创建人：syd   
 * 创建时间：2018-8-14 下午2:45:53      
 * @version    
 *    
 */
@Controller
public class SubjectController {
	@Autowired
	private SubjectServiceInterface subjectServiceInterface;
	Subject subject = new Subject();
	@RequestMapping("/subject.html")
	public String Subject(HttpServletRequest request, HttpServletResponse response){
		if(Access.getAccess(request)){
			return "home";
		}
		List<Subject> subjectList = subjectServiceInterface.selectAllSubject();
		request.setAttribute("subjectList", subjectList);
		return "subject";
		
	}
	@RequestMapping("/toAddSubject.html")
	/**
	 * 主页
	 * @param request
	 * @param response
	 */
	public String toAddSubject(){			
		return "addSubject";		
	}
	@RequestMapping("/addSubject.html")
	public void addSubject(HttpServletRequest request, HttpServletResponse response){
		String subjectName=request.getParameter("subjectName");
		
		subject.setName(subjectName);
		String message = JSON.toJSONString(subject);
		PrintWriter out =null;
		try {
			out=response.getWriter();
			subjectServiceInterface.addSubject(subject);
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
	@RequestMapping("/toUpdateSubject.html")
	public String toUpdateSubject(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		try {
			subject = subjectServiceInterface.selectSubjectById(id);
			if(null!=subject){
				request.setAttribute("subject", subject);
				return "updateSubject";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "addSubject";						
	}
	@RequestMapping("/updateSubject.html")
	public void updateSubject(HttpServletRequest request, HttpServletResponse response){
		String name = request.getParameter("newSubjectName");
		String id = request.getParameter("id");
		subject.setId(id);
		subject.setName(name);
		PrintWriter out =null;
		String message = JSON.toJSONString("success");
		try {
			out=response.getWriter();
			subjectServiceInterface.updateSubject(subject);
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
	@RequestMapping("/deleteSubject.html")
	public void deleteSubject(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		PrintWriter out =null;
		String message = JSON.toJSONString("success");
		try {
			out=response.getWriter();
			subjectServiceInterface.deleteSubject(id);
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
	/*@RequestMapping("selectSubjectLikeName.html")
	public void selectSubjectLikeName(HttpServletRequest request, HttpServletResponse response){
		String likeSubjectName= request.getParameter("likeSubjectName");
		PrintWriter out = null;
		try {
		out = response.getWriter();
		List<Subject> SubjectList = SubjectServiceInterface.selectSubjectLikeName(likeSubjectName);
		if(null!=SubjectList){
			String str = JSON.toJSONString(SubjectList);
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
	@RequestMapping("selectSubjectLikeName.html")
	public String selectSubjectLikeName(HttpServletRequest request, HttpServletResponse response){
		try {
			String likeSubjectName = new String(request.getParameter("likeSubjectName").getBytes("iso-8859-1"), "utf-8");
			//System.out.println(likeSubjectName);
			List<Subject> subjectList = subjectServiceInterface.selectSubjectLikeName(likeSubjectName);
			//System.out.println(SubjectList.get(0).getSubjectName());
			request.setAttribute("subjectList", subjectList);
			request.setAttribute("likeSubjectName", likeSubjectName);
			return "subject";	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "subject";
	}
	
}
