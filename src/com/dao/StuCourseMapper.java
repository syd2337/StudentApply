package com.dao;

import java.util.List;
import java.util.Map;

import com.pojo.StuCourse;
import com.util.ShowStuCourse;

/**
 * @author syd2018-8-2����4:48:15
 * @version ����ʱ�䣺2018-8-2 ����4:48:15
 * ��˵��
 */
/**        
 * �����ƣ�StuCourseMapper   
 * ��������   
 * �����ˣ�syd   
 * ����ʱ�䣺2018-8-2 ����4:48:15      
 * @version    
 *    
 */
public interface StuCourseMapper {
	/**
	 * 
	 * �������������ѧ���γ�   
	 * �����ˣ�syd   
	 * ����ʱ�䣺2018-8-6 ����11:48:53      
	 * @param stuCourse
	 */
	void addStuCourse(StuCourse stuCourse);
	/**
	 * 
	 * ����������ѡ��ȫ��ѧ���γ�   
	 * �����ˣ�syd   
	 * ����ʱ�䣺2018-8-6 ����11:48:57      
	 * @return
	 */
	List<StuCourse> selectAllStuCourse();
	/**
	 * 
	 * ��������������id��ѯѧ���γ�   
	 * �����ˣ�syd   
	 * ����ʱ�䣺2018-8-6 ����11:49:00      
	 * @param id
	 * @return
	 */
	StuCourse selectStuCourseById(String id);
	/**
	 * 
	 * ���������� ��̬��ѯѧ���γ�  
	 * �����ˣ�syd   
	 * ����ʱ�䣺2018-8-6 ����11:49:03      
	 * @param stuCourse
	 * @return
	 */
	List<StuCourse> selectStuCourseDynamic(StuCourse stuCourse);
	/**
	 * 
	 * �����������޸�ѧ���γ�   
	 * �����ˣ�syd   
	 * ����ʱ�䣺2018-8-6 ����11:49:06      
	 * @param stuCourse
	 */
	void updateStuCourse(StuCourse stuCourse);
	/**
	 * 
	 * ����������ɾ��ѧ���γ�   
	 * �����ˣ�syd   
	 * ����ʱ�䣺2018-8-6 ����11:49:10      
	 * @param id
	 */
	void deleteStuCourse(String id);
	/**
	 * 
	 * ����������ѡ���Ŀ����4�Ƶ�   
	 * �����ˣ�syd   
	 * ����ʱ�䣺2018-8-6 ����11:49:13      
	 * @return
	 */
	List<StuCourse>selectStuCourseGtFour();
	/**
	 * 
	 * ����������ѡ���Ŀ����3�Ƶ�     
	 * �����ˣ�syd   
	 * ����ʱ�䣺2018-8-6 ����11:49:16      
	 * @return
	 */
	List<StuCourse>selectStuCourseGtThree();
	/**
	 * 
	 * ����������ѡ���Ŀ����2�Ƶ�     
	 * �����ˣ�syd   
	 * ����ʱ�䣺2018-8-6 ����11:49:20      
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
