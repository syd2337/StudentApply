package com.dao;

import java.util.List;

import com.pojo.Subject;

/**
 * @author syd2018-8-2����4:49:21
 * @version ����ʱ�䣺2018-8-2 ����4:49:21
 * ��˵��
 */
/**        
 * �����ƣ�SubjectMapper   
 * ��������   
 * �����ˣ�syd   
 * ����ʱ�䣺2018-8-2 ����4:49:21      
 * @version    
 *    
 */
public interface SubjectMapper {
	void addSubject(Subject subject);
	List<Subject> selectAllSubject();
	Subject selectSubjectById(String id);
	List<Subject>selectSubjectLikeName(String name);
	Subject selectSubjectByName(String name);
	void updateSubject(Subject subject);
	void deleteSubject(String id);
	
	
	
	
	
	

}
