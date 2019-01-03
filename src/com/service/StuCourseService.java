package com.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.StuCourseMapper;
import com.pojo.StuCourse;
import com.util.ShowStuCourse;

@Service
public class StuCourseService implements StuCourseServiceInterface {
	@Resource
	private StuCourseMapper stuCourseMapper;

	@Override
	public void addStuCourse(StuCourse stuCourse) {
		// TODO Auto-generated method stub
		stuCourseMapper.addStuCourse(stuCourse);
	}

	@Override
	public List<StuCourse> selectAllStuCourse() {
		// TODO Auto-generated method stub
		return stuCourseMapper.selectAllStuCourse();
	}

	@Override
	public StuCourse selectStuCourseById(String id) {
		// TODO Auto-generated method stub
		return stuCourseMapper.selectStuCourseById(id);
	}

	@Override
	public List<StuCourse> selectStuCourseDynamic(StuCourse stuCourse) {
		// TODO Auto-generated method stub
		return stuCourseMapper.selectStuCourseDynamic(stuCourse);
	}

	@Override
	public void updateStuCourse(StuCourse stuCourse) {
		// TODO Auto-generated method stub
		stuCourseMapper.updateStuCourse(stuCourse);
	}

	@Override
	public void deleteStuCourse(String id) {
		// TODO Auto-generated method stub
		stuCourseMapper.deleteStuCourse(id);
	}

	@Override
	public List<StuCourse> selectStuCourseGtFour() {
		// TODO Auto-generated method stub
		return stuCourseMapper.selectStuCourseGtFour();
	}

	@Override
	public List<StuCourse> selectStuCourseGtThree() {
		// TODO Auto-generated method stub
		return stuCourseMapper.selectStuCourseGtThree();
	}

	@Override
	public List<StuCourse> selectStuCourseGtTwo() {
		// TODO Auto-generated method stub
		return stuCourseMapper.selectStuCourseGtTwo();
	}

	@Override
	public List<ShowStuCourse> allStuCoursesResult() {
		// TODO Auto-generated method stub
		return stuCourseMapper.allStuCoursesResult();
	}

	@Override
	public List<ShowStuCourse> StuCourseByStudentId(String id) {
		// TODO Auto-generated method stub
		return stuCourseMapper.StuCourseByStudentId(id);
	}

	@Override
	public ShowStuCourse StuCourseByStuCourseId(String stuCourseId) {
		// TODO Auto-generated method stub
		return stuCourseMapper.StuCourseByStuCourseId(stuCourseId);
	}

	@Override
	public List<ShowStuCourse> StuCourseBySubjectName(String subjectName) {
		// TODO Auto-generated method stub
		return stuCourseMapper.StuCourseBySubjectName(subjectName);
	}

	/* (non-Javadoc)
	 * @see com.service.StuCourseServiceInterface#checkStuCourseByStudentAndCourse(com.pojo.StuCourse)
	 */
	@Override
	public List<StuCourse> checkStuCourseByStudentAndCourse(StuCourse stuCourse) {
		// TODO Auto-generated method stub
		return stuCourseMapper.checkStuCourseByStudentAndCourse(stuCourse);
	}

	@Override
	public List<ShowStuCourse> StuCourseByCourseId(String courseId) {
		// TODO Auto-generated method stub
		return stuCourseMapper.StuCourseByCourseId(courseId);
	}

	@Override
	public List<StuCourse> selectStuCourseByStudentId(String studentId) {
		// TODO Auto-generated method stub
		return stuCourseMapper.selectStuCourseByStudentId(studentId);
	}

	/* (non-Javadoc)
	 * @see com.service.StuCourseServiceInterface#StuCourseByCourseIdAndTheTimes(java.util.Map)
	 */
	@Override
	public List<ShowStuCourse> StuCourseByCourseIdAndTheTimes(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return stuCourseMapper.StuCourseByCourseIdAndTheTimes(map);
	}

	@Override
	public List<ShowStuCourse> theStuCourseByStudentId(String studentId) {
		// TODO Auto-generated method stub
		return stuCourseMapper.theStuCourseByStudentId(studentId);
	}

	

	@Override
	public List<ShowStuCourse> selectStudentDynamicNew(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return stuCourseMapper.selectStudentDynamicNew(map);
	}

	

	
}
