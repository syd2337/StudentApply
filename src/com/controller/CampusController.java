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
import com.service.CampusServiceInterface;

/**
 * @author syd2018-8-13上午11:36:30
 * @version 创建时间：2018-8-13 上午11:36:30
 * 类说明
 */
/**        
 * 类名称：CampusController   
 * 类描述：   
 * 创建人：syd   
 * 创建时间：2018-8-13 上午11:36:30      
 * @version    
 *    
 */
@Controller
public class CampusController {
	@Autowired
	private CampusServiceInterface campusServiceInterface;
	
	@RequestMapping("/campus.html")
	public String campus(HttpServletRequest request, HttpServletResponse response){
		List<Campus> campusList = campusServiceInterface.selectAllCampus();
		request.setAttribute("campusList", campusList);
		return "campus";
		
	}
	@RequestMapping("/toAddCampus.html")
	/**
	 * 主页
	 * @param request
	 * @param response
	 */
	public String toAddCampus(){			
		return "addCampus";		
	}
	@RequestMapping("/addCampus.html")
	public void addCampus(HttpServletRequest request, HttpServletResponse response){
		Campus campus = new  Campus();
		Campus checkCampus = new  Campus();
		String campusName=request.getParameter("campusName");
		String code = request.getParameter("campusCode");
		checkCampus = campusServiceInterface.selectCampusByName(campusName);
		
		
		String message ="";
		PrintWriter out =null;
		try {
			
			if(null!=checkCampus){
				message=JSON.toJSONString(checkCampus);;
			}else{
				campus.setCampusName(campusName);
				campus.setCode(code);
				campusServiceInterface.addCampus(campus);
				message=JSON.toJSONString("success");
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
	@RequestMapping("/toUpdateCampus.html")
	public String toUpdateCampus(HttpServletRequest request, HttpServletResponse response){
		Campus campus = new  Campus();
		String id = request.getParameter("id");
		try {
			campus = campusServiceInterface.selectCampusById(id);
			if(null!=campus){
				request.setAttribute("campus", campus);
				return "updateCampus";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "addCampus";						
	}
	@RequestMapping("/updateCampus.html")
	public void updateCampus(HttpServletRequest request, HttpServletResponse response){
		Campus campus = new  Campus();
		String name = request.getParameter("newCampusName");
		String id = request.getParameter("id");
		campus.setId(id);
		campus.setCampusName(name);
		PrintWriter out =null;
		String message = JSON.toJSONString("success");
		try {
			out=response.getWriter();
			campusServiceInterface.updateCampus(campus);
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
	@RequestMapping("/deleteCampus.html")
	public void deleteCampus(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		PrintWriter out =null;
		String message = JSON.toJSONString("success");
		try {
			out=response.getWriter();
			campusServiceInterface.deleteCampus(id);
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
	/*@RequestMapping("selectCampusLikeName.html")
	public void selectCampusLikeName(HttpServletRequest request, HttpServletResponse response){
		String likeCampusName= request.getParameter("likeCampusName");
		PrintWriter out = null;
		try {
		out = response.getWriter();
		List<Campus> CampusList = CampusServiceInterface.selectCampusLikeName(likeCampusName);
		if(null!=CampusList){
			String str = JSON.toJSONString(CampusList);
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
	@RequestMapping("selectCampusLikeName.html")
	public String selectCampusLikeName(HttpServletRequest request, HttpServletResponse response){
		try {
			String likeCampusName = new String(request.getParameter("likeCampusName").getBytes("iso-8859-1"), "utf-8");
			//System.out.println(likeCampusName);
			List<Campus> campusList = campusServiceInterface.selectCampusLikeName(likeCampusName);
			//System.out.println(CampusList.get(0).getCampusName());
			request.setAttribute("campusList", campusList);
			request.setAttribute("likeCampusName", likeCampusName);
			return "campus";	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "campus";
	}
	

}
