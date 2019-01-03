package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.RegisterMapper;
import com.pojo.Register;
import com.util.TheTimes;

/**
 * @author syd2018-10-10上午10:03:07
 * @version 创建时间：2018-10-10 上午10:03:07
 * 类说明
 */
/**        
 * 类名称：RegisterService   
 * 类描述：   
 * 创建人：syd   
 * 创建时间：2018-10-10 上午10:03:07      
 * @version    
 *    
 */
@Service
public class RegisterService implements RegisterServiceInterface{
	@Resource
	private RegisterMapper registerMapper;

	/* (non-Javadoc)
	 * @see com.service.RegisterServiceInterface#addRegister(com.pojo.Register)
	 */
	@Override
	public void addRegister(Register register) {
		// TODO Auto-generated method stub
		registerMapper.addRegister(register);
	}

	/* (non-Javadoc)
	 * @see com.service.RegisterServiceInterface#selectRegisterByStuCourseId(java.lang.String)
	 */
	@Override
	public Register selectRegisterByStuCourseId(String stuCourseId) {
		// TODO Auto-generated method stub
		return registerMapper.selectRegisterByStuCourseId(stuCourseId);
	}

	/* (non-Javadoc)
	 * @see com.service.RegisterServiceInterface#countByStuCourseId(java.lang.String)
	 */
	@Override
	public int countByStuCourseId(String stuCourseId) {
		// TODO Auto-generated method stub
		return registerMapper.countByStuCourseId(stuCourseId);
	}

	/* (non-Javadoc)
	 * @see com.service.RegisterServiceInterface#selectTheTimes(java.lang.String)
	 */
	@Override
	public List<TheTimes> selectTheTimes(String courseId) {
		// TODO Auto-generated method stub
		return registerMapper.selectTheTimes(courseId);
	}
	
	

}
