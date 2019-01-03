package com.dao;

import java.util.List;

import com.pojo.Subject;

/**
 * @author syd2018-8-2下午4:49:21
 * @version 创建时间：2018-8-2 下午4:49:21
 * 类说明
 */
/**        
 * 类名称：SubjectMapper   
 * 类描述：   
 * 创建人：syd   
 * 创建时间：2018-8-2 下午4:49:21      
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
