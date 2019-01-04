package com.util;

import java.util.List;

import javax.annotation.Resource;

import com.pojo.Course;
import com.service.CourseServiceInterface;

public class ShowCourse {
	@Resource
	private static CourseServiceInterface courseServiceInterface;
	public static List<Course> getCouseList(Course course){
		List<Course> courseList = courseServiceInterface.selectCourseByGradeNameAndCampusName(course);
		
		return courseList;
		
	}

}
