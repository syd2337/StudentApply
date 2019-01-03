package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.CourseMapper;
import com.pojo.Course;

@Service
public class CourseService implements CourseServiceInterface {
	@Resource
	private CourseMapper courseMapper;

	@Override
	public void addCourse(Course course) {
		// TODO Auto-generated method stub
		courseMapper.addCourse(course);

	}

	@Override
	public List<Course> selectAllCourse() {
		// TODO Auto-generated method stub
		return courseMapper.selectAllCourse();
	}

	@Override
	public Course selectCourseById(String id) {
		// TODO Auto-generated method stub
		return courseMapper.selectCourseById(id);
	}

	@Override
	public List<Course> selectCourseDynamic(Course course) {
		// TODO Auto-generated method stub
		return courseMapper.selectCourseDynamic(course);
	}

	@Override
	public void updateCourse(Course course) {
		// TODO Auto-generated method stub
		courseMapper.updateCourse(course);
	}

	@Override
	public void deleteCourse(String id) {
		// TODO Auto-generated method stub
		courseMapper.deleteCourse(id);
	}

	@Override
	public List<Course> selectCourseByGradeName(String gradeName) {
		// TODO Auto-generated method stub
		return courseMapper.selectCourseByGradeName(gradeName);
	}

	/* (non-Javadoc)
	 * @see com.service.CourseServiceInterface#selectAllCourseNum()
	 */
	@Override
	public int selectAllCourseNum() {
		// TODO Auto-generated method stub
		return courseMapper.selectAllCourseNum();
	}

	/* (non-Javadoc)
	 * @see com.service.CourseServiceInterface#selectCourseByGradeNameAndCampusName(com.pojo.Course)
	 */
	@Override
	public List<Course> selectCourseByGradeNameAndCampusName(Course course) {
		// TODO Auto-generated method stub
		return courseMapper.selectCourseByGradeNameAndCampusName(course);
	}
}
