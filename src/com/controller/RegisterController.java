package com.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.pojo.Course;
import com.pojo.Register;
import com.service.CourseServiceInterface;
import com.service.RegisterServiceInterface;
import com.service.StuCourseServiceInterface;
import com.util.ShowStuCourse;
import com.util.StringToDate;
import com.util.TheTimes;

/**
 * @author syd2018-10-10上午10:04:59
 * @version 创建时间：2018-10-10 上午10:04:59
 * 类说明
 */
/**        
 * 类名称：RegisterController   
 * 类描述：   
 * 创建人：syd   
 * 创建时间：2018-10-10 上午10:04:59      
 * @version    
 *    
 */
@Controller
public class RegisterController {
	@Autowired
	private RegisterServiceInterface registerServiceInterface;
	@Autowired
	private StuCourseServiceInterface stuCourseServiceInterface;
	@Autowired
	private CourseServiceInterface courseServiceInterface;
	@RequestMapping("/register.html")
	public String register(){
		return "register";
		
	}
	@RequestMapping("toRegister.html")
	public void toRegister(HttpServletRequest request, HttpServletResponse response){
		String studentId =request.getParameter("studentId");	
		Register register = new Register();
		Register checkRegister = new Register();
		ShowStuCourse showStuCourse = new ShowStuCourse();
		Course course = new Course();
		boolean flag = false;
		String message ="";
		PrintWriter out =null;
		try {
		if(studentId!=null && studentId.length()==36){
		List<ShowStuCourse> stuCourseList = stuCourseServiceInterface.StuCourseByStudentId(studentId);
		if(stuCourseList!=null){//这个学生报名有课程
			for(int i=0;i<stuCourseList.size();i++){
				 
				flag=StringToDate.compare(stuCourseList.get(i).getCourse().getPeriod());//上的那一课
				if(flag){
					int thePeriod =StringToDate.thePeriod(stuCourseList.get(i).getCourse().getPeriod());//这次课几小时 
					int times = stuCourseList.get(i).getCourse().getTimes()-1;
					int theClass=stuCourseList.get(i).getCourse().getTheClass()-thePeriod;
					course.setId(stuCourseList.get(i).getCourse().getId());
					course.setTheClass(theClass);
					course.setTimes(times);
					//int countStuCourse =registerServiceInterface.countByStuCourseId(stuCourseList.get(i).getId());//查询是否上过这次课
					register=registerServiceInterface.selectRegisterByStuCourseId(stuCourseList.get(i).getId());
					int theTimes = 1;
					if(null!=register){
						flag=StringToDate.compareDate(register.getCreateDate());
						if(flag){
							theTimes = register.getTheTimes()+1;
							
							register.setCourseId(stuCourseList.get(i).getCourse().getId());
							register.setStuCourseId(stuCourseList.get(i).getId());
							register.setStudentId(studentId);
							register.setTheTimes(theTimes);
							registerServiceInterface.addRegister(register);
							showStuCourse = stuCourseServiceInterface.StuCourseByStuCourseId(stuCourseList.get(i).getId());
							courseServiceInterface.updateCourse(course);
							message = JSON.toJSONString(showStuCourse);
						}else{
							message=JSON.toJSONString("repeat");
						}//上过课
						
					}else{
					
					checkRegister.setCourseId(stuCourseList.get(i).getCourse().getId());
					checkRegister.setStuCourseId(stuCourseList.get(i).getId());
					checkRegister.setStudentId(studentId);
					checkRegister.setTheTimes(theTimes);
					registerServiceInterface.addRegister(checkRegister);
					showStuCourse = stuCourseServiceInterface.StuCourseByStuCourseId(stuCourseList.get(i).getId());
					message = JSON.toJSONString(showStuCourse);
					}
				}
			}
		}
		
		}else{
			message=JSON.toJSONString("error");
		}		
			out=response.getWriter();			
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
	@RequestMapping("getTimes.html")
	public String getTimes(HttpServletRequest request, HttpServletResponse response){
		String courseId = request.getParameter("id");
		List<TheTimes> theTimesList = registerServiceInterface.selectTheTimes(courseId);
		Course course =courseServiceInterface.selectCourseById(courseId);
		if(theTimesList!=null){
			request.setAttribute("theTimesList", theTimesList);
			request.setAttribute("course", course);
		}
		return "theTimes";	
	}
	@RequestMapping("getStudents.html")
	public String getStudents(HttpServletRequest request, HttpServletResponse response){
		int times = Integer.parseInt(request.getParameter("times"));
		
		String courseId = request.getParameter("courseId");
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("times", times);
		param.put("courseId", courseId);
			
		List<ShowStuCourse> showStuCourseList = stuCourseServiceInterface.StuCourseByCourseIdAndTheTimes(param);
		
		if(showStuCourseList!=null){
			request.setAttribute("showStuCourseList", showStuCourseList);
			return "theStudents";
		}
		return "theStudents";
		
	}
	
}
