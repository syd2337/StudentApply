package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.StudentMapper;
import com.pojo.Student;
import com.util.StringToDate;

@Service
public class StudentService implements StudentServiceInterface {
	@Resource
	private StudentMapper studentMapper;

	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		studentMapper.addStudent(student);
	}

	@Override
	public List<Student> selectAllStudent() {
		// TODO Auto-generated method stub
		return studentMapper.selectAllStudent();
	}

	@Override
	public Student selectStudentById(String id) {
		// TODO Auto-generated method stub
		return studentMapper.selectStudentById(id);
	}

	@Override
	public List<Student> selectStudentDynamic(Student student) {
		// TODO Auto-generated method stub
		return studentMapper.selectStudentDynamic(student);
	}

	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		studentMapper.updateStudent(student);
	}

	@Override
	public void deleteStudent(String id) {
		// TODO Auto-generated method stub
		studentMapper.deleteStudent(id);
	}

	@Override
	public String selectStudentCode(String studentSchoolGrade) {
		// TODO Auto-generated method stub
		String theMaxStudentCode = studentMapper.selectStudentCode(studentSchoolGrade);//TJGY20180001
		String studentCode=null;
		String seasonCode = StringToDate.getCode();
		if(theMaxStudentCode!=null){
			String schoolGrade=theMaxStudentCode.substring(1, 5);
			//System.out.println(schoolGrade+"+++"+theMaxStudentCode);
			int code = Integer.parseInt(theMaxStudentCode.substring(5))+1;
			studentCode=seasonCode+schoolGrade+code;
		}else{
			studentCode=seasonCode+studentSchoolGrade+"20180001";
		}
		return studentCode;
	}

	@Override
	public List<Student> checkGreaterStuCourse(int greaterNum) {
		// TODO Auto-generated method stub
		return studentMapper.checkGreaterStuCourse(greaterNum);
	}

	/* (non-Javadoc)
	 * @see com.service.StudentServiceInterface#selectAllStudentByPayCondition(java.lang.String)
	 */
	@Override
	public int selectAllStudentByPayCondition(String payCondition) {
		// TODO Auto-generated method stub
		return studentMapper.selectAllStudentByPayCondition(payCondition);
	}

	/* (non-Javadoc)
	 * @see com.service.StudentServiceInterface#selectAllStudentNum()
	 */
	@Override
	public int selectAllStudentNum() {
		// TODO Auto-generated method stub
		return studentMapper.selectAllStudentNum();
	}

	@Override
	public Student selectStudentByNameAndPhoneNum(Student student) {
		// TODO Auto-generated method stub
		return studentMapper.selectStudentByNameAndPhoneNum(student);
	}

	/* (non-Javadoc)
	 * @see com.service.StudentServiceInterface#selectApplyNum()
	 */
	@Override
	public int selectApplyNum() {
		// TODO Auto-generated method stub
		return studentMapper.selectApplyNum();
	}

	@Override
	public List<Student> selectStudentByApplyNum(int applyNum) {
		// TODO Auto-generated method stub
		return studentMapper.selectStudentByApplyNum(applyNum);
	}

	/* (non-Javadoc)
	 * @see com.service.StudentServiceInterface#updateStudentOpenIdAndFormId(com.pojo.Student)
	 */
	@Override
	public void updateStudentOpenIdAndFormId(Student student) {
		studentMapper.updateStudentOpenIdAndFormId(student);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Student> selectStudentByCampus(String campusName) {
		// TODO Auto-generated method stub
		return studentMapper.selectStudentByCampus(campusName);
	}
}
