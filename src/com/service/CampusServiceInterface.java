package com.service;

import java.util.List;

import com.pojo.Campus;

/**
 * @author syd2018-8-8下午6:45:25
 * @version 创建时间：2018-8-8 下午6:45:25
 * 类说明
 */
/**        
 * 类名称：CampusServiceInterface   
 * 类描述：   
 * 创建人：syd   
 * 创建时间：2018-8-8 下午6:45:25      
 * @version    
 *    
 */
public interface CampusServiceInterface {
	/**
	 * 
	 * 方法描述：添加校区   
	 * 创建人：syd   
	 * 创建时间：2018-8-6 上午9:11:07      
	 * @param campus
	 */
	void addCampus(Campus campus);
	/**
	 * 
	 * 方法描述：查询所有校区   
	 * 创建人：syd   
	 * 创建时间：2018-8-6 上午9:11:25      
	 * @return
	 */
	List<Campus>  selectAllCampus();
	/**
	 * 
	 * 方法描述：修改校区   
	 * 创建人：syd   
	 * 创建时间：2018-8-6 上午9:11:44      
	 * @param id
	 */
	void updateCampus(Campus campus);
	/**
	 * 
	 * 方法描述：删除校区   
	 * 创建人：syd   
	 * 创建时间：2018-8-6 上午9:11:48      
	 * @param id
	 */
	void deleteCampus(String id); 
	/**
	 * 
	 * 方法描述：  根据id查询校区 
	 * 创建人：syd   
	 * 创建时间：2018-8-6 上午9:16:40      
	 * @param id
	 * @return
	 */
	Campus selectCampusById(String id);
	/**
	 * 
	 * 方法描述：  根据名字模糊查询 
	 * 创建人：syd   
	 * 创建时间：2018-8-7 上午9:13:27      
	 * @param campusName
	 * @return
	 */
	List<Campus>selectCampusLikeName(String campusName);
	/**
	 * 
	 * 方法描述：   根据名字查询 
	 * 创建人：syd   
	 * 创建时间：2018-8-8 上午9:03:53      
	 * @param campusName
	 * @return
	 */
	Campus selectCampusByName(String campusName);
	/**
	 * 
	 * 方法描述：   
	 * 创建人：syd   
	 * 创建时间：2018-8-27 下午5:51:01      
	 * @return
	 */
	int selectAllCampusNum();
}
