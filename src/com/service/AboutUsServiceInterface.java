package com.service;

import com.pojo.AboutUs;

/**
 * @author syd2018-9-4����11:34:58
 * @version ����ʱ�䣺2018-9-4 ����11:34:58
 * ��˵��
 */
/**        
 * �����ƣ�AboutUsServiceInterface   
 * ��������   
 * �����ˣ�syd   
 * ����ʱ�䣺2018-9-4 ����11:34:58      
 * @version    
 *    
 */
public interface AboutUsServiceInterface {
	void addAboutUs(AboutUs aboutUs);
	void updateAboutUs(AboutUs aboutUs);
	AboutUs selectAboutUs();
}
