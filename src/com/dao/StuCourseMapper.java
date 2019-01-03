package com.dao;

import java.util.List;
import java.util.Map;

import com.pojo.StuCourse;
import com.util.ShowStuCourse;

/**
 * @author syd2018-8-2下午4:48:15
 * @version 创建时间：2018-8-2 下午4:48:15
 * 类说明
 */
/**        
 * 类名称：StuCourseMapper   
 * 类描述：   
 * 创建人：syd   
 * 创建时间：2018-8-2 下午4:48:15      
 * @version    
 *    
 */
public interface StuCourseMapper {
	/**
	 * 
	 * 方法描述：添加学生课程   
	 * 创建人：syd   
	 * 创建时间：2018-8-6 上午11:48:53      
	 * @param stuCourse
	 */
	void addStuCourse(StuCourse stuCourse);
	/**
	 * 
	 * 方法描述：选择全部学生课程   
	 * 创建人：syd   
	 * 创建时间：2018-8-6 上午11:48:57      
	 * @return
	 */
	List<StuCourse> selectAllStuCourse();
	/**
	 * 
	 * 方法描述：根据id查询学生课程   
	 * 创建人：syd   
	 * 创建时间：2018-8-6 上午11:49:00      
	 * @param id
	 * @return
	 */
	StuCourse selectStuCourseById(String id);
	/**
	 * 
	 * 方法描述： 动态查询学生课程  
	 * 创建人：syd   
	 * 创建时间：2018-8-6 上午11:49:03      
	 * @param stuCourse
	 * @return
	 */
	List<StuCourse> selectStuCourseDynamic(StuCourse stuCourse);
	/**
	 * 
	 * 方法描述：修改学生课程   
	 * 创建人：syd   
	 * 创建时间：2018-8-6 上午11:49:06      
	 * @param stuCourse
	 */
	void updateStuCourse(StuCourse stuCourse);
	/**
	 * 
	 * 方法描述：删除学生课程   
	 * 创建人：syd   
	 * 创建时间：2018-8-6 上午11:49:10      
	 * @param id
	 */
	void deleteStuCourse(String id);
	/**
	 * 
	 * 方法描述：选择科目大于4科的   
	 * 创建人：syd   
	 * 创建时间：2018-8-6 上午11:49:13      
	 * @return
	 */
	List<StuCourse>selectStuCourseGtFour();
	/**
	 * 
	 * 方法描述：选择科目大于3科的     
	 * 创建人：syd   
	 * 创建时间：2018-8-6 上午11:49:16      
	 * @return
	 */
	List<StuCourse>selectStuCourseGtThree();
	/**
	 * 
	 * 方法描述：选择科目大于2科的     
	 * 创建人：syd   
	 * 创建时间：2018-8-6 上午11:49:20      
	 * @return
	 */
	List<StuCourse>selectStuCourseGtTwo();
	
	 List<ShowStuCourse> allStuCoursesResult();
	 List<ShowStuCourse> StuCourseByStudentId(String studentId);
	 List<ShowStuCourse> theStuCourseByStudentId(String studentId);
	 ShowStuCourse StuCourseByStuCourseId(String stuCourseId);
	 List<ShowStuCourse>StuCourseBySubjectName(String subjectName);
	 List<StuCourse> checkStuCourseByStudentAndCourse(StuCourse stuCourse);
	 List<ShowStuCourse> StuCourseByCourseId(String courseId);
	 List<StuCourse> selectStuCourseByStudentId(String studentId);
	 List<ShowStuCourse> StuCourseByCourseIdAndTheTimes(Map<String, Object> map);
	 //List<ShowStuCourse> selectStudentDynamicNew(ShowStuCourse showStuCourse);
	 List<ShowStuCourse> selectStudentDynamicNew(Map<String, Object> map);

}
