package com.dao;

import java.util.List;

import com.pojo.Course;

/**
 * @author syd2018-8-2����4:46:39
 * @version ����ʱ�䣺2018-8-2 ����4:46:39
 * ��˵��
 */
/**        
 * �����ƣ�CourseMapper   
 * ��������   
 * �����ˣ�syd   
 * ����ʱ�䣺2018-8-2 ����4:46:39      
 * @version    
 *    
 */
public interface CourseMapper {
	/**
	 * 
	 * ������������ӿγ�   
	 * �����ˣ�syd   
	 * ����ʱ�䣺2018-8-3 ����3:17:47      
	 * @param course
	 */
	void addCourse(Course course);
	/**
	 * 
	 * ����������  ѡ�����пγ� 
	 * �����ˣ�syd   
	 * ����ʱ�䣺2018-8-3 ����3:18:11      
	 * @return
	 */
	List<Course> selectAllCourse();
	/**
	 * 
	 * ����������ѡ��γ̸��ݿγ�id   
	 * �����ˣ�syd   
	 * ����ʱ�䣺2018-8-3 ����3:18:57      
	 * @param id
	 * @return
	 */
	Course selectCourseById(String id);
	/**
	 * 
	 * ������������̬��ѯ�γ�   
	 * �����ˣ�syd   
	 * ����ʱ�䣺2018-8-3 ����3:19:37      
	 * @param course
	 * @return
	 */
	List<Course> selectCourseDynamic(Course course);
	/**
	 * 
	 * �����������޸�ĳһ�γ�   
	 * �����ˣ�syd   
	 * ����ʱ�䣺2018-8-3 ����3:20:16      
	 * @param course
	 */
	void updateCourse(Course course);
	/**
	 * 
	 * ���������� ɾ��ĳһ�γ�  
	 * �����ˣ�syd   
	 * ����ʱ�䣺2018-8-3 ����3:20:40      
	 * @param id
	 */
	void deleteCourse(String id);
	/**
	 * ���������� �����꼶ѡ��γ�
	 * @param gradeName
	 * @return
	 */
	List<Course> selectCourseByGradeName(String gradeName);
	/**
	 * 
	 * ����������   
	 * �����ˣ�syd   
	 * ����ʱ�䣺2018-8-27 ����5:52:13      
	 * @return
	 */
	int selectAllCourseNum();
	List<Course> selectCourseByGradeNameAndCampusName(Course course);
}
