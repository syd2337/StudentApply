package com.dao;

import com.pojo.AboutUs;


/**
 * @author syd2018-9-4����11:30:01
 * @version ����ʱ�䣺2018-9-4 ����11:30:01
 * ��˵��
 */
/**        
 * �����ƣ�AboutUsMapper   
 * ��������   
 * �����ˣ�syd   
 * ����ʱ�䣺2018-9-4 ����11:30:01      
 * @version    
 *    
 */
public interface AboutUsMapper {
	void addAboutUs(AboutUs aboutUs);
	void updateAboutUs(AboutUs aboutUs);
	AboutUs selectAboutUs();
}
