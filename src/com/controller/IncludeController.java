package com.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.pojo.AboutUs;
import com.pojo.Address;
import com.pojo.Include;
import com.service.AboutUsServiceInterface;
import com.service.AddressServiceInterface;
import com.service.IncludeServiceInterface;
import com.util.Access;

@Controller
public class IncludeController {
	@Autowired
	private IncludeServiceInterface includeServiceInterface;
	@Autowired
	private AboutUsServiceInterface aboutUsServiceInterface;
	@Autowired
	private AddressServiceInterface addressServiceInterface;
	@RequestMapping("/selectIncludeByType.html")
	public String selectIncludeByType(HttpServletRequest request,HttpServletResponse response){
		List<Include> companyList = includeServiceInterface.selectIncludeByTitleType("公司动态");
		List<Include> tradeList = includeServiceInterface.selectIncludeByTitleType("行业资讯");
		Address address = addressServiceInterface.selectAddress();
		HttpSession session = request.getSession();
		session.setAttribute("address", address);
		request.setAttribute("companyList", companyList);
		request.setAttribute("tradeList", tradeList);
		return "main";
		
		
	}
	@RequestMapping("/include.html")
	public String include(HttpServletRequest request,HttpServletResponse response){
		List<Include> includeList = includeServiceInterface.selectAllInclude();
		request.setAttribute("includeList", includeList);
		return "include";
		
	}
	@RequestMapping("/toAddInclude.html")
	public String toAddInclude(){
		return "toAddInclude";
		
	}
	
	@RequestMapping("/addInclude.html")
	public void addInclude(HttpServletRequest request,HttpServletResponse response){
		Include include = new Include();
		String title = request.getParameter("title");
		String titleType = request.getParameter("titleType");
		String content = request.getParameter("content");
		include.setContent(content);
		include.setTitle(title);
		include.setTitleType(titleType);
		PrintWriter out = null;
		String message = "";
		try {
			out=response.getWriter();
			includeServiceInterface.addInclude(include);
			message = JSON.toJSONString("success");
			out.print(message);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(out!=null){
				out.close();
			}
		}
		
	}
	@RequestMapping("/deleteInclude.html")
	public void deleteInclude(HttpServletRequest request,HttpServletResponse response){
		String includeId =request.getParameter("includeId");
		System.out.println(includeId);
		PrintWriter out = null;
		String message = "";
		try {
			out=response.getWriter();
			message = JSON.toJSONString("error");
			includeServiceInterface.deleteInclude(includeId);
			message = JSON.toJSONString("success");
			out.print(message);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(out!=null){
				out.close();
			}
		}
	}
	@RequestMapping("/toUpdateInclude.html")
	public String toUpdateInclude(HttpServletRequest request,HttpServletResponse response){
		String id = request.getParameter("id");
		Include include = includeServiceInterface.selectIncludeById(id);
		request.setAttribute("include", include);
		
		return "updateInclude";
		
	}
	@RequestMapping("/updateInclude.html")
	public void updateInclude(HttpServletRequest request,HttpServletResponse response){
		Include include = new Include();
		String title = request.getParameter("title");
		String titleType = request.getParameter("titleType");
		String content = request.getParameter("content");
		String id = request.getParameter("includeId");
		include.setContent(content);
		include.setTitle(title);
		include.setTitleType(titleType);
		include.setId(id);
		PrintWriter out = null;
		String message = "";
		try {
			out=response.getWriter();
			message = JSON.toJSONString("error");
			includeServiceInterface.updateInclude(include);
			message = JSON.toJSONString("success");
			out.print(message);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(out!=null){
				out.close();
			}
		}
		
	}
	@RequestMapping("/toNew.html")
	public String toNew(HttpServletRequest request,HttpServletResponse response){
		String includeId = request.getParameter("id");
		Include include = new Include();
		if(includeId!=null){
			include=includeServiceInterface.selectIncludeById(includeId);
		}
		
		request.setAttribute("include", include);
		return "new";
		
	}
	@RequestMapping("/aboutUs.html")
	public String aboutUs(HttpServletRequest request,HttpServletResponse response){
		AboutUs aboutUs = aboutUsServiceInterface.selectAboutUs();
		request.setAttribute("aboutUs", aboutUs);
		return "aboutUs";
		
	}
	@RequestMapping("/address.html")
	public String address(HttpServletRequest request,HttpServletResponse response){
		 
		return "address";
		
	}
	@RequestMapping("/updateAboutUs.html")
	public String updateAboutUs(HttpServletRequest request,HttpServletResponse response){
		if(Access.getAccess(request)){
			return "home";
		}
		AboutUs aboutUs = aboutUsServiceInterface.selectAboutUs();
		request.setAttribute("aboutUs", aboutUs);
		return "updateAboutUs";	
	}
	@RequestMapping("/toUpdateAboutUs.html")
	public void toUpdateAboutUs(HttpServletRequest request,HttpServletResponse response){
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String id = request.getParameter("id");
		AboutUs  aboutUs = new AboutUs();
		aboutUs.setContent(content);
		aboutUs.setId(id);
		aboutUs.setTitle(title);
		PrintWriter out = null;
		String message = "";
		try {
			out=response.getWriter();
			message = JSON.toJSONString("error");
			aboutUsServiceInterface.updateAboutUs(aboutUs);
			message = JSON.toJSONString("success");
			out.print(message);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(out!=null){
				out.close();
			}
		}	
	}
	@RequestMapping("/updateAddress.html")
	public String updateAddress(HttpServletRequest request,HttpServletResponse response){
		if(Access.getAccess(request)){
			return "home";
		}
		Address address = addressServiceInterface.selectAddress();
		request.setAttribute("address", address);
		return "updateAddress";	
	}
	@RequestMapping("/toUpdateAddress.html")
	public void toUpdateAddress(HttpServletRequest request,HttpServletResponse response){
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String id = request.getParameter("id");
		String phone = request.getParameter("phone");
		Address  addres = new Address();
		addres.setAddress(address);
		addres.setEmail(email);
		addres.setId(id);
		addres.setPhone(phone);
		PrintWriter out = null;
		String message = "";
		try {
			out=response.getWriter();
			message = JSON.toJSONString("error");
			addressServiceInterface.updateAddress(addres);
			message = JSON.toJSONString("success");
			out.print(message);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(out!=null){
				out.close();
			}
		}	
	}
}
