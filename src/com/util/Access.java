package com.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.pojo.User;

public class Access {
	public static boolean getAccess(HttpServletRequest request){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		boolean flage = false;
		if(user!=null){
		if(user.getAccess()!=1){
			flage=true;
			}
		}
		return flage;
		
	} 
	public static String campusAccess(HttpServletRequest request){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String campusName = null;
		if(user!=null){
		if(user.getAccess()!=1){
			campusName=user.getCampusName();
			}
		}
		return campusName;
	}

}
