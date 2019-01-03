package com.dao;

import java.util.List;

import com.pojo.Course;

/**
 * @author syd2018-8-2下午4:46:39
 * @version 创建时间：2018-8-2 下午4:46:39
 * 类说明
 */
/**        
 * 类名称：CourseMapper   
 * 类描述：   
 * 创建人：syd   
 * 创建时间：2018-8-2 下午4:46:39      
 * @version    
 *    
 */
public interface CourseMapper {
	/**
	 * 
	 * 方法描述：添加课程   
	 * 创建人：syd   
	 * 创建时间：2018-8-3 下午3:17:47      
	 * @param course
	 */
	void addCourse(Course course);
	/**
	 * 
	 * 方法描述：  选择所有课程 
	 * 创建人：syd   
	 * 创建时间：2018-8-3 下午3:18:11      
	 * @return
	 */
	List<Course> selectAllCourse();
	/**
	 * 
	 * 方法描述：选择课程根据课程id   
	 * 创建人：syd   
	 * 创建时间：2018-8-3 下午3:18:57      
	 * @param id
	 * @return
	 */
	Course selectCourseById(String id);
	/**
	 * 
	 * 方法描述：动态查询课程   
	 * 创建人：syd   
	 * 创建时间：2018-8-3 下午3:19:37      
	 * @param course
	 * @return
	 */
	List<Course> selectCourseDynamic(Course course);
	/**
	 * 
	 * 方法描述：修改某一课程   
	 * 创建人：syd   
	 * 创建时间：2018-8-3 下午3:20:16      
	 * @param course
	 */
	void updateCourse(Course course);
	/**
	 * 
	 * 方法描述： 删除某一课程  
	 * 创建人：syd   
	 * 创建时间：2018-8-3 下午3:20:40      
	 * @param id
	 */
	void deleteCourse(String id);
	/**
	 * 方法描述： 根据年级选择课程
	 * @param gradeName
	 * @return
	 */
	List<Course> selectCourseByGradeName(String gradeName);
	/**
	 * 
	 * 方法描述：   
	 * 创建人：syd   
	 * 创建时间：2018-8-27 下午5:52:13      
	 * @return
	 */
	int selectAllCourseNum();
	List<Course> selectCourseByGradeNameAndCampusName(Course course);
}
