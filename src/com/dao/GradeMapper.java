package com.dao;

import java.util.List;

import com.pojo.Grade;

/**
 * @author syd2018-8-2����4:47:11
 * @version ����ʱ�䣺2018-8-2 ����4:47:11
 * ��˵��
 */
/**        
 * �����ƣ�GradeMapper   
 * ��������   
 * �����ˣ�syd   
 * ����ʱ�䣺2018-8-2 ����4:47:11      
 * @version    
 *    
 */
public interface GradeMapper {
	/**
	 * 
	 * ����������  ����꼶 
	 * �����ˣ�syd   
	 * ����ʱ�䣺2018-8-6 ����9:51:44      
	 * @param grade
	 */
	void  addGrade(Grade grade);
	/**
	 * 
	 * ����������ѡ�������꼶   
	 * �����ˣ�syd   
	 * ����ʱ�䣺2018-8-6 ����9:51:48      
	 * @return
	 */
	List<Grade> selectAllGrade();
	/**
	 * 
	 * ��������������id��ѯ�꼶   
	 * �����ˣ�syd   
	 * ����ʱ�䣺2018-8-6 ����9:51:51      
	 * @param id
	 * @return
	 */
	Grade selectGradeById(String id);
	/**
	 * 
	 * ���������� �޸��꼶  
	 * �����ˣ�syd   
	 * ����ʱ�䣺2018-8-6 ����9:51:55      
	 * @param grade
	 */
	void updateGrade (Grade grade);
	/**
	 * 
	 * ����������ɾ���꼶   
	 * �����ˣ�syd   
	 * ����ʱ�䣺2018-8-6 ����9:51:59      
	 * @param id
	 */
	void deleteGrade(String id);
	List<Grade> selectGradeLikeName(String name);
	 Grade selectGradeByName(String name);
}
