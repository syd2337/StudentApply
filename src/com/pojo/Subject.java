package com.pojo;

import java.util.Date;

/**
 * @author syd2018-8-2下午4:00:54
 * @version 创建时间：2018-8-2 下午4:00:54
 * 类说明
 */
/**        
 * 类名称：Subject   
 * 类描述：   
 * 创建人：syd   
 * 创建时间：2018-8-2 下午4:00:54      
 * @version    
 *    
 */
public class Subject {
	/**
	 * 科目id
	 */
	private String id;
	/**
	 * 科目名称
	 */
	private String name;
	private Date createDate;
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
