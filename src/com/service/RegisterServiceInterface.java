package com.service;

import java.util.List;

import com.pojo.Register;
import com.util.TheTimes;

/**
 * @author syd2018-10-10����10:02:39
 * @version ����ʱ�䣺2018-10-10 ����10:02:39
 * ��˵��
 */
/**        
 * �����ƣ�RegisterServiceInterface   
 * ��������   
 * �����ˣ�syd   
 * ����ʱ�䣺2018-10-10 ����10:02:39      
 * @version    
 *    
 */
public interface RegisterServiceInterface {
	void addRegister(Register register);
	Register selectRegisterByStuCourseId(String stuCourseId);
	int countByStuCourseId(String stuCourseId);
	List<TheTimes> selectTheTimes(String courseId);

}
