package com.service;

import java.util.List;

import com.pojo.School;

public interface SchoolServiceInterface {
	/**
	 * 
	 * 方法描述：添加学校   
	 * 创建人：syd   
	 * 创建时间：2018-8-6 上午10:17:03      
	 * @param school
	 */
	void addSchool(School school);
	/**
	 * 
	 * 方法描述：查询所有学校   
	 * 创建人：syd   
	 * 创建时间：2018-8-6 上午10:17:07      
	 * @return
	 */
	List<School> selectAllSchool();
	/**
	 * 
	 * 方法描述：根据id查询   
	 * 创建人：syd   
	 * 创建时间：2018-8-6 上午10:17:10      
	 * @param id
	 * @return
	 */
	School selectSchoolById(String id);
	/**
	 * 
	 * 方法描述：修改学校   
	 * 创建人：syd   
	 * 创建时间：2018-8-6 上午10:17:14      
	 * @param school
	 */
	void updateSchool(School school);
	/**
	 * 
	 * 方法描述：删除学校   
	 * 创建人：syd   
	 * 创建时间：2018-8-6 上午10:17:18      
	 * @param id
	 */
	void deleteSchool(String id);
	/**
	 * 
	 * 方法描述：根据学校名字查询学校   
	 * 创建人：syd   
	 * 创建时间：2018-8-8 上午9:01:33      
	 * @param name
	 * @return
	 */
	School selectSchoolByName(String name);
	/**
	 * 
	 * 方法描述：根据学校名字模糊查询   
	 * 创建人：syd   
	 * 创建时间：2018-8-8 上午9:01:37      
	 * @param name
	 * @return
	 */
	List<School> selectSchoolLikeName(String name);
	/**
	 * 
	 * 方法描述：查询所有学校数量   
	 * 创建人：syd   
	 * 创建时间：2018-8-27 下午5:46:14      
	 * @return
	 */
	 int selectAllSchoolNum();
	 List<String> selectAllSchoolName();
}
