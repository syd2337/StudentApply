package com.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.pojo.Campus;
import com.pojo.Course;
import com.pojo.Grade;
import com.pojo.School;
import com.pojo.StuCourse;
import com.pojo.Student;
import com.pojo.Subject;
import com.service.CampusServiceInterface;
import com.service.CourseServiceInterface;
import com.service.GradeServiceInterface;
import com.service.SchoolServiceInterface;
import com.service.StuCourseServiceInterface;
import com.service.StudentServiceInterface;
import com.service.SubjectServiceInterface;
import com.util.Access;
import com.util.Paging;
import com.util.ShowStuCourse;
import com.util.StrToStr;
import com.util.StringToDate;
import com.util.Tabs;

@Controller
public class StuCourseController {
	@Autowired
	private StuCourseServiceInterface stuCourseServiceInterface;
	@Autowired
	private StudentServiceInterface studentServiceInterface;
	@Autowired
	private CourseServiceInterface courseServiceInterface;
	@Autowired
	private CampusServiceInterface campusServiceInterface;
	@Autowired
	private GradeServiceInterface gradeServiceInterface;
	@Autowired
	private SchoolServiceInterface schoolServiceInterface;
	@Autowired
	private SubjectServiceInterface subjectServiceInterface;
	StringToDate strToDate = new StringToDate();
	@RequestMapping("selectStuCourseByStudentId.html")
	public String selectStuCourseByStudentId(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		
		Student student = studentServiceInterface.selectStudentById(id);
		String str =request.getParameter("student");
		List<ShowStuCourse> stuCourseList=stuCourseServiceInterface.theStuCourseByStudentId(id);
		request.setAttribute("student", student);
		request.setAttribute("stuCourseList", stuCourseList);
		if(str!=null){
			if(str.equals("student")){
				return "theStuCourse";
			}
		}
		
		return "stuCourse";
		
	}
	@RequestMapping("deleteStCourse.html")
	public void deleteStCourse(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		PrintWriter out=null;
		String message = JSON.toJSONString("success");
		try {
			out = response.getWriter();
			stuCourseServiceInterface.deleteStuCourse(id);
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
	@RequestMapping("deleteAppStCourse.html")
	public void deleteAppStCourse(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		String studentId=request.getParameter("studentId");
		PrintWriter out=null;
		String message = "";
		try {
			out = response.getWriter();
			message=JSON.toJSONString("error");
			stuCourseServiceInterface.deleteStuCourse(id);
			List<ShowStuCourse> stuCourseList=stuCourseServiceInterface.StuCourseByStudentId(studentId);
			message=JSON.toJSONString(stuCourseList);
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
	@RequestMapping("toAddStuCourse.html")
	public String toAddStuCourse(HttpServletRequest request, HttpServletResponse response){
		String studentId = request.getParameter("studentId");
		String str=request.getParameter("student"); 
		Student student = studentServiceInterface.selectStudentById(studentId);
		Course course = new Course ();
		course.setCampusName(student.getCampusName());
		course.setGradeName(student.getGradeName());
		List<Course> courseList = new ArrayList<Course>();
		if(null!=student){
			courseList = courseServiceInterface.selectCourseByGradeNameAndCampusName(course);
		}		 
		request.setAttribute("student", student);
		request.setAttribute("courseList", courseList);
		if(str!=null){
			if(str.equals("student")){
				return "theaddStudentCourse";
			}
		}
		
		return "addStuCourse";
		
	}
	/**
	 * 报名时添加课程
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("toApplyStuCourse.html")
	public void toApplyStuCourse(HttpServletRequest request, HttpServletResponse response){
		String gradeName = request.getParameter("gradeName");
		String campusName= request.getParameter("campusName");
		Course course = new Course();
		course.setCampusName(campusName);
		course.setGradeName(gradeName);
		List<Course> courseList = new ArrayList<Course>();		
		//courseList = courseServiceInterface.selectCourseByGradeName(gradeName);		
		courseList = courseServiceInterface.selectCourseByGradeNameAndCampusName(course);
		String message = "";
		PrintWriter out =null;
		try {
		out=response.getWriter();
		message=JSON.toJSONString(courseList);
		out.print(message);
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			if(out!=null){
				out.close();
			}
		}	
	}
	@RequestMapping("addStuCourse.html")
	public void addStuCourse(HttpServletRequest request, HttpServletResponse response){
		String studentId = request.getParameter("studentId");
		String[] courseList= request.getParameterValues("courseList");
		StuCourse stuCourse = new StuCourse();
		stuCourse.setStudentId(studentId);
		stuCourse.setPayState("未缴费");
		stuCourse.setState(2);
		String message = "";
		PrintWriter out =null;
		List<StuCourse> stuCourseId=null;
		try {
			for(int i=0;i<courseList.length;i++){
				stuCourse.setCourseId(courseList[i]);
				stuCourseId=stuCourseServiceInterface.checkStuCourseByStudentAndCourse(stuCourse);
				System.out.println(stuCourseId.size()+"+++++");
				if(stuCourseId.size()==0){
					stuCourse.setCourseId(courseList[i]);
					stuCourseServiceInterface.addStuCourse(stuCourse);
				}
			}
			message = JSON.toJSONString(studentId);		
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
	@RequestMapping("showClassCard.html")
	public String showClassCard(HttpServletRequest request, HttpServletResponse response){
		String studentId=request.getParameter("studentId");
		String sing =request.getParameter("sing");
		Student student = studentServiceInterface.selectStudentById(studentId);
		List<ShowStuCourse> showStuCourse = stuCourseServiceInterface.StuCourseByStudentId(studentId);
		if(null!=showStuCourse){
			request.setAttribute("student", student);
			request.setAttribute("showStuCourse", showStuCourse);
			
			if(sing!=null&&sing.equals("student")){
			return "theShowClassCard";
			}
			return "showClassCardNew";
		}
		return "student";
		}
	@RequestMapping("showClassCode.html")
	public String showClassCode(HttpServletRequest request, HttpServletResponse response){
		String studentId=request.getParameter("studentId");
		String sing =request.getParameter("sing");
		Student student = studentServiceInterface.selectStudentById(studentId);
		List<ShowStuCourse> showStuCourse = stuCourseServiceInterface.StuCourseByStudentId(studentId);
		if(null!=showStuCourse){
			request.setAttribute("student", student);
			request.setAttribute("showStuCourse", showStuCourse);
			
			if(sing!=null&&sing.equals("student")){
			return "theShowClassCard";
			}
			return "showClassCode";
		}
		return "student";
		}
	@RequestMapping("toShowPayCard.html")
	public String showPayCard(HttpServletRequest request, HttpServletResponse response){
		String studentId=request.getParameter("studentId");
		Student student = studentServiceInterface.selectStudentById(studentId);
		List<ShowStuCourse> showStuCourse = stuCourseServiceInterface.StuCourseByStudentId(studentId);
		if(null!=showStuCourse){
			request.setAttribute("student", student);
			request.setAttribute("showStuCourse", showStuCourse);
			return "showPayCard";
		}
		return "student";
		}
	@RequestMapping("toAddAppStuCourse.html")
	public void toAddAppStuCourse(HttpServletRequest request, HttpServletResponse response){
		String gradeName = request.getParameter("gradeName");
		String campusName = request.getParameter("campusName");
		Course course = new Course();
		course.setCampusName(campusName);
		course.setGradeName(gradeName);
		List<Course> courseList = new ArrayList<Course>();
		String message = "";
		PrintWriter out =null;
		try {
			message=JSON.toJSONString("error");
			courseList = courseServiceInterface.selectCourseByGradeNameAndCampusName(course);
			message=JSON.toJSONString(courseList);
			out=response.getWriter();
			out.print(message);
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			if(out!=null){
				out.close();
			}
		}							
	}
	@RequestMapping("addAppStuCourse.html")
	public void addAppStuCourse(HttpServletRequest request, HttpServletResponse response){
		String studentId = request.getParameter("studentId");
		String[] courseList= request.getParameter("courseList").split(",");
		//System.out.println(courseList.length);
		StuCourse stuCourse = new StuCourse();
		stuCourse.setStudentId(studentId);
		stuCourse.setPayState("未缴费");
		stuCourse.setState(2);
		String message = "";
		PrintWriter out =null;
		List<StuCourse> stuCourseId=null;
		try {
			for(int i=0;i<courseList.length;i++){
				stuCourse.setCourseId(courseList[i]);
				stuCourseId=stuCourseServiceInterface.checkStuCourseByStudentAndCourse(stuCourse);
				if(stuCourseId.size()==0){
					stuCourse.setCourseId(courseList[i]);
					stuCourseServiceInterface.addStuCourse(stuCourse);
				}
			}
			List<ShowStuCourse> stuCourseList=stuCourseServiceInterface.theStuCourseByStudentId(studentId);
			message=JSON.toJSONString(stuCourseList);		
			out=response.getWriter();
			out.print(message);
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			if(out!=null){
				out.close();
			}
		}
	}
	@RequestMapping("changePayState.html")
	public void changePayState(HttpServletRequest request, HttpServletResponse response){
		String studentId=request.getParameter("studentId");
		String courseId = request.getParameter("courseId");
		String payState = request.getParameter("payState");
		String stuCourseId=request.getParameter("stuCourseId");
		String studentPayCondition=request.getParameter("studentPayCondition");
		Course course = courseServiceInterface.selectCourseById(courseId);
		Student student = studentServiceInterface.selectStudentById(studentId);
		String campusCode = campusServiceInterface.selectCampusByName(student.getCampusName()).getCode();
		String gradeCode = gradeServiceInterface.selectGradeByName(student.getGradeName()).getCode();
		int studentPrices=0;
		String studentCode=null;
		String message = "";
		StuCourse  stuCourse = stuCourseServiceInterface.selectStuCourseById(stuCourseId);
		if(payState.equals("已缴费")){
			if(studentPayCondition.equals("未缴费")){
				stuCourse.setState(1);
				student.setPayCondition("已缴费");
				student.setState(3);
				studentCode=studentServiceInterface.selectStudentCode(campusCode+gradeCode);
				student.setStudentCode(studentCode);
				
			}else{
				stuCourse.setState(1);
			}
			
			if(stuCourse.getPayState().equals("未缴费")||stuCourse.getPayState()==null){
			studentPrices=student.getPrices()+(course.getRates()*course.getTheClass());
			
			}
			message = JSON.toJSONString("success");
			
		}
		if(payState.equals("已退费")){
			if(stuCourse.getPayState().equals("已缴费")){
			stuCourse.setState(0);
			student.setState(2);
			studentPrices =student.getPrices()-(course.getRates()*course.getTheClass());
			message = JSON.toJSONString("success");
			}else{
				payState="未缴费";
				message=JSON.toJSONString("error");;
			}
		}
		stuCourse.setPayState(payState);
		student.setPrices(studentPrices);
		
		PrintWriter out =null;
		try {
			studentServiceInterface.updateStudent(student);
			stuCourseServiceInterface.updateStuCourse(stuCourse);
			
			out=response.getWriter();
			out.print(message);
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			if(out!=null){
				out.close();
			}
		}
		
	}
	@RequestMapping("selectStudentDynamicNew.html")
	public String selectStudentDynamicNew(HttpServletRequest request, HttpServletResponse response){
		try {
			//String strPageNo = request.getParameter("pageNo");
			Student student = new Student();
			Course course = new Course();
			ShowStuCourse showStuCourse = new ShowStuCourse();
			Map<String,Object> map = new HashMap<String,Object>();
			List<School> schoolList = schoolServiceInterface.selectAllSchool();
			List<Grade> gradeList = gradeServiceInterface.selectAllGrade();
			List<Campus> campusList = new ArrayList<Campus>();
			if(Access.campusAccess(request)!=null){
				Campus campus = new Campus();
				campus.setCampusName(Access.campusAccess(request));
				campusList.add(campus);
			}else{
				campusList = campusServiceInterface.selectAllCampus();
			}	
			
			List<Subject> subjectList = subjectServiceInterface.selectAllSubject();
			request.setAttribute("subjectList", subjectList);
			request.setAttribute("schoolList", schoolList);
			request.setAttribute("gradeList", gradeList);
			request.setAttribute("campusList", campusList);
			//String likestudentName = new String(request.getParameter("likestudentName").getBytes("iso-8859-1"), "utf-8");
			//String studentCode = request.getParameter("studentCode");
			String gradeName=StrToStr.toStr(request.getParameter("gradeName"));
			String name=StrToStr.toStr(request.getParameter("name")) ;		
			String sex =StrToStr.toStr(request.getParameter("sex")) ;
			//String parentName = request.getParameter("parentName");
			String phoneNumOne = request.getParameter("phoneNumOne");
			//String phoneNumTwo = request.getParameter("phoneNumTwo");
			//String remark = request.getParameter("remark");
			String schoolName =StrToStr.toStr(request.getParameter("schoolName")) ;
			String campusName =StrToStr.toStr(request.getParameter("campusName")) ;
			String payCondition =StrToStr.toStr(request.getParameter("payCondition"));
			String subjectName =StrToStr.toStr(request.getParameter("subjectName"));
			
			int state = 0;
			String payState="";
			if(payCondition.equals("已缴费")){
				state=3;
				payState="已缴费";
			}
			if(payCondition.equals("未缴费")){
				state=1;
				payState="未缴费";
			}
			if(payCondition.equals("已退费")){
				state=2;
				payState="已退费";
			}
			Date createDate = strToDate.stringToDate(request.getParameter("createDate"));
			
			student.setGradeName(gradeName);
			student.setCampusName(campusName);
			student.setName(name);
			//student.setParentName(parentName);
			//student.setPayCondition(payCondition);
			student.setState(state);
			student.setPhoneNumOne(phoneNumOne);
			//student.setPhoneNumTwo(phoneNumTwo);
			//student.setRemark(remark);
			student.setSchoolName(schoolName);
			student.setSex(sex);
			student.setCreateDate(createDate);
			course.setSubjectName(subjectName);
			map.put("gradeName", gradeName);
			map.put("name", name);
			map.put("campusName", campusName);
			map.put("payState", payState);
			map.put("phoneNumOne", phoneNumOne);
			map.put("schoolName", schoolName);
			map.put("sex", sex);
			map.put("createDate", createDate);
			map.put("subjectName", subjectName);
			
			
			//student.setStudentCode(studentCode);;	
			//System.out.println(likestudentName);
			//String stu = JSON.toJSONString(student);
			//System.out.println(stu);
			
			List<Student> studentList= new ArrayList<Student>();
			if(subjectName.equals("")||subjectName==null){
				studentList=studentServiceInterface.selectStudentDynamic(student);
			}else{
				showStuCourse.setCourse(course);
				showStuCourse.setStudent(student);
				List <ShowStuCourse> showStuCourseList =stuCourseServiceInterface.selectStudentDynamicNew(map);
				
				for (int i=0;i<showStuCourseList.size();i++){
					studentList.add(showStuCourseList.get(i).getStudent());
				}
			}
			
					
			//List<Student> studentList = studentServiceInterface.selectStudentDynamic(student);
			//Tabs tabs=Paging.studentTabs(studentList, strPageNo);
			//request.setAttribute("studentList", tabs.getStudentList());
			//request.setAttribute("pageNo", tabs.getPageNo());
			//request.setAttribute("totalPage", tabs.getTotalPage());
			request.setAttribute("studentList",studentList);
			request.setAttribute("student", student);
			
			return "student";	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "student";
	}
}
