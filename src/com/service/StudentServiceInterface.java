package com.service;

import java.util.List;

import com.pojo.Student;

public interface StudentServiceInterface {
	void addStudent(Student student);
	List<Student> selectAllStudent();
	Student selectStudentById(String id);
	List<Student> selectStudentDynamic(Student student);
	void updateStudent(Student student);
	void deleteStudent(String student);
	String selectStudentCode(String studentSchoolGrade);
	List<Student>checkGreaterStuCourse(int greaterNum);
	int selectAllStudentByPayCondition(String payCondition);
	int selectAllStudentNum();
	Student selectStudentByNameAndPhoneNum (Student student);
	int selectApplyNum();
	List<Student> selectStudentByApplyNum(int applyNum);
	void updateStudentOpenIdAndFormId(Student student);
	List<Student> selectStudentByCampus(String campusName);
}
