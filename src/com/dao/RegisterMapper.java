package com.dao;

import java.util.List;

import com.pojo.Register;
import com.util.TheTimes;

/**
 * @author syd2018-10-10����10:00:30
 * @version ����ʱ�䣺2018-10-10 ����10:00:30
 * ��˵��
 */
/**        
 * �����ƣ�RegisterMapper   
 * ��������   
 * �����ˣ�syd   
 * ����ʱ�䣺2018-10-10 ����10:00:30      
 * @version    
 *    
 */
public interface RegisterMapper {
	void addRegister(Register register);
	Register selectRegisterByStuCourseId(String stuCourseId);
	int countByStuCourseId(String stuCourseId);
	List<TheTimes> selectTheTimes(String courseId);
}
