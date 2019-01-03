package com.pojo;

import java.util.Date;

/**
 * @author syd2018-8-2下午4:18:37
 * @version 创建时间：2018-8-2 下午4:18:37
 * 类说明
 */
/**        
 * 类名称：Grade   
 * 类描述：   
 * 创建人：syd   
 * 创建时间：2018-8-2 下午4:18:37      
 * @version    
 *    
 */
public class Grade {
	/**
	 * 年级id
	 */
	private String id;
	/**
	 * 年级名字
	 */
	private String name;
	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 年级编码
	 */
	private String code;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
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
