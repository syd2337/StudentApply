package com.dao;

import java.util.List;


import com.pojo.Student;

/**
 * @author syd2018-8-2����4:48:50
 * @version ����ʱ�䣺2018-8-2 ����4:48:50
 * ��˵��
 */
/**        
 * �����ƣ�StudentMapper   
 * ��������   
 * �����ˣ�syd   
 * ����ʱ�䣺2018-8-2 ����4:48:50      
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
