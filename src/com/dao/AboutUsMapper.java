package com.dao;

import com.pojo.AboutUs;


/**
 * @author syd2018-9-4上午11:30:01
 * @version 创建时间：2018-9-4 上午11:30:01
 * 类说明
 */
/**        
 * 类名称：AboutUsMapper   
 * 类描述：   
 * 创建人：syd   
 * 创建时间：2018-9-4 上午11:30:01      
 * @version    
 *    
 */
public interface AboutUsMapper {
	void addAboutUs(AboutUs aboutUs);
	void updateAboutUs(AboutUs aboutUs);
	AboutUs selectAboutUs();
}
