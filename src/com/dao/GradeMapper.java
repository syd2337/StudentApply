package com.dao;

import java.util.List;

import com.pojo.Grade;

/**
 * @author syd2018-8-2下午4:47:11
 * @version 创建时间：2018-8-2 下午4:47:11
 * 类说明
 */
/**        
 * 类名称：GradeMapper   
 * 类描述：   
 * 创建人：syd   
 * 创建时间：2018-8-2 下午4:47:11      
 * @version    
 *    
 */
public interface GradeMapper {
	/**
	 * 
	 * 方法描述：  添加年级 
	 * 创建人：syd   
	 * 创建时间：2018-8-6 上午9:51:44      
	 * @param grade
	 */
	void  addGrade(Grade grade);
	/**
	 * 
	 * 方法描述：选择所有年级   
	 * 创建人：syd   
	 * 创建时间：2018-8-6 上午9:51:48      
	 * @return
	 */
	List<Grade> selectAllGrade();
	/**
	 * 
	 * 方法描述：根据id查询年级   
	 * 创建人：syd   
	 * 创建时间：2018-8-6 上午9:51:51      
	 * @param id
	 * @return
	 */
	Grade selectGradeById(String id);
	/**
	 * 
	 * 方法描述： 修改年级  
	 * 创建人：syd   
	 * 创建时间：2018-8-6 上午9:51:55      
	 * @param grade
	 */
	void updateGrade (Grade grade);
	/**
	 * 
	 * 方法描述：删除年级   
	 * 创建人：syd   
	 * 创建时间：2018-8-6 上午9:51:59      
	 * @param id
	 */
	void deleteGrade(String id);
	List<Grade> selectGradeLikeName(String name);
	 Grade selectGradeByName(String name);
}
