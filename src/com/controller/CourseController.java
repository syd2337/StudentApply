package com.controller;

import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.pojo.Campus;
import com.pojo.Course;
import com.pojo.Grade;
import com.pojo.Subject;
import com.service.CampusServiceInterface;
import com.service.CourseServiceInterface;
import com.service.GradeServiceInterface;
import com.service.StuCourseServiceInterface;
import com.service.SubjectServiceInterface;
import com.util.Access;
import com.util.Paging;
import com.util.ShowStuCourse;
import com.util.StringToDate;
import com.util.Tabs;

/**
 * @author syd2018-8-14下午3:55:21
 * @version 创建时间：2018-8-14 下午3:55:21
 * 类说明
 */
/**        
 * 类名称：Course   
 * 类描述：   
 * 创建人：syd   
 * 创建时间：2018-8-14 下午3:55:21      
 * @version    
 *    
 */
@Controller
public class CourseController {
	@Autowired
	private CourseServiceInterface courseServiceInterface;
	@Autowired
	private SubjectServiceInterface subjectServiceInterface;
	@Autowired
	private GradeServiceInterface gradeServiceInterface;
	@Autowired
	private StuCourseServiceInterface stuCourseServiceInterface;
	@Autowired
	private CampusServiceInterface campusServiceInterface;
	Course course = new Course();
	StringToDate strToDate = new StringToDate();
	@RequestMapping("/course.html")
	public String course(HttpServletRequest request, HttpServletResponse response){
		if(Access.getAccess(request)){
			return "home";
		}
		List<Subject> subjectList = subjectServiceInterface.selectAllSubject();
		List<Grade> gradeList = gradeServiceInterface.selectAllGrade();
		request.setAttribute("subjectList", subjectList);
		request.setAttribute("gradeList", gradeList);
		List<Course> courseList = courseServiceInterface.selectAllCourse();
		request.setAttribute("courseList", courseList);
		return "course";
		
	}
	@RequestMapping("/toAddCourse.html")
	/**
	 * 主页
	 * @param request
	 * @param response
	 */
	public String toAddCourse(HttpServletRequest request, HttpServletResponse response){
		List<Subject> subjectList = subjectServiceInterface.selectAllSubject();
		List<Grade> gradeList = gradeServiceInterface.selectAllGrade();
		List<Campus> campusList=campusServiceInterface.selectAllCampus();
		request.setAttribute("subjectList", subjectList);
		request.setAttribute("gradeList", gradeList);
		request.setAttribute("campusList", campusList);
		return "addCourse";		
	}
	@RequestMapping("/addCourse.html")
	public void addCourse(HttpServletRequest request, HttpServletResponse response){
		String campusName = request.getParameter("campusName");
		String gradeName=request.getParameter("gradeName");
		String subjectName= request.getParameter("subjectName");		
		String period = request.getParameter("period");
		int rates = Integer.parseInt(request.getParameter("rates"));
		int times = Integer.parseInt(request.getParameter("times"));
		int theClass = Integer.parseInt(request.getParameter("theClass"));
		course.setCampusName(campusName);
		course.setGradeName(gradeName);
		course.setPeriod(period);
		course.setSubjectName(subjectName);
		course.setRates(rates);
		course.setTimes(times);
		course.setTheClass(theClass);
		String message="";
		PrintWriter out =null;
		try {
			//System.out.println(request.getParameter("startTime"));
			Date startTime = strToDate.stringToDate(request.getParameter("startTime"));
			Date endTime = strToDate.stringToDate(request.getParameter("endTime"));
			
			course.setEndTime(endTime);
			course.setStartTime(startTime);
			message = JSON.toJSONString(course);
			out=response.getWriter();
			courseServiceInterface.addCourse(course);
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
	@RequestMapping("/toUpdateCourse.html")
	public String toUpdateCourse(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		List<Subject> subjectList = subjectServiceInterface.selectAllSubject();
		List<Grade> gradeList = gradeServiceInterface.selectAllGrade();
		
		try {
			course = courseServiceInterface.selectCourseById(id);
			if(null!=course){
				request.setAttribute("course", course);
				request.setAttribute("subjectList", subjectList);
				request.setAttribute("gradeList", gradeList);
				return "updateCourse";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "addCourse";						
	}
	@RequestMapping("/updateCourse.html")
	public void updateCourse(HttpServletRequest request, HttpServletResponse response){		
		String id = request.getParameter("id");
		String period = request.getParameter("period");
		int rates = Integer.parseInt(request.getParameter("rates"));
		int times = Integer.parseInt(request.getParameter("times"));
		int theClass = Integer.parseInt(request.getParameter("theClass"));
		course.setTimes(times);
		course.setPeriod(period);
		course.setRates(rates);
		course.setId(id);
		course.setTheClass(theClass);
		String message="";
		PrintWriter out =null;
		
		try {
			Date startTime = strToDate.stringToDate(request.getParameter("startTime"));
			Date endTime = strToDate.stringToDate(request.getParameter("endTime"));
			course.setEndTime(endTime);
			course.setStartTime(startTime);
			out=response.getWriter();
			courseServiceInterface.updateCourse(course);
			message = JSON.toJSONString("success");
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
	@RequestMapping("/deleteCourse.html")
	public void deleteCourse(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		PrintWriter out =null;
		String message = JSON.toJSONString("success");
		try {
			out=response.getWriter();
			courseServiceInterface.deleteCourse(id);
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
	/*@RequestMapping("selectCourseLikeName.html")
	public void selectCourseLikeName(HttpServletRequest request, HttpServletResponse response){
		String likeCourseName= request.getParameter("likeCourseName");
		PrintWriter out = null;
		try {
		out = response.getWriter();
		List<Course> CourseList = CourseServiceInterface.selectCourseLikeName(likeCourseName);
		if(null!=CourseList){
			String str = JSON.toJSONString(CourseList);
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
	@RequestMapping("selectCourseDynamic.html")
	public String selectCourseDynamic(HttpServletRequest request, HttpServletResponse response){
		try {
			List<Subject> subjectList = subjectServiceInterface.selectAllSubject();
			List<Grade> gradeList = gradeServiceInterface.selectAllGrade();
			request.setAttribute("subjectList", subjectList);
			request.setAttribute("gradeList", gradeList);
			//String likeCourseName = new String(request.getParameter("likeCourseName").getBytes("iso-8859-1"), "utf-8");
			String gradeName=new String(request.getParameter("gradeName").getBytes("iso-8859-1"), "utf-8");
			String subjectName= new String(request.getParameter("subjectName").getBytes("iso-8859-1"), "utf-8");		
			String period = request.getParameter("period");
			Date startTime = strToDate.stringToDate(request.getParameter("startTime"));
			Date endTime = strToDate.stringToDate(request.getParameter("endTime"));
			String strRates=request.getParameter("rates");
			int rates=0;
			
			if(strRates!=null&strRates!=""){
				rates= Integer.parseInt(strRates) ;
			}
			//System.out.println(gradeName+"00"+subjectName+"11"+period+"22"+startTime+"33"+endTime+"44"+rates);
			course.setGradeName(gradeName);
			course.setPeriod(period);
			course.setSubjectName(subjectName);
			course.setRates(rates);			
			course.setEndTime(endTime);
			course.setStartTime(startTime);
			//System.out.println(likeCourseName);
			List<Course> courseList = courseServiceInterface.selectCourseDynamic(course);
			request.setAttribute("courseList", courseList);
			request.setAttribute("course", course);
			return "course";	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "course";
	}
/**
 * 	
 * @param request
 * @param response
 * 获取报名学生信息人数
 */
@RequestMapping("getApplyStudent.html")
public String getApplyStudent (HttpServletRequest request, HttpServletResponse response){
	String id = request.getParameter("id");
	
	try {
		
		if(id!=null){
			List<ShowStuCourse> list = stuCourseServiceInterface.StuCourseByCourseId(id);
			
			request.setAttribute("list", list);
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
	return "showApplyStudent";
	
	}
/**
 * 打卡展示课程
 * @param request
 * @param response
 */
@RequestMapping("showCourse.html")
public void showCourse(HttpServletRequest request, HttpServletResponse response){
	String id = request.getParameter("courseId");
	PrintWriter out = null;
	try {
		out = response.getWriter();
		if(id!=null){
			List<ShowStuCourse> list = stuCourseServiceInterface.StuCourseByCourseId(id);
			//System.out.println(JSON.toJSON(list));
			if(list!=null){
			String showStuCourseList=JSON.toJSONString(list);
			out.print(showStuCourseList);
			}
		}
	} catch (Exception e) {
		// TODO: handle exception
	}finally{
		if(out!=null){
			out.close();
		}
	}     
	
	}
}
