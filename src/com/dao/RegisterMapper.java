package com.dao;

import java.util.List;

import com.pojo.Register;
import com.util.TheTimes;

/**
 * @author syd2018-10-10上午10:00:30
 * @version 创建时间：2018-10-10 上午10:00:30
 * 类说明
 */
/**        
 * 类名称：RegisterMapper   
 * 类描述：   
 * 创建人：syd   
 * 创建时间：2018-10-10 上午10:00:30      
 * @version    
 *    
 */
public interface RegisterMapper {
	void addRegister(Register register);
	Register selectRegisterByStuCourseId(String stuCourseId);
	int countByStuCourseId(String stuCourseId);
	List<TheTimes> selectTheTimes(String courseId);
}
