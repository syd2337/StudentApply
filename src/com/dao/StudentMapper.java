package com.dao;

import java.util.List;


import com.pojo.Student;

/**
 * @author syd2018-8-2下午4:48:50
 * @version 创建时间：2018-8-2 下午4:48:50
 * 类说明
 */
/**        
 * 类名称：StudentMapper   
 * 类描述：   
 * 创建人：syd   
 * 创建时间：2018-8-2 下午4:48:50      
 * @version    
 *    
 */
public interface StudentMapper {
	void addStudent(Student student);
	List<Student> selectAllStudent();
	Student selectStudentById(String id);
	List<Student> selectStudentDynamic(Student student);
	void updateStudent(Student student);
	void deleteStudent(String id);
	String selectStudentCode(String studentSchoolGrade);
	List<Student>checkGreaterStuCourse(int greaterNum);
	int selectAllStudentNum();
	int selectAllStudentByPayCondition(String payCondition);
	Student selectStudentByNameAndPhoneNum (Student student);
	int selectApplyNum();
	List<Student> selectStudentByApplyNum(int applyNum);
	void updateStudentOpenIdAndFormId(Student student);
	

}
