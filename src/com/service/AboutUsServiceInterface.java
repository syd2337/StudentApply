package com.service;

import com.pojo.AboutUs;

/**
 * @author syd2018-9-4上午11:34:58
 * @version 创建时间：2018-9-4 上午11:34:58
 * 类说明
 */
/**        
 * 类名称：AboutUsServiceInterface   
 * 类描述：   
 * 创建人：syd   
 * 创建时间：2018-9-4 上午11:34:58      
 * @version    
 *    
 */
public interface AboutUsServiceInterface {
	void addAboutUs(AboutUs aboutUs);
	void updateAboutUs(AboutUs aboutUs);
	AboutUs selectAboutUs();
}
