package com.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.AboutUsMapper;
import com.pojo.AboutUs;

/**
 * @author syd2018-9-4上午11:35:38
 * @version 创建时间：2018-9-4 上午11:35:38
 * 类说明
 */
/**        
 * 类名称：AboutUsService   
 * 类描述：   
 * 创建人：syd   
 * 创建时间：2018-9-4 上午11:35:38      
 * @version    
 *    
 */
@Service
public class AboutUsService implements AboutUsServiceInterface {
	@Resource
	private AboutUsMapper aboutUsMapper;
	
	@Override
	public void addAboutUs(AboutUs aboutUs) {
		// TODO Auto-generated method stub
		aboutUsMapper.addAboutUs(aboutUs);
	}

	/* (non-Javadoc)
	 * @see com.service.AboutUsServiceInterface#updateAboutUs(com.pojo.AboutUs)
	 */
	@Override
	public void updateAboutUs(AboutUs aboutUs) {
		// TODO Auto-generated method stub
		aboutUsMapper.updateAboutUs(aboutUs);
	}

	/* (non-Javadoc)
	 * @see com.service.AboutUsServiceInterface#selectAboutUs()
	 */
	@Override
	public AboutUs selectAboutUs() {
		// TODO Auto-generated method stub
		return aboutUsMapper.selectAboutUs();
	}

}
