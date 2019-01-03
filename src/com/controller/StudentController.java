package com.controller;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
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
import com.pojo.School;
import com.pojo.StuCourse;
import com.pojo.Student;
import com.pojo.Grade;
import com.pojo.Subject;
import com.service.CampusServiceInterface;
import com.service.CourseServiceInterface;
import com.service.GradeServiceInterface;
import com.service.SchoolServiceInterface;
import com.service.StuCourseServiceInterface;
import com.service.StudentServiceInterface;
import com.service.SubjectServiceInterface;
import com.util.GetApplyNum;
import com.util.Paging;
import com.util.SendMessage;
import com.util.ShowStuCourse;
import com.util.StrToStr;
import com.util.StringToDate;
import com.util.Tabs;


/**
 * @author syd2018-8-16下午3:23:53
 * @version 创建时间：2018-8-16 下午3:23:53
 * 类说明
 */
/**        
 * 类名称：StudentController   
 * 类描述：   
 * 创建人：syd   
 * 创建时间：2018-8-16 下午3:23:53      
 * @version    
 *    
 */
@Controller
public class StudentController {
	@Autowired
	private StudentServiceInterface studentServiceInterface;
	@Autowired
	private GradeServiceInterface gradeServiceInterface;
	@Autowired
	private SchoolServiceInterface schoolServiceInterface;
	@Autowired
	private CampusServiceInterface campusServiceInterface;
	@Autowired
	private StuCourseServiceInterface stuCourseServiceInterface;
	@Autowired
	private SubjectServiceInterface subjectServiceInterface;
	@Autowired
	private CourseServiceInterface courseServiceInterface;
	StringToDate strToDate = new StringToDate();
	/**
	 * 
	 * 方法描述：   学生页面
	 * 创建人：syd   
	 * 创建时间：2018-12-3 下午5:14:01      
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/student.html")
	public String student(HttpServletRequest request, HttpServletResponse response){
		String strPageNo = request.getParameter("pageNo");
		//String strPageNo ="";
	
		List<School> schoolList = schoolServiceInterface.selectAllSchool();
		List<Grade> gradeList = gradeServiceInterface.selectAllGrade();
		List<Campus> campusList = campusServiceInterface.selectAllCampus();
		List<Subject> subjectList = subjectServiceInterface.selectAllSubject();
		request.setAttribute("schoolList", schoolList);
		request.setAttribute("gradeList", gradeList);
		request.setAttribute("campusList", campusList);
		request.setAttribute("subjectList", subjectList);
		List<Student> allStudent = studentServiceInterface.selectAllStudent();
		Tabs tabs=Paging.studentTabs(allStudent, strPageNo);
		request.setAttribute("studentList", tabs.getStudentList());
		request.setAttribute("pageNo", tabs.getPageNo());
		request.setAttribute("totalPage", tabs.getTotalPage());
		return "student";
		
	}
	/**
	 * 
	 * 方法描述： 跳转到添加学生页面  
	 * 创建人：syd   
	 * 创建时间：2018-12-3 下午5:14:42      
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/toAddStudent.html")
	public String toAddStudent(HttpServletRequest request, HttpServletResponse response){
		List<School> schoolList = schoolServiceInterface.selectAllSchool();
		List<Grade> gradeList = gradeServiceInterface.selectAllGrade();
		List<Campus> campusList = campusServiceInterface.selectAllCampus();
		//String id = request.getParameter("id");
		//student =studentServiceInterface.selectStudentById(id); 
		//request.setAttribute("student", student);
		String student = request.getParameter("student");
		request.setAttribute("schoolList", schoolList);
		request.setAttribute("gradeList", gradeList);
		request.setAttribute("campusList", campusList);
		if(student!=null){
			if(student.equals("student")){
				return "studentApply";
			}
		}
		
		return "addStudent";		
	}
	/**
	 * 
	 * 方法描述：添加学生页面   
	 * 创建人：syd   
	 * 创建时间：2018-12-3 下午5:15:21      
	 * @param request
	 * @param response
	 */
	@RequestMapping("/addStudent.html")
	public void addStudent(HttpServletRequest request, HttpServletResponse response){
		//String studentCode = request.getParameter("studentCode");
		int theMaxApplyNum = 0;
		int allStudentNum=studentServiceInterface.selectAllStudentNum();
		
		if(allStudentNum!=0){
			theMaxApplyNum=studentServiceInterface.selectApplyNum();
		}
		int applyNum = GetApplyNum.getApplyNum(theMaxApplyNum,allStudentNum);
		
		Student student = new Student();
		String[] courseList= request.getParameterValues("courseList");
		String code = request.getParameter("code");
		String formId = request.getParameter("formId");
		String gradeName=request.getParameter("gradeName");
		String name= request.getParameter("name");		
		String sex = request.getParameter("sex");
		String parentName = request.getParameter("parentName");
		String phoneNumOne = request.getParameter("phoneNumOne");
		//String phoneNumTwo = request.getParameter("phoneNumTwo");
		//String remark = request.getParameter("remark");
		String schoolName = request.getParameter("schoolName");
		String campusName = request.getParameter("campusName");
		
		String payCondition =request.getParameter("payCondition");
		String campusCode = campusServiceInterface.selectCampusByName(campusName).getCode();
		String gradeCode = gradeServiceInterface.selectGradeByName(gradeName).getCode();
		String studentCode=null;
		String payState = "未缴费";
		int state = 2;
		String strPrice =request.getParameter("prices");
		int prices=0;
		if(payCondition!=null&&payCondition.equals("已缴费")){	
		 studentCode=studentServiceInterface.selectStudentCode(campusCode+gradeCode);
		 student.setState(3);
		 payState ="已缴费";
		 state=1;
		 if(strPrice!=null){
				prices = Integer.parseInt(strPrice);
				}
		}else{
			payCondition="未缴费";
			student.setState(1);
		}	
		//System.out.println(gradeName);
		student.setGradeName(gradeName);
		student.setCampusName(campusName);
		student.setName(name);
		student.setParentName(parentName);
		//System.out.println(payCondition);
		student.setPayCondition(payCondition);
		student.setPhoneNumOne(phoneNumOne);
		student.setPrices(prices);
		student.setStudentCode(studentCode);
		//student.setPhoneNumTwo(phoneNumTwo);
		//student.setRemark(remark);
		student.setSchoolName(schoolName);
		student.setSex(sex);
		student.setApplyNum(applyNum);
		
		SendMessage sendMessage = new SendMessage();
		List<ShowStuCourse> stuCourseList = new ArrayList<ShowStuCourse>();
		
		//student.setStudentCode(studentCode);
		String message="";
		PrintWriter out =null;
		Student checkStudent = new Student();
		List<StuCourse> stuCourseId=null;
		try {
			out=response.getWriter();
			checkStudent=studentServiceInterface.selectStudentByNameAndPhoneNum(student);
			if(null!=checkStudent){
			message = JSON.toJSONString("student");
			}else{
				studentServiceInterface.addStudent(student);//先添加学生
				checkStudent=studentServiceInterface.selectStudentByNameAndPhoneNum(student);//查出学生id
				StuCourse stuCourse = new StuCourse();
				stuCourse.setStudentId(checkStudent.getId());
				stuCourse.setPayState(payState);
				if(courseList!=null){
					for(int i=0;i<courseList.length;i++){
						stuCourse.setCourseId(courseList[i]);
						stuCourseId=stuCourseServiceInterface.checkStuCourseByStudentAndCourse(stuCourse);
					}
				}
				
				//System.out.println(stuCourseId);
				if(stuCourseId!=null){
				if(stuCourseId.size()==0 &&courseList!=null){
					for(int i=0;i<courseList.length;i++){
						stuCourse.setCourseId(courseList[i]);
						stuCourse.setState(state);
						stuCourseServiceInterface.addStuCourse(stuCourse);
					}
				}
				}
				message = JSON.toJSONString(checkStudent);
			}		
			/*if(code!=null&&formId!=null){
				sendMessage.sendMessage(code, formId, student,stuCourseList);
			}*/
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
	/**
	 * 
	 * 方法描述：   跳转到学生修改页面
	 * 创建人：syd   
	 * 创建时间：2018-12-3 下午5:15:53      
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/toUpdateStudent.html")
	public String toUpdateStudent(HttpServletRequest request, HttpServletResponse response){
		Student student = new Student();
		String id = request.getParameter("id");
		List<School> schoolList = schoolServiceInterface.selectAllSchool();
		List<Grade> gradeList = gradeServiceInterface.selectAllGrade();
		List<Campus> campusList = campusServiceInterface.selectAllCampus();
		request.setAttribute("schoolList", schoolList);
		request.setAttribute("gradeList", gradeList);
		request.setAttribute("campusList", campusList);
		
		try {
			student = studentServiceInterface.selectStudentById(id);
			if(null!=student){
				request.setAttribute("student", student);
				return "updateStudent";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "addStudent";						
	}
	/**
	 * 
	 * 方法描述：修改学生页面   
	 * 创建人：syd   
	 * 创建时间：2018-12-3 下午5:16:35      
	 * @param request
	 * @param response
	 */
	@RequestMapping("/updateStudent.html")
	public void updateStudent(HttpServletRequest request, HttpServletResponse response){		
		Student student = new Student();
		
		
		String id = request.getParameter("id");
		String gradeName=request.getParameter("gradeName");
		String name= request.getParameter("name");		
		String sex = request.getParameter("sex");
		String parentName = request.getParameter("parentName");
		String phoneNumOne = request.getParameter("phoneNumOne");
		//String phoneNumTwo = request.getParameter("phoneNumTwo");
		//String remark = request.getParameter("remark");
		String schoolName = request.getParameter("schoolName");
		String campusName = request.getParameter("campusName");
		String payCondition = request.getParameter("payCondition");
		//String schoolCode = schoolServiceInterface.selectSchoolByName(schoolName).getCode();
		String campusCode = campusServiceInterface.selectCampusByName(campusName).getCode();
		String gradeCode = gradeServiceInterface.selectGradeByName(gradeName).getCode();
		String studentCode=null;
		String payState = "未缴费";
		int prices=0;
		Course course = new Course();
		List <StuCourse> stuCourseList =stuCourseServiceInterface.selectStuCourseByStudentId(id);
		int state =2;
		if(payCondition.equals("已缴费")){
			student.setState(3);
		 studentCode=studentServiceInterface.selectStudentCode(campusCode+gradeCode);
		 payState = "已缴费";
		 state=1;
		 for(int i=0;i<stuCourseList.size();i++){
			 if(stuCourseList.get(i).getState()==2){
				 course=courseServiceInterface.selectCourseById(stuCourseList.get(i).getCourseId());
				 stuCourseList.get(i).setPayState(payState);
				 stuCourseList.get(i).setState(state);
				 stuCourseServiceInterface.updateStuCourse(stuCourseList.get(i));
				 prices+=course.getRates()*course.getTheClass();
			 }
			 
		 }
		}
		student.setPrices(prices);
		student.setId(id);
		student.setGradeName(gradeName);
		student.setCampusName(campusName);
		student.setName(name);
		student.setParentName(parentName);
		student.setPayCondition(payCondition);
		student.setPhoneNumOne(phoneNumOne);
		//student.setPhoneNumTwo(phoneNumTwo);
		//student.setRemark(remark);
		student.setSchoolName(schoolName);
		student.setSex(sex);
		student.setStudentCode(studentCode);;
		String message="";
		PrintWriter out =null;
		
		try {
			out=response.getWriter();
			studentServiceInterface.updateStudent(student);
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
	/**
	 * 
	 * 方法描述：删除学生   
	 * 创建人：syd   
	 * 创建时间：2018-12-3 下午5:17:00      
	 * @param request
	 * @param response
	 */
	@RequestMapping("/deleteStudent.html")
	public void deleteStudent(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		PrintWriter out =null;
		String message = JSON.toJSONString("success");
		try {
			out=response.getWriter();
			studentServiceInterface.deleteStudent(id);
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
	/*@RequestMapping("selectstudentLikeName.html")
	public void selectstudentLikeName(HttpServletRequest request, HttpServletResponse response){
		String likestudentName= request.getParameter("likestudentName");
		PrintWriter out = null;
		try {
		out = response.getWriter();
		List<student> studentList = studentServiceInterface.selectstudentLikeName(likestudentName);
		if(null!=studentList){
			String str = JSON.toJSONString(studentList);
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
	/**
	 * 
	 * 方法描述：  动态查询学生 
	 * 创建人：syd   
	 * 创建时间：2018-12-3 下午5:17:25      
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("selectStudentDynamic.html")
	public String selectStudentDynamic(HttpServletRequest request, HttpServletResponse response){
		try {
			String strPageNo = request.getParameter("pageNo");
			Student student = new Student();
			List<School> schoolList = schoolServiceInterface.selectAllSchool();
			List<Grade> gradeList = gradeServiceInterface.selectAllGrade();
			List<Campus> campusList = campusServiceInterface.selectAllCampus();
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
			int state = 0;
			if(payCondition.equals("已缴费")){
				state=3;
			}
			if(payCondition.equals("未缴费")){
				state=1;
			}
			if(payCondition.equals("已退费")){
				state=2;
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
			//student.setStudentCode(studentCode);;	
			//System.out.println(likestudentName);
			//String stu = JSON.toJSONString(student);
			//System.out.println(stu);
			List<Student> studentList = studentServiceInterface.selectStudentDynamic(student);
			Tabs tabs=Paging.studentTabs(studentList, strPageNo);
			request.setAttribute("studentList", tabs.getStudentList());
			request.setAttribute("pageNo", tabs.getPageNo());
			request.setAttribute("totalPage", tabs.getTotalPage());
			request.setAttribute("student", student);
			
			return "student";	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "student";
	}
	/**
	 * 
	 * 方法描述：   查询报名大于几科学生
	 * 创建人：syd   
	 * 创建时间：2018-12-3 下午5:17:58      
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/checkGreaterStuCourse.html")
	public String checkGreaterStuCourse(HttpServletRequest request, HttpServletResponse response){
		String theGreaterNum=request.getParameter("theGreaterNum");
		List<School> schoolList = schoolServiceInterface.selectAllSchool();
		List<Grade> gradeList = gradeServiceInterface.selectAllGrade();
		List<Campus> campusList = campusServiceInterface.selectAllCampus();
		List<Subject> subjectList = subjectServiceInterface.selectAllSubject();
		request.setAttribute("schoolList", schoolList);
		request.setAttribute("gradeList", gradeList);
		request.setAttribute("campusList", campusList);
		request.setAttribute("subjectList", subjectList);
		List<Student> studentList = studentServiceInterface.checkGreaterStuCourse(Integer.parseInt(theGreaterNum));
		request.setAttribute("studentList", studentList);
		request.setAttribute("theGreaterNum", theGreaterNum);
		return "student";
		
	}
	/**
	 * 
	 * 方法描述： 跳转小程序报名主页  
	 * 创建人：syd   
	 * 创建时间：2018-12-3 下午5:18:47      
	 * @param request
	 * @param response
	 */
	@RequestMapping("/toAddAppStudent.html")
	public void toAddAppStudent(HttpServletRequest request, HttpServletResponse response){
		List<School> schoolList = schoolServiceInterface.selectAllSchool();
		List<Grade> gradeList = gradeServiceInterface.selectAllGrade();
		List<Campus> campusList = campusServiceInterface.selectAllCampus();
		//String id = request.getParameter("id");
		//student =studentServiceInterface.selectStudentById(id); 
		//request.setAttribute("student", student);
		String message="";
		PrintWriter out =null;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("schoolList", schoolList);
		map.put("gradeList", gradeList);
		map.put("campusList", campusList);
		try {
			out=response.getWriter();
			message=JSON.toJSONString(map);
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
	/**
	 * 
	 * 方法描述：小程序登录   
	 * 创建人：syd   
	 * 创建时间：2018-9-19 下午4:40:33      
	 * @param request
	 * @param response
	 */
	@RequestMapping("/studentNameAndPhone.html")
	public void studentNameAndPhone(HttpServletRequest request, HttpServletResponse response){
		SendMessage sendMessage = new SendMessage();
		String code = request.getParameter("code");
		String formId = request.getParameter("formId");
		String name = request.getParameter("name");
		String phoneNum = request.getParameter("phoneNum");
		Map<String, Object> map = new HashMap<String, Object>();
		Student student  = new Student();
		Student checkStudent  = new Student();
		List<ShowStuCourse> stuCourseList = new ArrayList<ShowStuCourse>();
		student.setName(name);
		student.setPhoneNumOne(phoneNum);
		String message="";
		PrintWriter out =null;
		try {
			checkStudent = studentServiceInterface.selectStudentByNameAndPhoneNum(student);
			if(null!=checkStudent){

				stuCourseList=stuCourseServiceInterface.StuCourseByStudentId(checkStudent.getId());
				//System.out.println(stuCourseList.size());
				//if(code!=null&&formId!=null&&stuCourseList.size()>0){
					//sendMessage.sendMessage(code, formId, checkStudent,stuCourseList);
				//}
				map.put("student", checkStudent);
				map.put("stuCourseList", stuCourseList);
				message=JSON.toJSONString(map);
			}else{
				message=JSON.toJSONString("error");
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
	/**
	 * 
	 * 方法描述：修改小程序学生页面   
	 * 创建人：syd   
	 * 创建时间：2018-12-3 下午5:19:32      
	 * @param request
	 * @param response
	 */
	@RequestMapping("/updateAppStudent.html")
	public void updateAppStudent(HttpServletRequest request, HttpServletResponse response){		
		Student student = new Student();
		String id = request.getParameter("id");
		String gradeName=request.getParameter("gradeName");
		String name= request.getParameter("name");		
		String sex = request.getParameter("sex");
		String parentName = request.getParameter("parentName");
		String phoneNumOne = request.getParameter("phoneNumOne");
		String schoolName = request.getParameter("schoolName");
		String campusName = request.getParameter("campusName");
		String payCondition = "未缴费";
		student.setId(id);
		student.setGradeName(gradeName);
		student.setCampusName(campusName);
		student.setName(name);
		student.setParentName(parentName);
		student.setPayCondition(payCondition);
		student.setPhoneNumOne(phoneNumOne);
		student.setSchoolName(schoolName);
		student.setSex(sex);
		String message="";
		PrintWriter out =null;
		
		try {
			out=response.getWriter();
			message = JSON.toJSONString("error");
			studentServiceInterface.updateStudent(student);
			student = studentServiceInterface.selectStudentById(id);
			System.out.println(student.getPayCondition());
			message = JSON.toJSONString(student);
			out.print(message);
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally{
			if(out!=null){
				out.close();
			}
		}
	}
	/**
	 * 
	 * 方法描述：   学生电话和姓名验证
	 * 创建人：syd   
	 * 创建时间：2018-12-3 下午5:19:58      
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/studentApplyNameAndPhone.html")
	public String studentApplyNameAndPhone(HttpServletRequest request, HttpServletResponse response){
		String name="";
		try {
			name = StrToStr.toStr(request.getParameter("name"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String phoneNum = request.getParameter("phoneNum");
		
		Student student  = new Student();
		
		student.setName(name);
		student.setPhoneNumOne(phoneNum);

		student = studentServiceInterface.selectStudentByNameAndPhoneNum(student);
		request.setAttribute("student", student);
	    return "theStudent";		
			
	}
	/**
	 * 
	 * 方法描述：学生登录   
	 * 创建人：syd   
	 * 创建时间：2018-12-3 下午5:21:16      
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/theStudentApplyNameAndPhone.html")
	public String theStudentApplyNameAndPhone(HttpServletRequest request, HttpServletResponse response){
		String name="";
		try {
			request.setCharacterEncoding("utf-8");
			name = request.getParameter("name");
			
			String phoneNum = request.getParameter("phoneNum");
			
			Student student  = new Student();
			
			student.setName(name);
			student.setPhoneNumOne(phoneNum);

			student = studentServiceInterface.selectStudentByNameAndPhoneNum(student);
			request.setAttribute("student", student);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    return "theStudent";		
			
	}
	/**
	 * 
	 * 方法描述：   学生报名后跳转单个学生页面
	 * 创建人：syd   
	 * 创建时间：2018-12-3 下午5:22:08      
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("singleStudent.html")
	public String singleStudent(HttpServletRequest request, HttpServletResponse response){
		String name="";
		try {
			name = StrToStr.toStr(request.getParameter("name"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String phoneNum = request.getParameter("phoneNum");
		
		Student student  = new Student();
		
		student.setName(name);
		student.setPhoneNumOne(phoneNum);

		student = studentServiceInterface.selectStudentByNameAndPhoneNum(student);
		request.setAttribute("student", student);
	    return "singleStudent";	
			
	}
	/**
	 * 
	 * 方法描述：  报名号查询 
	 * 创建人：syd   
	 * 创建时间：2018-12-3 下午5:22:53      
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/checkapplyNum.html")
	public String checkapplyNum(HttpServletRequest request, HttpServletResponse response){
		try {
			String strPageNo = request.getParameter("pageNo");
			Student student = new Student();
			List<School> schoolList = schoolServiceInterface.selectAllSchool();
			List<Grade> gradeList = gradeServiceInterface.selectAllGrade();
			List<Campus> campusList = campusServiceInterface.selectAllCampus();
			List<Subject> subjectList = subjectServiceInterface.selectAllSubject();
			request.setAttribute("schoolList", schoolList);
			request.setAttribute("gradeList", gradeList);
			request.setAttribute("campusList", campusList);
			request.setAttribute("subjectList", subjectList);
			//String likestudentName = new String(request.getParameter("likestudentName").getBytes("iso-8859-1"), "utf-8");
			//String studentCode = request.getParameter("studentCode");
			int applyNum =Integer.parseInt(request.getParameter("applyNum")) ;
			
			List<Student> studentList = studentServiceInterface.selectStudentByApplyNum(applyNum);
			Tabs tabs=Paging.studentTabs(studentList, strPageNo);
			request.setAttribute("studentList", tabs.getStudentList());
			request.setAttribute("pageNo", tabs.getPageNo());
			request.setAttribute("totalPage", tabs.getTotalPage());
			request.setAttribute("student", student);
			
			return "student";	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "student";
	}
	/**
	 * 
	 * 方法描述：   根据课程名称查询学生
	 * 创建人：syd   
	 * 创建时间：2018-12-3 下午5:23:27      
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/checkStuCourseBySubjectName.html")
	public String checkStuCourseBySubjectName(HttpServletRequest request, HttpServletResponse response){
		try {
			String subjectName=StrToStr.toStr(request.getParameter("subjectName"));
			List<School> schoolList = schoolServiceInterface.selectAllSchool();
			List<Grade> gradeList = gradeServiceInterface.selectAllGrade();
			List<Campus> campusList = campusServiceInterface.selectAllCampus();
			List<Subject> subjectList = subjectServiceInterface.selectAllSubject();
			request.setAttribute("schoolList", schoolList);
			request.setAttribute("gradeList", gradeList);
			request.setAttribute("campusList", campusList);
			request.setAttribute("subjectList", subjectList);
			List<ShowStuCourse> showStuCourseList = stuCourseServiceInterface.StuCourseBySubjectName(subjectName);
			List<Student> studentList=new ArrayList<Student>();
			for(int i=0;i<showStuCourseList.size();i++){
				if(null!=showStuCourseList.get(i).getStudent().getName()){
					studentList.add(showStuCourseList.get(i).getStudent());
				}		
			}
			request.setAttribute("studentList", studentList);
			request.setAttribute("subjectName", subjectName);
			return "student";
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "student";
		
		
	}
}
